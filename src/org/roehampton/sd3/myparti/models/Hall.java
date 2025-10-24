package org.roehampton.sd3.myparti.models;


public class Hall extends Venue {

    public Hall(String venueName, String description, String location, int capacity) {

        super(venueName, description, location, capacity);
    }

    @Override
    public double calculateCost() {

        return basePrice; // no multiplier
    }

    @Override
    public void displayVenue() {

        System.out.println(venueName + " Hall" + "\n\n" + description + "\n" + "Located in " + location + "\n" + "The maximum capacity is " + capacity + " people, priced at £" + calculateCost() + " per hour.\n");
    }

}
