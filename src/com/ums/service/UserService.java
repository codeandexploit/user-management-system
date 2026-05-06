package com.ums.service;

import com.ums.model.User;
import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class UserService {

    private List<User> users = new ArrayList<>();

    // LOAD USERS FROM FILE
    public void loadUsersFromFile() {
        try (BufferedReader br = new BufferedReader(new FileReader("users.txt"))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                int id = Integer.parseInt(data[0]);
                String name = data[1];
                String email = data[2];

                users.add(new User(id, name, email));
            }

        } catch (IOException e) {
            System.out.println("Error reading file");
        }
    }

    // CREATE
    public void addUser(User user) {
        users.add(user);

        try (FileWriter fw = new FileWriter("users.txt", true)) {
            fw.write(user.getId() + "," + user.getName() + "," + user.getEmail() + "\n");
        } catch (IOException e) {
            System.out.println("Error writing to file");
        }
    }

    // READ ALL
    public void displayAllUsers() {
        for (User user : users) {
            user.displayUser();
            System.out.println("------------");
        }
    }

    // UPDATE
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

    // DELETE
    public void deleteUser(int id) {
        users.removeIf(user -> user.getId() == id);
        System.out.println("User deleted if existed");
    }

    // SEARCH
    public User getUserById(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }
}