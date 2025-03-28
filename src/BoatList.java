
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class BoatList {
    
    // Lớp Node nội bộ cho danh sách liên kết
    private class Node {
        Boat data;
        Node next;
        
        public Node(Boat data) {
            this.data = data;
            this.next = null;
        }
    }
    
    private Node head;

    public BoatList() {
        head = null;
    }
    
 // 1.1. Load data từ file và thêm vào cuối danh sách.
    public void loadDataFromFile(String filename) {
        head = null;
        
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while((line = br.readLine()) != null) {
                // Giả sử dữ liệu được phân tách bởi ký tự "|"
                String[] parts = line.split("\\|");
                if(parts.length < 6) continue;
                
                // Loại bỏ khoảng trắng dư thừa
                String bcode = parts[0].trim();
                String boatName = parts[1].trim();
                int seat = Integer.parseInt(parts[2].trim());
                int booked = Integer.parseInt(parts[3].trim());
                String departPlace = parts[4].trim();
                double rate = Double.parseDouble(parts[5].trim());
                
                // Kiểm tra hợp lệ dữ liệu cho tàu thủy
                if (seat <= 0 || booked < 0 || booked > seat || rate <= 0) {
                    System.out.println("Dữ liệu không hợp lệ cho tàu thủy: " + bcode);
                    continue;
                }

                
                Boat b = new Boat(bcode, boatName, seat, booked, departPlace, rate);
                addLast(b);
            }
            System.out.println("Load dữ liệu thành công từ file: " + filename);
        } catch (IOException e) {
            System.out.println("Lỗi đọc file: " + e.getMessage());
        }
    }
    
    //1.2
    public void addLast(Boat b) {
        Node newNode = new Node(b);
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
    
    
    // 1.2. Thêm vào đầu danh sách
    public void addToHead(Boat b) {
        if(search(b.getBcode()) != null) {
            System.out.println("Mã tàu đã tồn tại: " + b.getBcode());
            return;
        }
        Node newNode = new Node(b);
        newNode.next = head;
        head = newNode;
    }
    
    // 1.3
    public void display() {
        if(head == null) {
            System.out.println("Danh sách trống.");
            return;
        }
        System.out.println("bcode | Boat_name | Seat | booked | depart_place | rate | Available_seat");
        System.out.println("--------------------------------------------------------------------------");
        Node cur = head;
        while(cur != null) {
            System.out.println(cur.data);
            cur = cur.next;
        }
    }
    
     // 1.4. Lưu danh sách tàu vào file
    public void saveToFile(String filename) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(filename))) {
            Node cur = head;
            while(cur != null) {
                pw.println(cur.data);
                cur = cur.next;
            }
            System.out.println("Lưu dữ liệu thành công vào file: " + filename);
        } catch(IOException e) {
            System.out.println("Lỗi ghi file: " + e.getMessage());
        }
    }
    
    
     // 1.5. Tìm kiếm theo bcode
    public Boat search(String xCode) {
        Node cur = head;
        while(cur != null) {
            if(cur.data.getBcode().equalsIgnoreCase(xCode)) {
                return cur.data;
            }
            cur = cur.next;
        }
        return null;
    }
    
    //1.6
    public void deleteByBcode(String xCode) {
        if(head == null) {
            System.out.println("Danh sách trống.");
            return;
        }
        if(head.data.getBcode().equalsIgnoreCase(xCode)) {
            head = head.next;
            System.out.println("Xóa thành công mã thuyền: " + xCode);
            return;
        }
        Node prev = head;
        Node cur = head.next;
        while(cur != null) {
            if(cur.data.getBcode().equalsIgnoreCase(xCode)) {
                prev.next = cur.next;
                System.out.println("Xóa thành công mã thuyền: " + xCode);
                return;
            }
            prev = cur;
            cur = cur.next;
        }
        System.out.println("Không tìm thấy mã thuyền: " + xCode);
    }
    
    // 1.7. Sắp xếp danh sách theo Bcode (sử dụng Bubble Sort)
    public void sortByBCode() {
        if(head == null || head.next == null) return;
        boolean swapped;
        do {
            swapped = false;
            Node cur = head;
            while(cur.next != null) {
                if(cur.data.getBcode().compareToIgnoreCase(cur.next.data.getBcode()) > 0) {
                    // Hoán đổi dữ liệu giữa các node
                    Boat temp = cur.data;
                    cur.data = cur.next.data;
                    cur.next.data = temp;
                    swapped = true;
                }
                cur = cur.next;
            }
        } while(swapped);
        System.out.println("Sắp xếp theo bcode thành công.");
    }
    
    //1.8
    public void addAfterPosition(int k, Boat b) {
        Node newNode = new Node(b);
        if(k < 0) {
            System.out.println("Vị trí không hợp lệ.");
            return;
        }
        if(head == null && k > 0) {
            System.out.println("Danh sách trống.");
            return;
        }
        Node cur = head;
        int pos = 0;
        while(cur != null && pos < k) {
            cur = cur.next;
            pos++;
        }
        if(cur == null) {
            System.out.println("Vị trí " + k + " không tồn tại trong danh sách.");
            return;
        }
        newNode.next = cur.next;
        cur.next = newNode;
        System.out.println("Thêm tàu sau vị trí " + k + " thành công.");
    }
    
     // 1.9. Xóa node nằm trước node có tcode = xCode
    public void deleteBefore(String xCode) {
        if(head == null || head.next == null) {
            System.out.println("Không đủ phần tử để thực hiện thao tác này.");
            return;
        }
        // Nếu head.next chứa xCode thì không có node trước đó
        if(head.data.getBcode().equalsIgnoreCase(xCode)) {
            System.out.println("Không có phần tử nào nằm trước node có tcode = " + xCode);
            return;
        }
        Node prePre = null;
        Node pre = head;
        Node cur = head.next;
        while(cur != null && !cur.data.getBcode().equalsIgnoreCase(xCode)) {
            prePre = pre;
            pre = cur;
            cur = cur.next;
        }
        if(cur == null) {
            System.out.println("Không tìm thấy bcode: " + xCode);
            return;
        }
        if(prePre == null) {
            head = cur;
        } else {
            prePre.next = cur;
        }
        System.out.println("Xóa node trước node có bcode = " + xCode + " thành công.");
    }
    
//    
//    public void deleteAfter(String xCode) {
//    if(head == null || head.next == null) {
//        System.out.println("Không đủ phần tử để thực hiện thao tác này.");
//        return;
//    }
//
//    Node pre = head;
//    Node cur = head.next;
//    while(cur != null && !pre.data.getBcode().equalsIgnoreCase(xCode)) {
//        pre = cur;
//        cur = cur.next;
//    }
//
//    if(cur == null) {
//        System.out.println("Không tìm thấy bcode: " + xCode);
//        return;
//    }
//
//    if(cur.next == null) {
//        System.out.println("Không có node nào sau node có bcode = " + xCode);
//        return;
//    }
//
//    // Nếu cur.next != null, ta sẽ xóa node sau cur
//    Node nodeToDelete = cur.next;
//    cur.next = nodeToDelete;
//    
//    System.out.println("Xóa node sau node có bcode = " + xCode + " thành công.");
//}
    
    public void deleteAfter(String xCode) {
    if (head == null || head.next == null) {
        System.out.println("Không đủ phần tử để thực hiện thao tác này.");
        return;
    }

    Node cur = head;
    // Duyệt qua danh sách để tìm node có bcode = xCode
    while (cur != null && cur.next != null && !cur.data.getBcode().equalsIgnoreCase(xCode)) {
        cur = cur.next;
    }

    // Nếu không tìm thấy node có bcode = xCode hoặc node tiếp theo là null
    if (cur == null || cur.next == null) {
        System.out.println("Không tìm thấy bcode: " + xCode + " hoặc không có node sau node này.");
        return;
    }

    // Xóa node sau node có bcode = xCode
    cur.next = cur.next.next;

    System.out.println("Xóa node sau node có bcode = " + xCode + " thành công.");
}


    
    
    
    
    
    
    
    
}
