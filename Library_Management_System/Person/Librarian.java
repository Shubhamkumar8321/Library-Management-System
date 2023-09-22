package Library_Management_System.Person;

public class Librarian extends person{
    private int ID;
    private String DoJ;

    @Override
    public String toString() {
        return "Librarian" +
                "ID=" + ID +
                ", DoJ=" + DoJ + ", name='." + name + ", Email=" + Email + ", Phone=" + Phone + ", Address='" + Address +  ", DOB=" + DOB ;
    }

    public Librarian(String name, String email, String phone, String address, String DOB, int ID, String doJ) {
        super(name, email, phone, address, DOB);
        this.ID = ID;
        DoJ = doJ;
    }
//    public Librarian(Object person){
//        super(person);
//    }
}
