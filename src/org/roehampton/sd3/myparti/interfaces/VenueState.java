package org.roehampton.sd3.myparti.interfaces;

import org.roehampton.sd3.myparti.models.*;


public interface VenueState {

    public String bookVenue(Venue venue, User user, Facility food, Facility decor, EventType eventType, int guestCount);
    public String getVenueState();

}
