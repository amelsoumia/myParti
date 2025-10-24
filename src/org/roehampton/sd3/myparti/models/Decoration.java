package org.roehampton.sd3.myparti.models;

import java.util.ArrayList;
import java.util.List;


public class Decoration extends Facility {

    private static List<Decoration> Decorations = new ArrayList<>();

    public Decoration(String facName, String description, double facPrice) {

        super(facName, description, facPrice);
        Decorations.add(this); // adds every instance of Decoration to this list
    }

    @Override
    public double calculateCost() {

        return facPrice;
    }

    public void listOptions() {

        System.out.println("Decoration Options:" + "\n");

        // Loops through every instance in list
       for(Decoration d : Decorations) {
           System.out.println(d.facName + "\n" + d.description + "\nPrice: £" + d.facPrice + "\n\n");
       }
    }
}
