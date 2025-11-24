package org.roehampton.sd3.myparti.models;

import org.roehampton.sd3.myparti.interfaces.VenueState;


public class VenueStateUnavailable implements VenueState {

    // Attribute
    private Venue venue;

    // Constructor
    public VenueStateUnavailable(Venue venue) {

        this.venue = venue;
    }

    // Implemented methods
    @Override
    public String bookVenue(Venue venue, User user, Facility food, Facility decor, EventType eventType, int guestCount) {

        return "\n\nSorry, " + venue.getVenueName() + " is currently unavailable.";
    }

    @Override
    public String getVenueState() {

        return venue.getVenueName() + " is unavailable.";
    }

}
