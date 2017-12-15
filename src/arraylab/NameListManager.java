/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arraylab;

import java.util.Scanner;

/**
 *
 * @author ektasharma
 */
public class NameListManager {

    private static NameDB nameList = new NameDB(10);
    private static Scanner keyBoard = new Scanner(System.in);

    public static void nameDBMenu() {

        int choice = 0;
        do {
            System.out.println("***Name Database Menu***");
            System.out.println("1. Add a new name");
            System.out.println("2. Find a name");
            System.out.println("3. Update a name");
            System.out.println("4. Delete a name");
            System.out.println("9. Exit");
            System.out.print("Enter your choice -> ");
            choice = Integer.parseInt(keyBoard.nextLine());
            if (choice == 1) {
                addName(createName());
            } else if (choice == 2) {
                findName(createName());
            } else if (choice == 3) {
                updateName(createName(), createUpdatingName());
            } else if (choice == 4) {
                deleteName(createName());
            } else if (choice == 5) {
                printName();
            } else if (choice != 9) {
                System.err.println("Invalid choice!!!");
            }

        } while (choice != 9);
    }

    public static void addName(String name) {
        if (nameList.addName(name)) {
            System.out.println("Name is added successfully");
        } else {
            System.out.println("Failed to add name as the list is full");
        }
    }

    public static void printName() {
    }

    public static void findName(String name) {
        if (nameList.findName(name) >= 0) {
            System.out.println("Name is found successfully");
        } else {
            System.out.println("Name is not in the list.");
        }
    }

    public static String createName() {
        System.out.print("Enter the name : ");
        String name = keyBoard.nextLine();
        return name;
    }

    public static String createUpdatingName() {
        System.out.print("Enter the new name to update : ");
        String name = keyBoard.nextLine();
        return name;
    }

    public static void updateName(String name, String updatedName) {
        if (nameList.updateName(name, updatedName)) {
            System.out.println("Name is updated successfully");
        } else {
            System.out.println("Failed to update name");
        }
    }

    public static void deleteName(String name) {
        if (nameList.deleteName(name)) {
            System.out.println("Name is deleted successfully");
        } else {
            System.out.println("Failed to delete name");
        }
    }

}
