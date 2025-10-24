package org.roehampton.sd3.myparti.models;

import org.roehampton.sd3.myparti.interfaces.IdGenerator;
import org.roehampton.sd3.myparti.interfaces.Pricing;


public abstract class Facility implements IdGenerator, Pricing {

    private static int usedID = 0;

    private String facilityID;
    protected String facName, description;
    protected double facPrice;

    public Facility(String facName, String description, double facPrice) {

        this.facilityID = generateID();
        this.facName = facName;
        this.description = description;
        this.facPrice = facPrice;
    }

    @Override
    public String generateID() {

        int newID =+ usedID;  // increments ID everytime the method is called
        usedID = newID;

        return "FAC" + newID;
    }

    @Override
    public abstract double calculateCost();

    public abstract void listOptions();

    //  takeRequests() here //


}
