package Library_Management_System.Person;

import java.io.*;
import java.lang.*;
import java.util.ArrayList;
import java.util.ListIterator;

public class StudentManager {
     int Student;
    ObjectOutputStream oos_student=null;
    ObjectInputStream ois_student=null;
    ArrayList<Student>student_list=null;
    File student_file=null;
    public StudentManager(){
        student_file=new File("Student.dat");
        student_list=new ArrayList<Student>();
        if (student_file.exists()) {
            try {
                ois_student = new ObjectInputStream(new FileInputStream(student_file));
                student_list = (ArrayList<Library_Management_System.Person.Student>) ois_student.readObject();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException cnf) {
                System.out.println(cnf);
                 }
            }
          }
        public void addStudent(Student student){
            student_list.add(student);
    }
    public Student get(int roll){
        for (Student student: student_list) {
            if (student.getRoll() == roll)
                return student;
        }
        return null;
    }
    public void viewAllStudent(){
        for (Student student: student_list){
            System.out.println(student);
        }
    }
    public boolean deleteStudent(int delete_roll){
        ListIterator<Student>student_iterator= (ListIterator<Library_Management_System.Person.Student>) student_list.iterator();
        while(student_iterator.hasNext()){
            Student student = student_iterator.next();
            if (student.getRoll()==delete_roll){
                student_list.remove(student);
                return true;
            }
        }
        return false;
    }
    public boolean UpdateStudent(int update_roll,String name, String email, String phone, String address, String DOB, int std, String division) {
        ListIterator<Student> student_iterator = (ListIterator<Library_Management_System.Person.Student>) student_list.iterator();
        while (student_iterator.hasNext()) {
            Student student = student_iterator.next();
            if (student.getRoll() == update_roll) {
                student.setAddress(address);
                student.setDivision(division);
                student.setDOB(DOB);
                student.setEmail(email);
                student.setPhone(phone);
                student.setStd(std);
                return true;
             }
            }
            return false;
        }
        public void WriteToFile(){
        try{
            oos_student=new ObjectOutputStream(new FileOutputStream(student_file));
            oos_student.writeObject(student_list);
           }catch (IOException IOE){
            IOE.printStackTrace();
        }
        }
    }