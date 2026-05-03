package com.ums.service;

import com.ums.model.User;
import java.util.ArrayList;
import java.util.List;

public class UserService {
    private List<User> users = new ArrayList<>();

    public void addUser(User user) {
        users.add(user);
    }

    public void displayAllUsers() {
        for (User user : users) {
            user.displayUser();
            System.out.println("------------");
        }
    }

    public void updateUser(int id, String newName) {
        for (User user : users) {
            if (user.getId() == id) {
                user.setName(newName);
                System.out.println("User updated successfully");
                return;
            }
        }
        System.out.println("User not found");
    }

    public void deleteUser(int id) {
        users.removeIf(user -> user.getId() == id);
        System.out.println("User deleted if existed");
    }

    public User getUserById(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }
}