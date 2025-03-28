
public class Boat {
    private String bcode;
    private String boat_name;
    private int seat;
    private int booked;
    private String depart_place;
    private double rate;

    public Boat(String bcode, String boat_name, int seat, int booked, String depart_place, double rate) {
        this.bcode = bcode;
        this.boat_name = boat_name;
        this.seat = seat;
        this.booked = booked;
        this.depart_place = depart_place;
        this.rate = rate;
    }

    public String getBcode() {
        return bcode;
    }

    public void setBcode(String bcode) {
        this.bcode = bcode;
    }

    public String getBoat_name() {
        return boat_name;
    }

    public void setBoat_name(String boat_name) {
        this.boat_name = boat_name;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public int getBooked() {
        return booked;
    }

    public void setBooked(int booked) {
        this.booked = booked;
    }

    public String getDepart_place() {
        return depart_place;
    }

    public void setDepart_place(String depart_place) {
        this.depart_place = depart_place;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }
    
     public int getAvailableSeat() {
        return seat - booked;
    }
    
    @Override
    public String toString() {
        return String.format("%5s | %-9s | %4d | %6d | %12s | %-4.1f | %3d",
                bcode,boat_name, seat, booked, depart_place, rate, getAvailableSeat());
    }
}
