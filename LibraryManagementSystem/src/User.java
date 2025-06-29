import java.util.ArrayList;
import java.util.List;

public class User {
    private int userId;
    private String name;
    private List<Integer> borrowedBookIds = new ArrayList<>();

    public User(int userId, String name) {
        this.userId = userId;
        this.name = name;
    }

    public int getUserId() { return userId; }
    public String getName() { return name; }
    public List<Integer> getBorrowedBookIds() { return borrowedBookIds; }

    public void borrowBook(int bookId) {
        borrowedBookIds.add(bookId);
    }

    public void returnBook(int bookId) {
        borrowedBookIds.remove(Integer.valueOf(bookId));
    }

    @Override
    public String toString() {
        return userId + " - " + name + ", Borrowed Books: " + borrowedBookIds;
    }
}
