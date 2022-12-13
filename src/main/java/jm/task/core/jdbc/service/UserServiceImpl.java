package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.model.User;


import java.util.List;

public class UserServiceImpl implements UserService {
    UserDao userDaoH = new UserDaoHibernateImpl();
    public void createUsersTable() { userDaoH.createUsersTable();

    }

    public void dropUsersTable() { userDaoH.dropUsersTable();

    }

    public void saveUser(String name, String lastName, byte age) {
        userDaoH.saveUser(name,lastName,age);
    }

    public void removeUserById(long id) {
        userDaoH.removeUserById(id);
    }

    public List<User> getAllUsers() {
        return userDaoH.getAllUsers();
    }

    public void cleanUsersTable() {
        userDaoH.cleanUsersTable();
    }
}
