/*
 * Click nbfs: //nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs: //nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.ArrayList;

public class Manager {
    public int menu() {
        System.out.println("\n================CANDIDATES MANAGER================");
        System.out.println("1. Experience");
        System.out.println("2. Fresher");
        System.out.println("3. Internship");
        System.out.println("4. Searching");
        System.out.println("5. Exit");
        System.out.println(" (Please choose 1 to Create Experience Candidate, 2 to Create Fresher Candidate, 3 to Internship Candidate, 4 to Searching and 5 to Exit program).");
        return Validate.inputInt("Enter your choice: ", 1, 6);

    }

    public void searchCandidate(ArrayList<Candidate> list) {
        display(list);
        String nameSearch = Validate.inputString("Enter candidate name (First name or Last name): ", ".+")
                .replaceAll("\\s+", " ");

        System.out.println("\t- 0: for Experience\n"
                + "\t- 1: for Fresher candidate\n"
                + "\t- 2: for Intern candidate");

        int typeCandidate = Validate.inputInt("Enter type of candidate: ", 0, 2);
        System.out.println("The candidates found");

        for (Candidate candidate : list) {
            if (candidate.getFullName().toLowerCase().contains(nameSearch) && candidate.getType() == typeCandidate) {
                System.out.println(candidate.outputCandidate(list));
            }
        }
    }

    public void display(ArrayList<Candidate> list) {
        System.out.println("========================EXPERIENCE CANDIDATE========================");
        for (Candidate candidate : list) {
            if (candidate instanceof Experience) {
                System.out.println(candidate.getFullName());
            }
        }
        System.out.println("========================FRESHER CANDIDATE========================");
        for (Candidate candidate : list) {
            if (candidate instanceof Fresher) {
                System.out.println(candidate.getFullName());
            }
        }
        System.out.println("========================INTERNSHIP CANDIDATE========================");
        for (Candidate candidate : list) {
            if (candidate instanceof Internship) {
                System.out.println(candidate.getFullName());
            }
        }
    }

    public void print(ArrayList<Candidate> list) {
        for (Candidate candidate : list) {
            System.out.println(candidate.outputCandidate(list));
        }
    }

}
