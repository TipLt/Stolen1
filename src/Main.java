
import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);
    private static BoatList boatList = new BoatList();
    private static CustomerList customerList = new CustomerList();
    private static BookList bookList = new BookList();

    public static void main(String[] args) {
        // TODO code application logic here
              int choice = -1;
        do {
            System.out.println("\n========= MENU =========");
            System.out.println("1. Boat list operations");
            System.out.println("2. Customer list operations");
            System.out.println("3. Booking list operations");
            System.out.println("0. Exit");
            System.out.print("Chọn chức năng: ");
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch(NumberFormatException e) {
                System.out.println("Nhập không hợp lệ, vui lòng nhập số.");
                continue;
            }
            switch(choice) {
                case 1:
                    boatMenu();
                    break;
                case 2:
                    customerMenu();
                    break;
                case 3:
                    bookMenu();
                    break;
                case 0:
                    System.out.println("Kết thúc chương trình.");
                    break;
                default:
                    System.out.println("Chọn chức năng không hợp lệ.");
            }
        } while(choice != 0);
    }
    
    public static void boatMenu() {
        int option = -1;
        do {
            System.out.println("\n--- Boat List Menu ---");
            System.out.println("1. Load data from file");
            System.out.println("2. Input & add to head");
            System.out.println("3. Display data");
            System.out.println("4. Save train list to file");
            System.out.println("5. Search by bcode");
            System.out.println("6. Delete by bcode");
            System.out.println("7. Sort by bcode");
            System.out.println("8. Add after position k");
            System.out.println("9. Delete the node before the node having bcode = xCode");
            System.out.println("10. Delete the node after the node having bcode = xCode");
            System.out.println("0. Back to main menu");
            System.out.print("Chọn chức năng: ");
            try {
                option = Integer.parseInt(sc.nextLine());
            } catch(NumberFormatException e) {
                System.out.println("Nhập không hợp lệ.");
                continue;
            }
            
            switch(option) {
                case 1:
                    System.out.print("Nhập tên file: ");
                    String fileTrain = sc.nextLine();
                    boatList.loadDataFromFile(fileTrain);
                    break;
                case 2:
                    System.out.print("Nhập bcode: ");
                    String bcode = sc.nextLine();
                    System.out.print("Nhập Boat_name: ");
                    String boatName = sc.nextLine();
                    System.out.print("Nhập số ghế: ");
                    int seat = Integer.parseInt(sc.nextLine());
                    System.out.print("Nhập số ghế đã đặt: ");
                    int booked = Integer.parseInt(sc.nextLine());
                    System.out.print("Nhập depart place: ");
                    String departPlace = sc.nextLine();
                    System.out.print("Nhập rate: ");
                    double rate = Double.parseDouble(sc.nextLine());
                    Boat newBoat =new Boat(bcode, boatName, seat, booked, departPlace, rate);
                    boatList.addToHead(newBoat);
                    break;
                case 3:
                    boatList.display();
                    break;
                case 4:
                    System.out.print("Nhập tên file để lưu: ");
                    String saveFileTrain = sc.nextLine();
                    boatList.saveToFile(saveFileTrain);
                    break;
                case 5:
                    System.out.print("Nhập bcode cần tìm: ");
                    String searchCode = sc.nextLine();
                    Boat found = boatList.search(searchCode);
                    if(found != null)
                        System.out.println("Tìm thấy: " + found);
                    else
                        System.out.println("Không tìm thấy tàu có bcode = " + searchCode);
                    break;
                case 6:
                    System.out.print("Nhập bcode cần xóa: ");
                    String deleteCode = sc.nextLine();
                    boatList.deleteByBcode(deleteCode);
                    break;
                case 7:
                    boatList.sortByBCode();
                    break;
                case 8:
                    System.out.print("Nhập vị trí k: ");
                    int pos = Integer.parseInt(sc.nextLine());
                    System.out.print("Nhập bcode: ");
                    String bcode2 = sc.nextLine();
                    System.out.print("Nhập boad_name: ");
                    String boatName2 = sc.nextLine();
                    System.out.print("Nhập số ghế: ");
                    int seat2 = Integer.parseInt(sc.nextLine());
                    System.out.print("Nhập số ghế đã đặt: ");
                    int booked2 = Integer.parseInt(sc.nextLine());
                    System.out.print("Nhập depart place: ");
                    String departPlace2 = sc.nextLine();
                    System.out.print("Nhập rate: ");
                    double rate2 = Double.parseDouble(sc.nextLine());
                    Boat newBoat2 = new Boat(bcode2, boatName2, seat2, booked2, departPlace2, rate2);
                    boatList.addAfterPosition(pos, newBoat2);
                    break;
                case 9:
                    System.out.print("Nhập bcode (xCode) của node sau: ");
                    String xCode = sc.nextLine();
                    boatList.deleteBefore(xCode);
                    break;
                case 10:
                    System.out.println("Nhập (xCode) của node: ");
                    String x1Code = sc.nextLine();
                    boatList.deleteAfter(x1Code);
                    break;
                case 0:
                    System.out.println("Quay lại menu chính.");
                    break;
                default:
                    System.out.println("Chọn chức năng không hợp lệ.");
            }
        } while(option != 0);
    }
    
     public static void customerMenu() {
        int option = -1;
        do {
            System.out.println("\n--- Customer List Menu ---");
            System.out.println("1. Load data from file");
            System.out.println("2. Input & add to the end");
            System.out.println("3. Display data");
            System.out.println("4. Save customer list to file");
            System.out.println("5. Search by ccode");
            System.out.println("6. Delete by ccode");
            System.out.println("0. Back to main menu");
            System.out.print("Chọn chức năng: ");
            try {
                option = Integer.parseInt(sc.nextLine());
            } catch(NumberFormatException e) {
                System.out.println("Nhập không hợp lệ.");
                continue;
            }          
            switch(option) {
                case 1:
                    System.out.print("Nhập tên file: ");
                    String fileCustomer = sc.nextLine();
                    customerList.loadDataFromFile(fileCustomer);
                    break;
                case 2:
                    System.out.print("Nhập ccode: ");
                    String ccode = sc.nextLine();
                    System.out.print("Nhập cus name: ");
                    String cusName = sc.nextLine();
                    System.out.print("Nhập phone: ");
                    String phone = sc.nextLine();
                    Customer newCustomer = new Customer(ccode, cusName, phone);
                    customerList.addToEnd(newCustomer);
                    break;
                case 3:
                    customerList.display();
                    break;
                case 4:
                    System.out.print("Nhập tên file để lưu: ");
                    String saveFileCustomer = sc.nextLine();
                    customerList.saveToFile(saveFileCustomer);
                    break;
                case 5:
                    System.out.print("Nhập ccode cần tìm: ");
                    String searchCcode = sc.nextLine();
                    Customer foundCustomer = customerList.search(searchCcode);
                    if(foundCustomer != null)
                        System.out.println("Tìm thấy: " + foundCustomer);
                    else
                        System.out.println("Không tìm thấy khách hàng có ccode = " + searchCcode);
                    break;
                case 6:
                    System.out.print("Nhập ccode cần xóa: ");
                    String deleteCcode = sc.nextLine();
                    customerList.deleteByCcode(deleteCcode);
                    break;
                case 0:
                    System.out.println("Quay lại menu chính.");
                    break;
                default:
                    System.out.println("Chọn chức năng không hợp lệ.");
            }
        } while(option != 0);
    }
    
    // Menu cho Booking List
    public static void bookMenu() {
        int option = -1;
        do {
            System.out.println("\n--- Booking List Menu ---");
            System.out.println("1. Input data");
            System.out.println("2. Display data");
            System.out.println("3. Sort by tcode + ccode");
            System.out.println("0. Back to main menu");
            System.out.print("Chọn chức năng: ");
            try {
                option = Integer.parseInt(sc.nextLine());
            } catch(NumberFormatException e) {
                System.out.println("Nhập không hợp lệ.");
                continue;
            }
            
            switch(option) {
                case 1:
                    System.out.print("Nhập boat code: ");
                    String btcode = sc.nextLine();
                    System.out.print("Nhập customer code: ");
                    String bccode = sc.nextLine();
                    System.out.print("Nhập số ghế đặt: ");
                    int bseat = Integer.parseInt(sc.nextLine());
                    Book newBooking = new Book(btcode, bccode, bseat);
                    bookList.addBooking(newBooking, boatList, customerList);
                    break;
                case 2:
                    bookList.displayB(boatList);
                    break;
                case 3:
                    bookList.sortByBcodeAndCcode();
                    break;
                case 0:
                    System.out.println("Quay lại menu chính.");
                    break;
                default:
                    System.out.println("Chọn chức năng không hợp lệ.");
            }
        } while(option != 0);
    }
    
}
