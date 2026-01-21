package org.roehampton.myPartiDomain;


public class Decoration extends Facility {

    // Constructor
    public Decoration(String facName, String description, double facPrice) {

        super(facName, description, facPrice);
    }


    // Implemented method
    @Override
    public double calculateCost() {

        return facPrice;
    }

}
