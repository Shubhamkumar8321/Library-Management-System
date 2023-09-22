package Library_Management_System.Transection;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
public class Book_Transaction_Manager {
    ObjectOutputStream oos_Book_Transaction=null;
    ObjectInputStream ois_Book_Transaction=null;
    ArrayList<Book_Transaction> Book_Transaction_list=null;
    File Book_Transaction_file=null;
    public Book_Transaction_Manager() throws IOException {
        Book_Transaction_file=new File("Book_Transaction.dat");
        Book_Transaction_list=new ArrayList<Book_Transaction>();
        if (Book_Transaction_file.exists()) {
            try {
                ois_Book_Transaction = new ObjectInputStream(new FileInputStream(Book_Transaction_file));
                Book_Transaction_list = (ArrayList<Library_Management_System.Transection.Book_Transaction>) ois_Book_Transaction.readObject();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException cnf) {
                cnf.printStackTrace();
            }
        }
    }
    public boolean issueBook(int roll,int isbn){
        int total_books_issue=0;
        for (Book_Transaction book_transaction:Book_Transaction_list)
            if ((book_transaction.getRoll()==roll)&&(book_transaction.getReturnDate()==null))
                total_books_issue +=1;
        if (total_books_issue>=3)
            return false;
        String BookissueDate=new SimpleDateFormat("dd-mm-yyyy").format(new Date());
        Book_Transaction book_transaction=new Book_Transaction(isbn ,roll,BookissueDate,null);
        Book_Transaction_list.add(book_transaction);
        return false;
    }
    public boolean  returnBook(int roll,int isbn){
        for (Book_Transaction book_transaction:Book_Transaction_list){
            if ((book_transaction.getRoll()==roll)&& (book_transaction.getIsbn()==isbn)&&(book_transaction.getReturnDate()==null)){
                String Return_Date=new SimpleDateFormat("dd-mm-yyyy").format(new Date());
                book_transaction.setReturnDate(Return_Date);
                return true;
            }
        }
        return false;
    }
    public void viewAll(){
        for (Book_Transaction BT:Book_Transaction_list){
            System.out.println(BT);
        }
    }
    public void writeToFile() throws IOException {
        oos_Book_Transaction=new ObjectOutputStream(new FileOutputStream(Book_Transaction_file));
        oos_Book_Transaction.writeObject(Book_Transaction_list);
    }
}
