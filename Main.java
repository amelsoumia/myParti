package org.roehampton.sd3.myparti;

import org.roehampton.sd3.myparti.interfaces.VenueState;
import org.roehampton.sd3.myparti.models.*;

import java.util.List;

public class Main {
    public static void main(String[] args){

        // Catering and decoration info for venue1
        List<String> cateringNames1 = List.of("Indian", "Middle Eastern");
        List<String> cateringDescs1 = List.of("Rice served with staple Indian curries.", "Rice served with grilled meats and salad.");
        List<Double> cateringPrice1 = List.of(10.00, 15.00);

        List<String> decorNames1 = List.of("Classic Wedding", "Woodland Fairy");
        List<String> decorDescs1 = List.of("Simple and silver theme, includes flowers.", "Suitable for themed children's birthday parties.");
        List<Double> decorPrice1 = List.of(500.00, 200.00);

        // Creating venue and displaying it
        Venue v1 = new Hall("Fete D'Or", "A luxurious hall fit for any event.", "London", 500, cateringNames1, cateringDescs1, cateringPrice1, decorNames1, decorDescs1, decorPrice1);
        System.out.println(v1.displayVenue());

        // Displaying Catering and Decoration options for the venue
        System.out.println(v1.listCateringOptions());
        System.out.println(v1.listDecorOptions());

        // Choosing Catering and Decor for the booking
        Facility decor = v1.getDecorations().get(1);
        Facility food = v1.getCateringOptions().get(0);


        // Creating users
        User u1 = new User("Amel Bouras", "07468372928", "amelbouras@domain.com");
        User u2 = new User("Lily Petal", "07123456789", "lilypetal@domain.com");
        User u3 = new User("Tinker Bell", "07987654321", "tinkerbell@neverland.com");

        System.out.println(v1.getState());
        System.out.println(v1.book(u1, food, decor, EventType.OTHER, 30 ));

        Booking b = BookingManager.getInstance().getBookings().get(0);
        System.out.println(b.displayBooking());
        System.out.println(v1.getState());

        v1.book(u2, food, decor, EventType.OTHER, 50);
    }

}
