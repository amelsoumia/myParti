package org.roehampton.sd3.myparti.models;


import java.util.List;

public class Garden extends Venue {

    // Constructor
    public Garden (String venueName, String description, String location, int capacity, List<String> cateringNames, List<String> cateringDescr, List<Double> cateringPrices, List<String> decorNames, List<String> decorDescr, List<Double> decorPrices) {

        super(venueName, description, location, capacity, cateringNames, cateringDescr, cateringPrices, decorNames, decorDescr, decorPrices);
    }


    // Implemented methods
    @Override
    public double calculateCost() {

        return basePrice*1.2; // Adds a multiplier to the price
    }


    @Override
    public String displayVenue() {

        return venueName +
                " Garden\n\n"
                + description
                + "\nLocated in " + location + "."
                + "\nThe maximum capacity is " + capacity
                + " people, priced at £" + calculateCost() + " per hour.\n\n";
    }

}
