package org.roehampton.sd3.myparti;

import org.roehampton.sd3.myparti.models.*;

public class Main {
    public static void main(String[] args){

        Venue v1 = new Hall("Fete D'Or", "A luxurious hall fit for any event.", "London", 500);
        v1.displayVenue();

        Facility d1 = new Decoration("Classic Wedding", "Simple and silver theme, includes flowers", 500);
        Facility d2 = new Decoration("Woodland Fairy", "Suitable for themed children's birthday parties", 200);
        d2.listOptions();

        Facility c1 = new Catering("Indian", "Rice served with staple Indian curries.", 10);
        Facility c2 = new Catering("Middle Eastern", "Rice served with grilled meats and salad.", 15);
        c2.listOptions();

        User u1 = new User("Amel Bouras", "07468372928", "amelbouras@domain.com");

        Booking b1 = new Booking(v1, u1, c1, d1, EventType.WEDDING, 345);
        b1.displayBooking();
    }

}
