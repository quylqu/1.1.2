package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    private final static UserService userService = new UserServiceImpl();
    public static void main(String[] args) {
        userService.createUsersTable();

        userService.saveUser("NameOne", "LastNameOne", (byte) 10);
        userService.saveUser("NameTwo", "LastNameTwo", (byte) 20);
        userService.saveUser("NameThree", "LastNameThree", (byte) 30);
        userService.saveUser("NameFour", "LastNameFour", (byte) 40);
        userService.getAllUsers();
        userService.cleanUsersTable();
        userService.dropUsersTable();
    }
}
