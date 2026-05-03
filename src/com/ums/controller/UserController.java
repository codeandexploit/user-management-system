package com.ums.controller;

import com.ums.model.User;
import com.ums.service.UserService;

public class UserController {

    private UserService service = new UserService();

    public void runApp() {

        service.addUser(new User(1, "Ravi", "ravi@email.com"));
        service.addUser(new User(2, "John", "john@email.com"));

        System.out.println("=== All Users ===");
        service.displayAllUsers();

        service.updateUser(1, "Ravi Kumar");

        System.out.println("=== After Update ===");
        service.displayAllUsers();

        service.deleteUser(2);

        System.out.println("=== After Delete ===");
        service.displayAllUsers();

        System.out.println("=== Search User ===");
        User user = service.getUserById(1);

        if (user != null) {
            user.displayUser();
        } else {
            System.out.println("User not found");
        }
    }
}