
package com.mycompany.main;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            EventOperations operations = new EventOperations();
            Scanner scanner = new Scanner(System.in);
            int choice;

            do {
                System.out.println("\n--- Event Management System ---");
                System.out.println("1. Add Event");
                System.out.println("2. View All Events");
                System.out.println("3. Update Event");
                System.out.println("4. Delete Event");
                System.out.println("5. Mark Event as Completed");
                System.out.println("0. Exit");
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        System.out.print("Enter title: ");
                        String title = scanner.nextLine();
                        System.out.print("Enter description: ");
                        String description = scanner.nextLine();
                        System.out.print("Enter category ID: ");
                        int categoryId = scanner.nextInt();
                        operations.addEvent(new Event(title, description, categoryId));
                        break;

                    case 2:
                        operations.getEvents().forEach(System.out::println);
                        break;

                    case 3:
                        System.out.print("Enter Event ID to update: ");
                        int updateId = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter new title: ");
                        String newTitle = scanner.nextLine();
                        System.out.print("Enter new description: ");
                        String newDescription = scanner.nextLine();
                        System.out.print("Enter new category ID: ");
                        int newCategoryId = scanner.nextInt();
                        operations.updateEvent(updateId, newTitle, newDescription, newCategoryId);
                        break;

                    case 4:
                        System.out.print("Enter Event ID to delete: ");
                        int deleteId = scanner.nextInt();
                        operations.deleteEvent(deleteId);
                        break;

                    case 5:
                        System.out.print("Enter Event ID to mark as completed: ");
                        int completeId = scanner.nextInt();
                        operations.markAsCompleted(completeId);
                        break;

                    case 0:
                        System.out.println("Exiting...");
                        break;

                    default:
                        System.out.println("Invalid choice! Please try again.");
                }
            } while (choice != 0);

            scanner.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

