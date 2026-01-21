package org.roehampton.myPartiDomain;


public interface VenueState {

    public String bookVenue(Venue venue, User user, Facility food, Facility decor, EventType eventType, int guestCount, int duration);
    public String getVenueState();

}
