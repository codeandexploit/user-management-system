package com.ums.controller;

import com.ums.model.User;
import com.ums.service.UserService;
import java.util.Scanner;

public class UserController {

    private UserService service = new UserService();
    private Scanner scanner = new Scanner(System.in);

    public void runApp() {

        while (true) {
            System.out.println("\n=== User Management Menu ===");
            System.out.println("1. Add User");
            System.out.println("2. View All Users");
            System.out.println("3. Update User");
            System.out.println("4. Delete User");
            System.out.println("5. Search User");
            System.out.println("6. Exit");

            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // clear buffer

                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter Email: ");
                    String email = scanner.nextLine();

                    service.addUser(new User(id, name, email));
                    System.out.println("User added successfully");
                    break;

                case 2:
                    service.displayAllUsers();
                    break;

                case 3:
                    System.out.print("Enter ID to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter new name: ");
                    String newName = scanner.nextLine();

                    service.updateUser(updateId, newName);
                    break;

                case 4:
                    System.out.print("Enter ID to delete: ");
                    int deleteId = scanner.nextInt();

                    service.deleteUser(deleteId);
                    break;

                case 5:
                    System.out.print("Enter ID to search: ");
                    int searchId = scanner.nextInt();

                    User user = service.getUserById(searchId);

                    if (user != null) {
                        user.displayUser();
                    } else {
                        System.out.println("User not found");
                    }
                    break;

                case 6:
                    System.out.println("Exiting application...");
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}