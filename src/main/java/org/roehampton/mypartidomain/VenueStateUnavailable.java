package org.roehampton.mypartidomain;


public class VenueStateUnavailable implements VenueState {

    // Attribute
    private Venue venue;

    // Constructor
    public VenueStateUnavailable(Venue venue) {

        this.venue = venue;
    }

    // Implemented methods
    @Override
    public String bookVenue(Venue venue, User user, Facility food, Facility decor, EventType eventType, int guestCount, int duration) {

        return "\nSorry, " + venue.getVenueName() + " is currently unavailable.\n";
    }


    @Override
    public String getVenueState() {

        return "Venue Unavailable";
    }

}
