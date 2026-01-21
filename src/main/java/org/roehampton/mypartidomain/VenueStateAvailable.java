package org.roehampton.mypartidomain;


public class VenueStateAvailable implements VenueState {

    // Attribute
    private Venue venue;

    // Constructor
    public VenueStateAvailable(Venue venue) {

        this.venue = venue;
    }

    // Implemented methods
    @Override
    public String bookVenue(Venue venue, User user, Facility food, Facility decor, EventType eventType, int guestCount, int duration) {

        Booking b = new Booking(venue, user, food, decor, eventType, guestCount, duration);
        BookingManager.getInstance().addBooking(b); // Adds this to list of bookings
        venue.setState(new VenueStateUnavailable(venue)); // Venue becomes unavailable after booking

        return "\nYou have successfully booked " + venue.getVenueName() + ".\n";
    }


    @Override
    public String getVenueState() {

        return "Venue Available";
    }

}
