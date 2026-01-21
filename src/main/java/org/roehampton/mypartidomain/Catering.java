package org.roehampton.mypartidomain;


public class Catering extends Facility {

    // Constructor
    public Catering(String facName, String description, double facPrice) {

        super(facName, description, facPrice);
    }


    // Implemented method
    @Override
    public double calculateCost() {

        return facPrice*Booking.getGuestCount();
    }

}
