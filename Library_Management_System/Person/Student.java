package Library_Management_System.Person;

public class Student extends person{
    private int roll;
    private int std;
    private String Division;

    @Override
    public String toString() {
        return "Student{" + "roll=" + roll + ", std=" + std + ", Division='" + Division + ", name='" + name + ", Email='" + Email + ", Phone='" + Phone + ", Address='" + Address + ", DOB='" + DOB + '}';
    }

    public Student(String name, String email, String phone, String address, String DOB, int roll, int std, String division) {
        super(name, email, phone, address, DOB);
        this.roll = roll;
        this.std = std;
        Division = division;
    }

    public int getRoll() {
        return roll;
    }

    public void setRoll(int roll) {
        this.roll = roll;
    }

    public int getStd() {
        return std;
    }

    public void setStd(int std) {
        this.std = std;
    }

    public String getDivision() {
        return Division;
    }

    public void setDivision(String division) {
        this.Division = division;
    }
}
