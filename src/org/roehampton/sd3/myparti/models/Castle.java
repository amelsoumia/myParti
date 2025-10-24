package org.roehampton.sd3.myparti.models;


public class Castle extends Venue {

    public Castle(String venueName, String description, String location, int capacity) {

        super(venueName, description, location, capacity);
    }

    @Override
    public double calculateCost() {

        return basePrice*2; // adds a multiplier to the price
    }

    @Override
    public void displayVenue() {

        System.out.println(venueName + " Castle" + "\n\n" + description + "\n" + "Located in " + location + "\n" + "The maximum capacity is " + capacity + " people, priced at £" + calculateCost() + " per hour.\n");
    }

}
