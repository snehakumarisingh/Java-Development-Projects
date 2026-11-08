
import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Book> books = new ArrayList<>();

        int choice;

        do {
            System.out.println("\n===== LIBRARY MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Display Available Books");
            System.out.println("4. Search Book");
            System.out.println("5. Issue Book");
            System.out.println("6. Return Book");
            System.out.println("7. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    sc.nextLine();

                    System.out.print("Enter Book ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    boolean exists = false;

                    for (Book book : books) {
                        if (book.getId() == id) {
                            exists = true;
                            break;
                        }
                    }

                    if (exists) {
                        System.out.println("Book ID already exists!");
                        break;
                    }

                    System.out.print("Enter Book Title: ");
                    String title = sc.nextLine();

                    System.out.print("Enter Author Name: ");
                    String author = sc.nextLine();

                    Book newBook = new Book(id, title, author);
                    books.add(newBook);

                    System.out.println("Book added successfully!");
                    break;

                
                case 2:
                    System.out.print("Enter Book ID to remove: ");
                    int removeId = sc.nextInt();

                    boolean removed = false;

                    for (Book book : books) {
                        if (book.getId() == removeId) {
                            books.remove(book);
                            removed = true;
                            break;
                        }
                    }

                    if (removed) {
                        System.out.println("Book removed successfully!");
                    } else {
                        System.out.println("Book not found!");
                    }

                    break;

                case 3:
                    boolean found = false;

                    System.out.println("\nAvailable Books:");

                    for (Book book : books) {
                        if (!book.isIssued()) {
                            System.out.println("ID: " + book.getId());
                            System.out.println("Title: " + book.getTitle());
                            System.out.println("Author: " + book.getAuthor());
                            System.out.println("--------------------");

                            found = true;
                        }
                    }

                    if (!found) {
                        System.out.println("No available books found!");
                    }

                    break;

                case 4:
                    sc.nextLine();
                    System.out.println("Search by:");
                    System.out.println("1. Book ID");
                    System.out.println("2. Book Title");
                    System.out.print("Enter choice: ");

                    int searchChoice = sc.nextInt();
                    sc.nextLine();
                    boolean bookFound = false;
                    if (searchChoice == 1) {
                        System.out.print("Enter Book ID: ");
                        int searchId = sc.nextInt();
                        for (Book book : books) {
                            if (book.getId() == searchId) {
                                System.out.println("Book Found!");
                                System.out.println("ID: " + book.getId());
                                System.out.println("Title: " + book.getTitle());
                                System.out.println("Author: " + book.getAuthor());
                                bookFound = true;
                                break;
                            }
                        }
                    } else if (searchChoice == 2) {
                        System.out.print("Enter Book Title: ");
                        String searchTitle = sc.nextLine();
                        for (Book book : books) {
                            if (book.getTitle().equalsIgnoreCase(searchTitle)) {
                                System.out.println("Book Found!");
                                System.out.println("ID: " + book.getId());
                                System.out.println("Title: " + book.getTitle());
                                System.out.println("Author: " + book.getAuthor());
                                bookFound = true;
                                break;
                            }
                        }
                    } else {
                        System.out.println("Invalid search choice!");
                        break;
                    }
                    if (!bookFound) {
                        System.out.println("Book not found!");
                    }

                    break;

                case 5:
                    System.out.print("Enter Book ID to issue: ");
                    int issueId = sc.nextInt();
                    boolean issueFound = false;
                    for (Book book : books) {
                        if (book.getId() == issueId) {
                            issueFound = true;
                            if (book.isIssued()) {
                                System.out.println("Book is already issued!");
                            } else {
                                book.setIssued(true);
                                System.out.println("Book issued successfully!");
                            }
                            break;
                        }
                    }
                    if (!issueFound) {
                        System.out.println("Book not found!");
                    }

                    break;

                case 6:
                    System.out.print("Enter Book ID to return: ");
                    int returnId = sc.nextInt();

                    boolean returnFound = false;

                    for (Book book : books) {
                        if (book.getId() == returnId) {
                            returnFound = true;

                            if (book.isIssued()) {
                                book.setIssued(false);
                                System.out.println("Book returned successfully!");
                            } else {
                                System.out.println("This book was not issued!");
                            }

                            break;
                        }
                    }

                    if (!returnFound) {
                        System.out.println("Book not found!");
                    }

                    break;

                case 7:
                    System.out.println("Thank you for using Library Management System!");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }

        } while (choice != 7);

        sc.close();
    }
}
