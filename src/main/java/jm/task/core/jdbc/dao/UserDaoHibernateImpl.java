package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

import static jm.task.core.jdbc.util.Util.getSessionFactory;

public class UserDaoHibernateImpl implements UserDao {
    private static SessionFactory factory = getSessionFactory();
    public UserDaoHibernateImpl() {
    }

    @Override
    public void createUsersTable() {

        try(Session session = factory.getCurrentSession()){
            session.beginTransaction();


            Query query = session.createSQLQuery("""
                            CREATE TABLE IF NOT EXISTS Usersss
                            (id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
                            name varchar(50) NOT NULL, 
                            lastName varchar(50) NOT NULL,
                            age int NOT NULL);
                            """);
            query.executeUpdate();
            session.getTransaction().commit();
        }
    }

    @Override
    public void dropUsersTable() {
        try(Session session = factory.getCurrentSession()){
            session.beginTransaction();
            Query query = session.createSQLQuery("DROP TABLE  if exists Usersss");
            query.executeUpdate();
            session.getTransaction().commit();
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        try(Session session = factory.getCurrentSession()){
            session.beginTransaction();
            User user = new User(name,lastName,age);
            session.save(user);
            session.getTransaction().commit();
        }


    }

    @Override
    public void removeUserById(long id) {
        try(Session session = factory.getCurrentSession()){
            session.beginTransaction();
            User user = session.get(User.class, id);
            session.delete(user);
            session.getTransaction().commit();
        }
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users;
        try(Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            Query query = session.createSQLQuery("SELECT * FROM Usersss").addEntity(User.class);
            users = query.list();
            session.getTransaction().commit();
        }
        return users ;
    }

    @Override
    public void cleanUsersTable() {
        try(Session session = factory.getCurrentSession()){
            session.beginTransaction();
            Query query = session.createSQLQuery("TRUNCATE TABLE Usersss");
            query.executeUpdate();
            session.getTransaction().commit();
        }
    }
}
