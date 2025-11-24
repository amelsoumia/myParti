package org.roehampton.sd3.myparti.models;

import org.roehampton.sd3.myparti.interfaces.Pricing;


public abstract class Facility implements Pricing {

    // Attributes
    private String facilityID;
    protected String facName, description;
    protected double facPrice;


    // Constructor
    public Facility(String facName, String description, double facPrice) {

        this.facName = facName;
        this.description = description;
        this.facPrice = facPrice;
    }


    // Abstract method
    public abstract double calculateCost();

}
