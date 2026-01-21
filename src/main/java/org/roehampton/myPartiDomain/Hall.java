package org.roehampton.myPartiDomain;

import static org.roehampton.myPartiDomain.Booking.*;

import java.util.List;


public class Hall extends Venue {

    // Constructor
    public Hall(String venueName, String description, String location, int capacity, List<String> cateringNames, List<String> cateringDescr, List<Double> cateringPrices, List<String> decorNames, List<String> decorDescr, List<Double> decorPrices) {

        super(venueName, description, location, capacity, cateringNames, cateringDescr, cateringPrices, decorNames, decorDescr, decorPrices);
    }


    // Implemented methods
    @Override
    public double calculateCost() {

        return basePrice*getDuration(); // No multiplier
    }


    @Override
    public String displayVenue() {

        return "\n"
                + venueName
                + " Hall\n\n"
                + description
                + "\nLocated in " + location + "."
                + "\nThe maximum capacity is " + capacity
                + " people, priced at £" + String.format("%.2f", calculateCost()) + " per hour.\n";
    }

}
