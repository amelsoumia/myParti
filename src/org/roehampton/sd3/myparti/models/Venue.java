package org.roehampton.sd3.myparti.models;

import org.roehampton.sd3.myparti.interfaces.IdGenerator;
import org.roehampton.sd3.myparti.interfaces.Pricing;


// Creates and displays Venue options to user
public abstract class Venue implements IdGenerator, Pricing {

    // Attributes
    private static int usedID = 0; //initialises usedID for generator

    protected String venueID, venueName, description, location;
    protected int capacity;
    protected double basePrice;

    // Constructor to initialise subclasses
    public Venue(String venueName, String description, String location, int capacity) {

        // Add validation later!!! //
        this.venueID = generateID(); // Uses method from IdGenerator interface
        this.venueName = venueName;
        this.description = description;
        this.location = location;
        this.capacity = capacity;
        this.basePrice = 100;
    }

    @Override
    public String generateID() {

        int newID =+ usedID;  // increments ID everytime the method is called
        usedID = newID;

        return "VEN" + newID;
    }


    public abstract double calculateCost();

    public abstract void displayVenue();



}
