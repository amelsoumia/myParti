package org.roehampton.mypartidomain;


public interface VenueState {

    public String bookVenue(Venue venue, User user, Facility food, Facility decor, EventType eventType, int guestCount, int duration);
    public String getVenueState();

}
