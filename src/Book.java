

public class Book {
    private String bcode;
    private String ccode;
    private int seat;

    public Book(String bcode, String ccode, int seat) {
        this.bcode = bcode;
        this.ccode = ccode;
        this.seat = seat;
    }

    public String getBcode() {
        return bcode;
    }

    public void setBcode(String bcode) {
        this.bcode = bcode;
    }

    public String getCcode() {
        return ccode;
    }

    public void setCcode(String ccode) {
        this.ccode = ccode;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }
    
     @Override
    public String toString() {
        return String.format("%s | %s | %d", bcode, ccode, seat);
    }
}
