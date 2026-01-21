package org.roehampton.myPartiDomain;


public class Booking implements IdGenerator, OverallPricing {

    // Attributes
    private static int usedID = 0;

    private Venue venue; // composition
    private User user; // composition
    private EventType eventType; // composition
    private Facility food; // composition
    private Facility decor; // composition

    private String bookingID;
    private static int guestCount, duration;


    // Constructor
    public Booking(Venue venue, User user, Facility food, Facility decor, EventType eventType, int guestCount, int duration) {

        this.bookingID = generateID();
        this.venue = venue;
        this.user = user;
        this.food = food;
        this.decor = decor;
        this.eventType = eventType;
        this.guestCount = guestCount;
        this.duration = duration;
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

    @Override
    public String toString() {

        return bookingID;
    }


    // Class methods
    public Venue getVenue() {

        return venue;
    }

    public static int getGuestCount() {

        return guestCount;
    }

    public static int getDuration() {

        return duration;
    }


    public String displayBooking() {

        return "Thank you for your booking " + user.getName() + ".\n"
                + "\nORDER DETAILS"
                + "\nVenue: " + venue.getVenueName()
                + "\nEvent: " + eventType.toString()
                + "\nFacilities: " + food.facName + " catering & "
                + decor.facName + " decorations\n"
                + "\nThe total price of this booking is £" + String.format("%.2f", overallCost());
    }
}
