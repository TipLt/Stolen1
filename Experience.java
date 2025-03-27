
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author duong
 */
public class Experience extends Candidate {

    private final int EXPERIENCE = 0;
    public int yearExperience;
    public String professionalSkill;

    public Experience() {
    }

    public Experience(String id, String firstName, String lastName, int birthDate, String address, String phone, String email, int yearExperience, String professionalSkill) {
        super(id, firstName, lastName, birthDate, address, phone, email);
        this.yearExperience = yearExperience;
        this.professionalSkill = professionalSkill;
    }

    @Override
    public Candidate inputCandidate(ArrayList<Candidate> list) {
        super.inputCandidate(list);
        this.yearExperience = Validate.inputInt("Enter year of experience: ", 0, 100);
        this.professionalSkill = Validate.inputString("Enter professional skill: ", ".+");
        return new Experience(id, firstName, lastName, birthDate, address, phone, email, yearExperience, professionalSkill);
    }

    @Override
    public String outputCandidate(ArrayList<Candidate> list) {
        return super.outputCandidate(list) + '|' + EXPERIENCE;
    }

    @Override
    public int getType() {
        return EXPERIENCE;
    }

    @Override
    public String getFullName() {
        return super.getFullName();
    }

    public int getYearExperience() {
        return yearExperience;

    }

    public void setYearExperience(int yearExperience) {
        this.yearExperience = yearExperience;
    }

    public String getProfessionalSkill() {
        return professionalSkill;
    }

    public void setProfessionalSkill(String professionalSkill) {
        this.professionalSkill = professionalSkill;
    }

}
