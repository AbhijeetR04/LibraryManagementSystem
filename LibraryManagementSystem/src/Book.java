public class Book {
    private int id;
    private String title;
    private String author;
    private boolean isIssued;
    private int issuedToUserId = -1;  // -1 means not issued

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public boolean isIssued() { return isIssued; }
    public int getIssuedToUserId() { return issuedToUserId; }

    public void issue(int userId) {
        isIssued = true;
        issuedToUserId = userId;
    }

    public void returnBook() {
        isIssued = false;
        issuedToUserId = -1;
    }

    @Override
    public String toString() {
        return id + " - " + title + " by " + author +
                (isIssued ? " [Issued to User ID: " + issuedToUserId + "]" : " [Available]");
    }
}
