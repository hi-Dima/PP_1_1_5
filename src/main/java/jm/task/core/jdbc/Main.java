package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        UserService us = new UserServiceImpl();
        us.createUsersTable();
        us.saveUser("Олег1", "Иванов", (byte) 36);
        us.saveUser("Олег2", "Иванов", (byte) 36);
        us.saveUser("Олег3", "Иванов", (byte) 36);
        us.saveUser("Олег4", "Иванов", (byte) 36);
        us.removeUserById(3);
        System.out.println(us.getAllUsers());
    }
}
