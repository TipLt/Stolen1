
public class BookList {
    
    private class Node {
        Book data;
        Node next;
        
        public Node(Book data) {
            this.data = data;
            this.next = null;
        }
    }
    
    private Node head;
    
    public BookList() {
        head = null;
    }
    
    // 3.1. Thêm một booking sau khi kiểm tra các điều kiện hợp lệ.
    public void addBooking(Book b,  BoatList boatList, CustomerList customerList) {
        // Kiểm tra tồn tại của tcode trong danh sách tàu
        Boat boat = boatList.search(b.getBcode());
        if(boat == null) {
            System.out.println("Không tìm thấy mã thuyền: " + b.getBcode());
            return;
        }
        // Kiểm tra tồn tại của ccode trong danh sách khách hàng
        Customer customer = customerList.search(b.getCcode());
        if(customer == null) {
            System.out.println("Không tìm thấy mã khách hàng: " + b.getCcode());
            return;
        }
        // Kiểm tra xem Booking đã tồn tại hay chưa (theo tcode và ccode)
        if(search(b.getBcode(), b.getCcode()) != null) {
            System.out.println("Booking đã tồn tại cho thuyền " + b.getBcode() + " và khách hàng " + b.getCcode());
            return;
        }
        // Kiểm tra số ghế còn trống
        if(boat.getAvailableSeat() <= 0) {
            System.out.println("Tàu " + b.getBcode() + " đã hết ghế.");
            return;
        }
        // Kiểm tra số ghế đặt có vượt quá số ghế còn lại hay không
        if(b.getSeat() > boat.getAvailableSeat()) {
            System.out.println("Số ghế đặt vượt quá số ghế còn lại (" + boat.getAvailableSeat() + ").");
            return;
        }
        // Nếu hợp lệ, cập nhật số ghế đã đặt cho tàu
        boat.setBooked(boat.getBooked() + b.getSeat());
        addToEnd(b);
        System.out.println("Đặt vé thành công cho thuyền " + b.getBcode() + " và khách hàng " + b.getCcode());
    }
    
    // Thêm Booking vào cuối danh sách
    private void addToEnd(Book b) {
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
    
    // 3.2. Hiển thị danh sách Booking
    public void displayB(BoatList boatList) {
        if(head == null) {
            System.out.println("Danh sách booking trống.");
            return;
        }
        System.out.println("bcode | ccode | seat");
        System.out.println("---------------------");
        Node cur = head;
        while(cur != null) {
            System.out.println(cur.data);
            cur = cur.next;
        }
    }
    
public void sortByBcodeAndCcode() {
    if(head == null || head.next == null) return;
    boolean swapped;
    do {
        swapped = false;
        Node cur = head;
        while(cur != null && cur.next != null) {
            if(cur.data.getBcode().compareTo(cur.next.data.getBcode()) > 0 || 
               (cur.data.getBcode().equalsIgnoreCase(cur.next.data.getBcode()) && 
                cur.data.getCcode().compareTo(cur.next.data.getCcode()) > 0)) {
                Book temp = cur.data;
                cur.data = cur.next.data;
                cur.next.data = temp;
                swapped = true;
            }
            cur = cur.next;
        }
    } while(swapped);
    System.out.println("Sắp xếp Booking theo Bcode thành công.");
}
    
    
    // Tìm kiếm Booking theo tcode và ccode
    public Book search(String bcode, String ccode) {
        Node cur = head;
        while(cur != null) {
            if(cur.data.getBcode().equalsIgnoreCase(bcode) && cur.data.getCcode().equalsIgnoreCase(ccode))
                return cur.data;
            cur = cur.next;
        }
        return null;
    }
    
}
