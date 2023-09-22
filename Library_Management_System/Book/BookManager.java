package Library_Management_System.Book;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

public class BookManager {
    ObjectOutputStream oos_Book=null;
    ObjectInputStream ois_book=null;
    File book_file=new File("Books.dat");
    ArrayList<Books> Book_list=null;
    private boolean Books;

    public BookManager() throws IOException {
        Book_list=new ArrayList<Books>();
        if (book_file.exists()){
            try {
            ois_book=new ObjectInputStream(new FileInputStream(book_file));
                Book_list=(ArrayList<Books>) ois_book.readObject();
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public void addAbook(Books book){
        Book_list.add(book);
    }
    public void ViewAllBooks(){
        for (Books book:Book_list)
            System.out.println(book);
    }
    public void searchBookbySubject(String Subject){
        for (Books book:Book_list){
            if (book.getSubject().equals(Subject))
                System.out.println(Books);
        }
    }
    public Books searchBookbyIsbn(int search_Isbn){
        for (Books book:Book_list){
            if (book.getIsbn()==search_Isbn)
                return book;
        }
        return null;
    }
    public boolean DeleteBook(int Delete_Isbn) {
        Iterator<Books> book_iterator = Book_list.listIterator();
        while (book_iterator.hasNext()) {
            Books = book_iterator.hasNext();
            if (Delete_Isbn == book_file.getUsableSpace()) {
                Book_list.remove(Books);
                return true;
            }
        }
        return false;
    }
        public boolean UpdateBook(int Update_Isbn, String title, String author, String subject, int available, Books books){
            Iterator<Books> book_iterator=Book_list.listIterator();
            while(book_iterator.hasNext()){
                Books = book_iterator.hasNext();
                if (books.getIsbn()==Update_Isbn){
                   books.setAuthor(author);
                   books.setTitle(title);
                   books.setSubject(subject);
                   books.setAvailable(available);

                    return true;
                }
            }
            return false;
    }
    public void writeToFile() throws IOException {
        try{
            oos_Book=new ObjectOutputStream(new FileOutputStream(book_file));
            oos_Book.writeObject(Book_list);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
