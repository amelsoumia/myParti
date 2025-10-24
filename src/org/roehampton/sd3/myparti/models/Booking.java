package org.roehampton.sd3.myparti.models;

import org.roehampton.sd3.myparti.interfaces.IdGenerator;
import org.roehampton.sd3.myparti.interfaces.OverallPricing;




public class Booking implements IdGenerator, OverallPricing {

    private static int usedID = 0;

    private Venue venue; // composition
    private User user; // composition
    private EventType eventType; // composition
    private Facility food; // composition
    private Facility decor; // composition

    private String bookingID;
    private static int guestCount, duration = 6 ;  // temporary duration hardcode

    // Private LocalDate date; and private LocalTime start, end; to be added later//

    public Booking(Venue venue, User user, Facility food, Facility decor, EventType eventType, int guestCount) {

        this.bookingID = generateID();
        this.venue = venue;
        this.user = user;
        this.food = food;
        this.decor = decor;
        this.eventType = eventType;
        this.guestCount = guestCount;
    }

    @Override
    public String generateID() {

        int newID =+ usedID;  // increments ID everytime the method is called
        usedID = newID;

        return "B" + newID;
    }

    @Override
    public double overallCost() {

    return (eventType.getMultiplier()*venue.calculateCost()) + food.calculateCost() + decor.calculateCost();

    }

    public static int getGuestCount() {

        return guestCount;
    }

    public static int getDuration() {

        return duration;
    }

    public void displayBooking() {

        System.out.println("Thank you for your booking " + user.getName() + "." + "\n");
        System.out.println("ORDER DETAILS" + "\n" + "Booking ID: " + bookingID + " | Venue: " + venue.venueName + " for a(n) " + eventType + " | Facilities: " + food.facName + " catering & " + decor.facName + " decorations" +"\n" + "The total price of this booking is £" + overallCost() );

    }


}
