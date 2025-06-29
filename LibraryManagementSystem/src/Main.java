import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library library = new Library();
        int choice;

        do {
            System.out.println("\n========== Library Management Menu ==========");
            System.out.println("1. Add Book");
            System.out.println("2. Add User");
            System.out.println("3. View Books");
            System.out.println("4. View Users");
            System.out.println("5. Issue Book");
            System.out.println("6. Return Book");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter Book ID: ");
                    int id = sc.nextInt(); sc.nextLine();
                    System.out.print("Enter Book Title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter Author: ");
                    String author = sc.nextLine();
                    library.addBook(new Book(id, title, author));
                }
                case 2 -> {
                    System.out.print("Enter User ID: ");
                    int userId = sc.nextInt(); sc.nextLine();
                    System.out.print("Enter User Name: ");
                    String userName = sc.nextLine();
                    library.addUser(new User(userId, userName));
                }
                case 3 -> library.viewBooks();
                case 4 -> library.viewUsers();
                case 5 -> {
                    System.out.print("Enter Book ID to issue: ");
                    int bookId = sc.nextInt();
                    System.out.print("Enter User ID: ");
                    int userId = sc.nextInt();
                    library.issueBook(bookId, userId);
                }
                case 6 -> {
                    System.out.print("Enter Book ID to return: ");
                    int bookId = sc.nextInt();
                    System.out.print("Enter User ID: ");
                    int userId = sc.nextInt();
                    library.returnBook(bookId, userId);
                }

                case 7 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice.");
            }

        } while (choice != 7);

        sc.close();
    }
}
