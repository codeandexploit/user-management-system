package com.ums;

import com.ums.model.User;
import com.ums.service.UserService;

public class Main {
    public static void main(String[] args) {

        UserService service = new UserService();

        service.addUser(new User(1, "Ravi", "ravi@email.com"));
        service.addUser(new User(2, "John", "john@email.com"));

        service.displayAllUsers();
    }
}