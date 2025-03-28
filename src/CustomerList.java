
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class CustomerList {
    
    private class Node{
        Customer data;
        Node next;

        public Node(Customer data) {
            this.data = data;
            this.next = null;
        }
    }
    
    private Node head;

    public CustomerList() {
        head = null;
    }
    
    // 2.1. Load data từ file
    public void loadDataFromFile(String filename) {
        head = null;
        
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while((line = br.readLine()) != null) {
                String[] parts = line.split("\\|");
                if(parts.length < 3) continue;
                String ccode = parts[0].trim();
                String cusName = parts[1].trim();
                String phone = parts[2].trim();
                // Kiểm tra số điện thoại chỉ chứa chữ số
                if(!phone.matches("\\d+")){
                    System.out.println("Số điện thoại không hợp lệ cho khách hàng: " + ccode);
                    continue;
                }
                Customer c = new Customer(ccode, cusName, phone);
                addToEnd(c);
            }
            System.out.println("Load dữ liệu khách hàng từ file thành công.");
        } catch(IOException e) {
            System.out.println("Lỗi đọc file: " + e.getMessage());
        }
    }
    
    // Thêm khách hàng vào cuối danh sách
    public void addToEnd(Customer c) {
        if(search(c.getCcode()) != null) {
            System.out.println("Mã khách hàng đã tồn tại: " + c.getCcode());
            return;
        }
        Node newNode = new Node(c);
        if(head == null) {
            head = newNode;
            return;
        }
        Node cur = head;
        while(cur.next != null) {
            cur = cur.next;
        }
        cur.next = newNode;
    }
    
    // Hiển thị danh sách khách hàng
    public void display() {
        if(head == null) {
            System.out.println("Danh sách khách hàng trống.");
            return;
        }
        System.out.println("ccode | cusName | phone");
        System.out.println("-------------------------");
        Node cur = head;
        while(cur != null) {
            System.out.println(cur.data);
            cur = cur.next;
        }
    }
    
    // Lưu danh sách khách hàng vào file
    public void saveToFile(String filename) {
        try(PrintWriter pw = new PrintWriter(new FileWriter(filename))) {
            Node cur = head;
            while(cur != null) {
                pw.println(cur.data);
                cur = cur.next;
            }
            System.out.println("Lưu danh sách khách hàng vào file thành công.");
        } catch(IOException e) {
            System.out.println("Lỗi ghi file: " + e.getMessage());
        }
    }
    
    // Tìm kiếm khách hàng theo ccode
    public Customer search(String xCode) {
        Node cur = head;
        while(cur != null) {
            if(cur.data.getCcode().equalsIgnoreCase(xCode)) {
                return cur.data;
            }
            cur = cur.next;
        }
        return null;
    }
    
    // Xóa khách hàng theo ccode
    public void deleteByCcode(String xCode) {
        if(head == null) {
            System.out.println("Danh sách khách hàng trống.");
            return;
        }
        if(head.data.getCcode().equalsIgnoreCase(xCode)) {
            head = head.next;
            System.out.println("Xóa khách hàng có ccode = " + xCode + " thành công.");
            return;
        }
        Node prev = head;
        Node cur = head.next;
        while(cur != null) {
            if(cur.data.getCcode().equalsIgnoreCase(xCode)) {
                prev.next = cur.next;
                System.out.println("Xóa khách hàng có ccode = " + xCode + " thành công.");
                return;
            }
            prev = cur;
            cur = cur.next;
        }
        System.out.println("Không tìm thấy khách hàng có ccode = " + xCode);
    }
}
