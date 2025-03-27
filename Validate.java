/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Validate {

    public final static Scanner in = new Scanner(System.in);

    public static int inputInt(String mess, int min, int max) {
        System.out.print(mess);
        while (true) {
            String input = in.nextLine();
            try {
                int number = Integer.parseInt(input);
                if (number < min || number > max) {
                    System.out.print("Please input between " + min + ", " + max + ": ");
                    continue;
                }
                return number;
            } catch (Exception e) {
                System.err.print("Please input an integer number: ");
            }
        }
    }

    public static String inputString(String mess, String regex) {
        System.out.print(mess);
        while (true) {
            String input = in.nextLine().trim();
            if (input.isEmpty()) {
                System.err.print("Please input a non-empty string: ");
                continue;
            }
            if (!input.matches(regex)) {
                System.err.println("Please input a string that matches regex: " + regex);
                continue;
            }
            return input;
        }
    }

    public static String inputDate(String mess) {
        System.out.print(mess);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        dateFormat.setLenient(false);

        while (true) {
            String input = in.nextLine();
            try {
                Date date = dateFormat.parse(input);
                Date curDate = Calendar.getInstance().getTime();
                if (curDate.compareTo(date) < 0) {
                    System.err.print("Please input a date that is before the current date: ");
                    continue;
                }
                return dateFormat.format(date);
            } catch (Exception e) {
                System.err.print("Please input a valid date (dd-MM-yyyy): ");
            }
        }
    }

    public static boolean checkInputYN(String mess) {
        while (true) {
            System.out.print(mess);
            String result = in.nextLine();
            if (result.equalsIgnoreCase("Y")) {
                return true;
            } else if (result.equalsIgnoreCase("N")) {
                return false;
            }
            System.err.println("Please input y/Y or n/N.");
        }
    }

    public static String checkInputGraduationRank(String mess) {
        while (true) {
            System.out.print(mess);
            String result = in.nextLine();
            if (result.equalsIgnoreCase("Excellence")
                    || result.equalsIgnoreCase("Good")
                    || result.equalsIgnoreCase("Fair")
                    || result.equalsIgnoreCase("Poor")) {
                return result;
            } else {
                System.err.println("Please input string: Excellence, Good, Fair, Poor");
            }
        }
    }

    public static boolean checkIdExist(ArrayList<Candidate> candidates, String id) {
        for (Candidate candidate : candidates) {
            if (candidate.getId().equalsIgnoreCase(id)) {
                System.err.println("Id exist.");
                return true;
            }
        }
        return false;
    }

}
