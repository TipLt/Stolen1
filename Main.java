
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Manager manager = new Manager();
        ArrayList<Candidate> list = new ArrayList<>();
        list.add(new Experience("E1", "Aguirre", "Eva", 1995, "vietnam", "0976233985", "blablovcl@gmail.com", 5, "Nope"));
        list.add(new Experience("E1", "Aguirre", "Eva", 1995, "vietnam", "0976233985", "blablovcl@gmail.com", 5, "Nope"));
        list.add(new Fresher("F1", "Phan Huy", "Binh", 1995, "vietnam", "0976233985", "blablovcl@gmail.com", 2005, "Nope"));
        list.add(new Fresher("F1", "Nguyen Hai", "Huy", 1995, "vietnam", "0976233985", "blablovcl@gmail.com", 2010, "Nope"));
        list.add(new Internship("I1", "Vu Xuan", "Truong", 1995, "vietnam", "0976233985", "blablovcl@gmail.com", "Tuan", "SU20", "Nope"));
        list.add(new Internship("I1", "Hoang Trung", "Thanh", 1995, "vietnam", "0976233985", "blablovcl@gmail.com", "Nam", "SP23", "Nope"));

        while (true) {
            int choice = manager.menu();
            switch (choice) {
                case 1:
                    System.out.println("---------------Create Experience---------------");
                    Experience experience = new Experience();
                    list.add(experience.inputCandidate(list));
                    break;
                case 2:
                    System.out.println("---------------Create Experience---------------");
                    Fresher fresher = new Fresher();
                    list.add(fresher.inputCandidate(list));
                    break;
                case 3:
                    System.out.println("---------------Create Experience---------------");
                    Internship internship = new Internship();
                    list.add(internship.inputCandidate(list));
                    break;
                case 4:
                    System.out.println("---------------Search---------------");
                    manager.searchCandidate(list);
                    break;
                case 5:
                    return;
                case 6:
                    manager.print(list);
                    break;
            }
        }
    }
}
