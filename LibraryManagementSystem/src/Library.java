import java.util.*;

public class Library {
    private List<Book> books = new ArrayList<>();
    private List<User> users = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added: " + book.getTitle());
    }

    public void addUser(User user) {
        users.add(user);
        System.out.println("User added: " + user.getName());
    }

    public void viewBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in library.");
            return;
        }
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public void viewUsers() {
        if (users.isEmpty()) {
            System.out.println("No users registered.");
            return;
        }
        for (User user : users) {
            System.out.println(user);
        }
    }
    private User findUserById(int userId) {
        for (User user : users) {
            if (user.getUserId() == userId) return user;
        }
        return null;
    }

    public void issueBook(int bookId, int userId) {
        Book book = null;
        for (Book b : books) {
            if (b.getId() == bookId) {
                book = b;
                break;
            }
        }

        if (book == null) {
            System.out.println("Book not found.");
            return;
        }

        if (book.isIssued()) {
            System.out.println("Book is already issued.");
            return;
        }

        User user = findUserById(userId);
        if (user == null) {
            System.out.println("User not found.");
            return;
        }

        book.issue(userId);
        user.borrowBook(bookId);
        System.out.println("Book issued to " + user.getName());
    }

    public void returnBook(int bookId, int userId) {
        Book book = null;
        for (Book b : books) {
            if (b.getId() == bookId) {
                book = b;
                break;
            }
        }

        if (book == null) {
            System.out.println("Book not found.");
            return;
        }

        if (!book.isIssued() || book.getIssuedToUserId() != userId) {
            System.out.println("This book was not issued to this user.");
            return;
        }

        User user = findUserById(userId);
        if (user == null) {
            System.out.println("User not found.");
            return;
        }

        book.returnBook();
        user.returnBook(bookId);
        System.out.println("Book returned by " + user.getName());
    }

}

