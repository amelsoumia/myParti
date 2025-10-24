package org.roehampton.sd3.myparti.models;

import java.util.ArrayList;
import java.util.List;

public class Catering extends Facility {

    private static List<Catering> cateringOptions = new ArrayList<>();

    public Catering(String facName, String description, double facPrice) {

        super(facName, description, facPrice);
        cateringOptions.add(this); // adds every instance of Catering to this list
    }

    @Override
    public double calculateCost() {

        return facPrice*Booking.getGuestCount();
    }

    public void listOptions() {

        System.out.println("Catering Options:" + "\n");

        // Loops through every instance in list
        for(Catering c : cateringOptions) {
            System.out.println(c.facName + "\n" + c.description + "\nPrice per guest: £" + c.facPrice + "\n\n");
        }
    }
}
