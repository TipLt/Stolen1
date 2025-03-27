
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author duong
 */
public class Internship extends Candidate {

    private final int INTERNSHIP = 2;
    public String major;
    public String semester;
    public String university;

    public Internship() {
    }

    public Internship(String id, String firstName, String lastName, int birthDate, String address, String phone, String email, String major, String semester, String university) {
        super(id, firstName, lastName, birthDate, address, phone, email);
        this.major = major;
        this.semester = semester;
        this.university = university;
    }

    @Override
    public Candidate inputCandidate(ArrayList<Candidate> list) {
        super.inputCandidate(list);
        this.major = Validate.inputString("Enter major: ", ".+");
        this.semester = Validate.inputString("Enter semester: ", ".+");
        this.university = Validate.inputString("Enter university: ", ".+");
        return new Internship(id, firstName, lastName, birthDate, address, phone, email, major, semester, university);
    }

    @Override
    public String outputCandidate(ArrayList<Candidate> list) {
        return super.outputCandidate(list) + '|' + INTERNSHIP;
    }

    @Override
    public int getType() {
        return INTERNSHIP;
    }

    @Override
    public String getFullName() {
        return super.getFullName();
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

}
