package Library_Management_System.Transection;

import java.io.Serializable;

public class Book_Transaction implements Serializable {
    private int Isbn;
    private int roll;
    private String IssueDate;
    private String returnDate;
    public int getIsbn() {
        return Isbn;
    }

    public void setIsbn(int isbn) {
        Isbn = isbn;
    }

    public int getRoll() {
        return roll;
    }

    public void setRoll(int roll) {
        this.roll = roll;
    }

    public String getIssueDate() {
        return IssueDate;
    }

    public void setIssueDate(String issueDate) {
        IssueDate = issueDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }
    public Book_Transaction(int isbn, int roll, String issueDate, String returnDate) {
        Isbn = isbn;
        this.roll = roll;
        IssueDate = issueDate;
        this.returnDate = returnDate;
    }

    @Override
    public String toString() {
        return "Book_Transaction{" +
                "Isbn=" + Isbn + ", roll=" + roll + ", IssueDate='" + IssueDate + ", returnDate='" + returnDate + '}';
    }
}
