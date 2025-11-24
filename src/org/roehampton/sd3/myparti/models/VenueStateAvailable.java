package org.roehampton.sd3.myparti.models;

import  org.roehampton.sd3.myparti.interfaces.VenueState;


public class VenueStateAvailable implements VenueState {

    // Attribute
    private Venue venue;

    // Constructor
    public VenueStateAvailable(Venue venue) {

        this.venue = venue;
    }

    // Implemented methods
    @Override
    public String bookVenue(Venue venue, User user, Facility food, Facility decor, EventType eventType, int guestCount) {

        Booking b = new Booking(venue, user, food, decor, eventType, guestCount);
        BookingManager.getInstance().addBooking(b); // Adds this to list of bookings
        venue.setState(new VenueStateUnavailable(venue)); // Venue becomes unavailable after booking

        return "\nYou have successfully booked " + venue.getVenueName() + ".\n";
    }


    @Override
    public String getVenueState() {

        return "\n" + venue.getVenueName() + " is available.\n";
    }

}
