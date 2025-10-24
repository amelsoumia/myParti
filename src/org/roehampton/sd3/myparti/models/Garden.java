package org.roehampton.sd3.myparti.models;


public class Garden extends Venue {

    public Garden (String venueName, String description, String location, int capacity) {

        super(venueName, description, location, capacity);
    }

    @Override
    public double calculateCost() {

        return basePrice*1.2; // adds a multiplier to the price
    }

    @Override
    public void displayVenue() {

        System.out.println(venueName + " Garden" + "\n\n" + description + "\n" + "Located in " + location + "\n" + "The maximum capacity is " + capacity + " people, priced at £" + calculateCost() + " per hour.\n");
    }

}
