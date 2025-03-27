/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author duong
 */
public class Candidate {

    public final String ID_VALID = "[A-Za-z0-9\\s]+";
    public final String NAME_VALID = "[A-Za-z\\s]+";
    public final String PHONE_VALID = "(0[0-9]{9})";
    public final String EMAIL_VALID = "[A-Za-z0-9]\\w+@\\w+(\\.\\w+){1,3}$";

    public String id;
    public String firstName;
    public String lastName;
    public int birthDate;
    public String address;
    public String phone;
    public String email;
    public int type;

    public Candidate() {
    }

    public Candidate(String id, String firstName, String lastName, int birthDate, String address, String phone, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

    public Candidate inputCandidate(ArrayList<Candidate> list) {
        this.id = Validate.inputString("Enter ID: ", ID_VALID);
        
        while (Validate.checkIdExist(list, id)) {
            id = Validate.inputString("Enter ID: ", ID_VALID);
        }
        
        this.firstName = Validate.inputString("Enter first name: ", NAME_VALID);
        this.lastName = Validate.inputString("Enter last name: ", NAME_VALID);
        this.birthDate = Validate.inputInt("Enter bithdate: ", 1900, Calendar.getInstance().get(Calendar.YEAR));
        this.address = Validate.inputString("Enter address: ", ".+");
        this.phone = Validate.inputString("Enrer phone: ", PHONE_VALID);
        this.email = Validate.inputString("Enter email: ", EMAIL_VALID);
        return new Candidate(id, firstName, lastName, birthDate, address, phone, email);
    }

    public String outputCandidate(ArrayList<Candidate> list) {
        return firstName + ' ' + lastName + '|' + birthDate + '|' + address + '|' + phone + '|' + email;
    }

    public String getFullName() {
        return firstName + ' ' + lastName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(int birthDate) {
        this.birthDate = birthDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

}
