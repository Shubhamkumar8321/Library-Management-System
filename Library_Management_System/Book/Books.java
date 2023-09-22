package Library_Management_System.Book;

import java.io.Serializable;

public class Books implements Serializable {
    private int Isbn;
    private String Title;
    private String Author;
    private  String Subject;
    private int Available;
    public int getIsbn() {
        return Isbn;
    }
    public void setIsbn(int isbn) {
        Isbn = isbn;
    }
    public String getTitle() {
        return Title;
    }
    public void setTitle(String title) {
        Title = title;
    }
    public String getAuthor() {
        return Author;
    }
    public void setAuthor(String author) {
        Author = author;
    }
    public String getSubject() {
        return Subject;
    }
    public void setSubject(String subject) {
        Subject = subject;
    }
    public int getAvailable() {
        return Available;
    }
    public void setAvailable(int available) {
        Available = available;
    }
    @Override
    public String toString() {
        return "Books{" + "Isbn=" + Isbn + ", Title= " + Title + ", Author='" + Author + ", Subject='" + Subject + ", Available=" + Available + '}';
    }
    public Books(int isbn, String title, String author,String subject,int available) {
        Isbn = isbn;
        Title = title;
        Author = author;
        Subject = subject;
        Available = available;
    }
}