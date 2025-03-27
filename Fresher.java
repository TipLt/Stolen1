
import java.util.ArrayList;
import java.util.Calendar;

public class Fresher extends Candidate {

    private final int FRESHER = 1;
    public int graduationDate;
    public String graduationRank;

    public Fresher() {
    }

    public Fresher(String id, String firstName, String lastName, int birthDate, String address, String phone, String email, int graduationDate, String graduationRank) {
        super(id, firstName, lastName, birthDate, address, phone, email);
        this.graduationDate = graduationDate;
        this.graduationRank = graduationRank;
    }

    @Override
    public Candidate inputCandidate(ArrayList<Candidate> list) {
        super.inputCandidate(list);
        this.graduationDate = Validate.inputInt("Enter graduation date: ", birthDate, Calendar.getInstance().get(Calendar.YEAR));
        this.graduationRank = Validate.checkInputGraduationRank("Enter graduation rank:  ");
        return new Fresher(id, firstName, lastName, birthDate, address, phone, email, graduationDate, graduationRank);
    }

    @Override
    public String outputCandidate(ArrayList<Candidate> list) {
        return super.outputCandidate(list) + '|' + FRESHER;
    }

    @Override
    public int getType() {
        return FRESHER;
    }

    @Override
    public String getFullName() {
        return super.getFullName();
    }

    public int getGraduationDate() {
        return graduationDate;
    }

    public void setGraduationDate(int graduationDate) {
        this.graduationDate = graduationDate;
    }

    public String getGraduationRank() {
        return graduationRank;
    }

    public void setGraduationRank(String graduationRank) {
        this.graduationRank = graduationRank;
    }

}
