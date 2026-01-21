package org.roehampton.myPartiDomain;

import static org.roehampton.myPartiDomain.Booking.getDuration;

import java.util.List;


public class Castle extends Venue {

    // Constructor
    public Castle(String venueName, String description, String location, int capacity, List<String> cateringNames, List<String> cateringDescr, List<Double> cateringPrices, List<String> decorNames, List<String> decorDescr, List<Double> decorPrices) {

        super(venueName, description, location, capacity, cateringNames, cateringDescr, cateringPrices, decorNames, decorDescr, decorPrices);
    }


    // Implemented methods
    @Override
    public double calculateCost() {

        return basePrice*2*getDuration(); // Adds a multiplier to the price
    }


    @Override
    public String displayVenue() {

        return "\n"
                + venueName
                + " Castle\n\n"
                + description
                + "\nLocated in " + location + "."
                + "\nThe maximum capacity is " + capacity
                + " people, priced at £" + String.format("%.2f", calculateCost()) + " per hour.\n";
    }

}
