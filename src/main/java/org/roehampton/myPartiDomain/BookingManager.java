package org.roehampton.myPartiDomain;

import java.util.ArrayList;
import java.util.List;


// Singleton booking manager class
public class BookingManager {

    // Attributes
    private static BookingManager instance;

    private List<Booking> bookings;


    // Constructor (only accessible in the class)
    private BookingManager() {

        bookings = new ArrayList<>(); // Creates the list to store all bookings when initialised
    }


    // Methods

    // Makes sure only one instance is created and used universally
    public static BookingManager getInstance() {

        if (instance == null) {

            instance = new BookingManager();
        }

        return instance;
    }


    public void addBooking(Booking booking) {

        bookings.add(booking);
    }


    public List<Booking> getBookings() {

        return bookings;
    }


    public void cancelBooking(Booking booking) {

        booking.getVenue().setState(new VenueStateAvailable(booking.getVenue())); // Marks venue as available
        bookings.remove(booking);
    }
}
