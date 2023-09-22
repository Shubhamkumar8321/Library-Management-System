package Library_Management_System.Person;

import java.io.Serializable;

class person implements Serializable {
    protected String name;
    protected String Email;
    protected  String Phone;
    protected  String Address;
    protected String DOB;

    public person() {

    }

    @Override
    public String toString() {
        return "person{" +"name='" + name + ", Email='" + Email + ", Phone='" + Phone + ", Address='" + Address + ", DOB='" + DOB  + '}';
    }
    public person(String name, String email, String phone, String address, String DOB) {
        this.name = name;
        Email = email;
        Phone = phone;
        Address = address;
        this.DOB = DOB;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        this.Email = email;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        this.Phone = phone;
    }

    public String getAddress() {
        return Address;
    }
    public void setAddress(String address) {this.Address = address;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }
 }
