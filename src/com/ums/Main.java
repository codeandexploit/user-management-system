package com.ums;

import com.ums.model.User;
import com.ums.service.UserService;

public class Main {
    public static void main(String[] args) {

        UserService service = new UserService();

        // CREATE
        service.addUser(new User(1, "Ravi", "ravi@email.com"));
        service.addUser(new User(2, "John", "john@email.com"));

        System.out.println("=== All Users ===");
        service.displayAllUsers();

        // UPDATE
        service.updateUser(1, "Ravi Kumar");

        System.out.println("=== After Update ===");
        service.displayAllUsers();

        // DELETE
        service.deleteUser(2);

        System.out.println("=== After Delete ===");
        service.displayAllUsers();
    }
}