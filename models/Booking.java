package org.roehampton.sd3.myparti.models;

import org.roehampton.sd3.myparti.interfaces.IdGenerator;
import org.roehampton.sd3.myparti.interfaces.OverallPricing;


public class Booking implements IdGenerator, OverallPricing {

    // Attributes
    private static int usedID = 0;

    private Venue venue; // composition
    private User user; // composition
    private EventType eventType; // composition
    private Facility food; // composition
    private Facility decor; // composition

    private String bookingID;
    private static int guestCount, duration = 6 ;  // Temporary duration hardcode

    // Private LocalDate date; and private LocalTime start, end; to be added later//


    // Constructor
    public Booking(Venue venue, User user, Facility food, Facility decor, EventType eventType, int guestCount) {

        this.bookingID = generateID();
        this.venue = venue;
        this.user = user;
        this.food = food;
        this.decor = decor;
        this.eventType = eventType;
        this.guestCount = guestCount;
    }


    // Implemented methods
    @Override
    public String generateID() {

        int newID = ++usedID;  // Increments ID everytime the method is called

        return "B" + String.format("%05d", newID);
    }


    @Override
    public double overallCost() {

    return (eventType.getMultiplier()*venue.calculateCost()) + food.calculateCost() + decor.calculateCost();
    }


    // Class methods
    public Venue getVenue() {

        return venue;
    }


    public static int getGuestCount() {

        return guestCount;
    }


    public String displayBooking() {

        return "Thank you for your booking " + user.getName() + "."
                + "\nORDER DETAILS\n"
                + "Booking ID: " + bookingID
                + " | Venue: " + venue.venueName
                + " for a(n) " + eventType
                + " | Facilities: " + food.facName + " catering & "
                + decor.facName + " decorations\n"
                + "The total price of this booking is £" + overallCost();
    }
}
