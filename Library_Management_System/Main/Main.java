package Library_Management_System.Main;

import Library_Management_System.Exception.BookNotFoundException;
import Library_Management_System.Exception.StudentNotFoundException;
import Library_Management_System.Person.Student;
import Library_Management_System.Person.StudentManager;
import Library_Management_System.Transection.Book_Transaction_Manager;
import Library_Management_System.Book.BookManager;
import Library_Management_System.Book.Books;
import java.io.IOException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws IOException, StudentNotFoundException {
        int Choice;
        Scanner sc=new Scanner(System.in);
        BookManager bm=new BookManager();
        StudentManager sm=new StudentManager();
        Book_Transaction_Manager Btm=new Book_Transaction_Manager();
        do {
            System.out.println("Enter 1 if you are Student");
            System.out.println("Enter 2 if you are Librarian");
            System.out.println("Enter 3 if you want to Exit..");
            Choice= sc.nextInt();
            if (Choice == 1) {
                System.out.println("Enter your Roll Number : ");
                int RollNo= sc.nextInt();
                try{
                    Student s=sm.get(RollNo);
                    if(s==null)
                        throw new StudentNotFoundException();
                    int Student_Choice;
                    Student_Choice = sc.nextInt();
                        do {
                            System.out.println("Enter 1 to View All Books : ");
                            System.out.println("Enter 2 to Search Books by Isbn : ");
                            System.out.println("Enter 3 to Search Books by Subject : ");
                            System.out.println("Enter 4 to Issue Books : ");
                            System.out.println("Enter 5 to return Books : ");
                            System.out.println("Enter 99 to Exits..... ");
                            switch (Student_Choice) {
                                case 1:
                                    System.out.println("View All Selected");
                                    bm.ViewAllBooks();
                                    break;
                                case 2:
                                    System.out.println("Search By Isbn ");
                                    int search_isbn=sc.nextInt();
                                    Books book=bm.searchBookbyIsbn(search_isbn);
                                    if (book==null)
                                        System.out.println("No book with this isbn  ");
                                    else
                                        System.out.println(book);
                                    break;
                                case 3:
                                    System.out.println("Search By Subject to Search ");
                                    sc.nextLine();
                                    String Search_Sub=sc.nextLine();
                                    bm.searchBookbySubject(Search_Sub);
                                    break;
                                case 4:
                                    System.out.println("Issues of book ");
                                    System.out.println("Enter the ISBN to Issue the books ");
                                    int Issue_Isbn=sc.nextInt();
                                    Books books=bm.searchBookbyIsbn(Issue_Isbn);
                                    try {
                                        if (books == null) {
                                            throw new BookNotFoundException();
                                        }
                                        if (books.getAvailable()>0){
                                            if (Btm.issueBook(RollNo,Issue_Isbn)){
                                                books.setAvailable(books.getAvailable()-1);
                                                System.out.println("Book Has Been Issues..");
                                            }
                                        }else{
                                            System.out.println("The book is not available....");
                                        }
                                    }catch (BookNotFoundException bf){
                                        System.out.println(bf);
                                    }
                                    break;
                                case 5:
                                    System.out.println("Enter for Return of Books");
                                    int return_isbn=sc.nextInt();
                                    books=bm.searchBookbyIsbn(return_isbn);
                                    if (books!=null){
                                    if (Btm.returnBook(RollNo,return_isbn)){
                                        books.setAvailable(books.getAvailable()+1);
                                        System.out.println("THANK you " );
                                    }else{
                                        System.out.println("not return the books");
                                    }
                                }else {
                                        System.out.println("Isbn not matched");
                                    }
                                    break;
                                case 99:
                                    System.out.println("Thank you for Using .....");
                                    break;
                                default:
                                    System.out.println("Invalid Choice...");
                            }
                        } while (Student_Choice != 99);
                }catch(StudentNotFoundException S){
                    S.printStackTrace();
                }
            } else if (Choice == 2) {
                int Librarian_Choice;
                do {
                    System.out.println("Enter 11 to view all Students");
                    System.out.println("Enter 12 to Print a Student by Roll Number ");
                    System.out.println("Enter 13 to Register a Student ");
                    System.out.println("Enter 14 to Update a Student ");
                    System.out.println("Enter 15 to Delete a Student ");
                    System.out.println("Enter 21 to view all Books");
                    System.out.println("Enter 22 to Print a book by ISBN ");
                    System.out.println("Enter 23 to Add a Book ");
                    System.out.println("Enter 24 to Update a Book ");
                    System.out.println("Enter 25 to Delete a Student ");
                    System.out.println("enter 31 to View All Transaction");
                    System.out.println("Enter 99 to Exits..... ");
                    Librarian_Choice = sc.nextInt();
                    switch (Librarian_Choice) {
                        case 11:
                            System.out.println("All the Student Records");
                            sm.viewAllStudent();
                            break;
                        case 12:
                            System.out.println("Enter Roll Number  ");
                            int get_RollNo = sc.nextInt();
                            Student student = sm.get(get_RollNo);
                            if (student == null) {
                                System.out.println("No Records Matches this Roll number ");
                            } else
                                System.out.println(student);
                            break;
                        case 13:
                            System.out.println("Enter Students Details");
                            String name;
                            String email;
                            String phone;
                            String address;
                            String DOB;
                            int roll;
                            int std;
                            String division;
                            sc.nextLine();
                            System.out.println("Name");
                            name = sc.nextLine();
                            System.out.println("Email");
                            email = sc.nextLine();
                            System.out.println("Phone Number");
                            phone = sc.nextLine();
                            System.out.println("Address ");
                            address = sc.nextLine();
                            System.out.println("Date of Birth");
                            DOB = sc.nextLine();
                            System.out.println("Roll Number ");
                            roll = sc.nextInt();
                            System.out.println("Study ");
                            std = sc.nextInt();
                            System.out.println("Division");
                            division = sc.nextLine();
                            sc.nextLine();
                            student = new Student(name, email, phone, address, DOB, roll, std, division);
                            sm.addStudent(student);
                            System.out.println("Student is Added ");
                            break;
                        case 14:
                            System.out.println("Enter the Roll Number to Updates Details ");
                            int modify_roll;
                            modify_roll = sc.nextInt();
                            student = sm.get(modify_roll);
                            try {
                                if (student == null)
                                    throw new StudentNotFoundException();
                                System.out.println("Name");
                                name = sc.nextLine();
                                System.out.println("Email");
                                email = sc.nextLine();
                                System.out.println("Phone Number");
                                phone = sc.nextLine();
                                System.out.println("Address ");
                                address = sc.nextLine();
                                System.out.println("Date of Birth");
                                DOB = sc.nextLine();
                                System.out.println("Study ");
                                std = sc.nextInt();
                                System.out.println("Division");
                                division = sc.nextLine();
                                sm.UpdateStudent(modify_roll,name, email, phone, address, DOB, std, division);
                                System.out.println("Student Record Updated...");
                                break;
                            } catch (StudentNotFoundException S) {
                                S.printStackTrace();
                            }
                        case 15:
                            System.out.println("Enter the Roll Number to Updates Details ");
                            int delete_roll;
                            delete_roll = sc.nextInt();
                            if (sm.deleteStudent(delete_roll)) {
                                System.out.println("Student is Remove ...");
                            } else {
                                System.out.println("Given Roll number is not exists...");
                            }
                            break;
                        case 21:
                            bm.ViewAllBooks();
                            break;
                        case 22:
                            int Search_Isbn;
                            System.out.println("Enter ISBN ");
                            Search_Isbn=sc.nextInt();
                           Books book= bm.searchBookbyIsbn(Search_Isbn);
                           if(book==null){
                               System.out.println("No book for this ISBN Existing ..");
                           }else{
                               System.out.println(book);
                           }
                           break;
                        case 23:
                            System.out.println("Enter Book Details ");
                             int Isbn;
                             String Title;
                             String Author;
                             String Subject;
                             int Available;
                            System.out.println("Enter ISBN ");
                             Isbn= sc.nextInt();
                            System.out.println("Enter Title ");
                            Title=sc.nextLine();
                            sc.nextLine();
                            System.out.println("Enter Author name");
                            Author= sc.nextLine();
                            System.out.println("Subject");
                            Subject= sc.nextLine();
                            System.out.println("Available");
                            Available=sc.nextInt();
                            sc.nextLine();
                            book=new Books(Isbn,Title,Author,Subject,Available);
                            bm.addAbook(book);
                            System.out.println("A book Record is added...");
                        case 24:
                            System.out.println("Enter the ISBN ");
                            int Update_isbn;
                            Update_isbn=sc.nextInt();
                            try{
                                book=bm.searchBookbyIsbn(Update_isbn);
                                if (book==null)
                                    throw new BookNotFoundException();
                                    System.out.println("Enter Book Details to Modify ");
                                    sc.nextLine();
                                    System.out.println("Enter Title ");
                                    Title=sc.nextLine();
                                    sc.nextLine();
                                    System.out.println("Enter Author name");
                                    Author= sc.nextLine();
                                    System.out.println("Subject");
                                    Subject= sc.nextLine();
                                    System.out.println("Available");
                                    Available=sc.nextInt();
                                    sc.nextLine();
                                    bm.UpdateBook(Update_isbn,Title,Author,Subject,Available,book);

                            }catch (BookNotFoundException Bn){
                                System.out.println(Bn);
                            }
                            break;
                        case 25:
                            System.out.println("Enter the Roll Number to Updates Details ");
                            int delete_isbn;
                            delete_isbn = sc.nextInt();
                            try{
                               book=bm.searchBookbyIsbn(delete_isbn);
                               if (book==null)
                                   throw new BookNotFoundException();
                               bm.DeleteBook(delete_isbn);
                                System.out.println("Delete successfully...");
                            }catch(BookNotFoundException bnf){
                                System.out.println(bnf);
                            }
                            break;
                        case 31:
                            System.out.println("All the Transection");
                            Btm.viewAll();
                        case 99:
                            System.out.println("Thank you for Using .....");
                            break;
                        default:
                            System.out.println("Invalid Choice...");
                    }
                } while (Librarian_Choice != 99);
            }
        }while (Choice !=3);
        sm.WriteToFile();
        bm.writeToFile();
        Btm.writeToFile();
        sc.close();
    }
}
