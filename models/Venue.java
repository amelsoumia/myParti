package org.roehampton.sd3.myparti.models;

import org.roehampton.sd3.myparti.interfaces.Pricing;
import org.roehampton.sd3.myparti.interfaces.VenueState;

import java.util.ArrayList;
import java.util.List;


// Creates and displays Venue options to user
public abstract class Venue implements Pricing {

    // Attributes
    private VenueState venueState;

    protected String venueName, description, location;
    protected int capacity;
    protected double basePrice;

    private List<Catering> cateringOptions = new ArrayList<>();
    private List<Decoration> decorations = new ArrayList<>();


    // Constructor to initialise subclasses
    public Venue(String venueName, String description, String location, int capacity, List<String> cateringNames, List<String> cateringDescr, List<Double> cateringPrices, List<String> decorNames, List<String> decorDescr, List<Double> decorPrices) {

        this.venueName = venueName;
        this.description = description;
        this.location = location;
        this.capacity = capacity;

        this.basePrice = 100;
        this.venueState = new VenueStateAvailable(this); // Defaults state to available

        // Creates a list of Catering objects from the lists of its attributes (unique to each Venue object)
        for(int i = 0; i < cateringNames.size(); i++){

            cateringOptions.add(new Catering(cateringNames.get(i), cateringDescr.get(i), cateringPrices.get(i)));
        }

        // Creates a list of Decoration objects from lists of its attributes (unique to each Venue object)
        for(int i = 0; i < decorNames.size(); i++){

            decorations.add(new Decoration(decorNames.get(i), decorDescr.get(i), decorPrices.get(i)));
        }
    }


    // Abstract methods
    public abstract double calculateCost();
    public abstract String displayVenue();


    // Inherited Methods
    public void setState(VenueState venueState) {

        this.venueState= venueState;
    }


    public String getState() {

        return venueState.getVenueState();
    }


    public String book(User user, Facility food, Facility decor, EventType eventType, int guestCount) {

        String message = venueState.bookVenue(this, user, food, decor, eventType, guestCount);

        return message;
    }


    public String getVenueName() {

        return venueName;
    }


    public List<Catering> getCateringOptions() {

        return cateringOptions;
    }


    public List<Decoration> getDecorations() {

        return decorations;
    }


    public String listCateringOptions() {

        StringBuilder output = new StringBuilder();

        output.append("Catering Options:\n\n");

        for (Catering c : cateringOptions) {

            output.append(c.facName)
                    .append("\n")
                    .append(c.description)
                    .append("\nPrice: £")
                    .append(c.facPrice)
                    .append("\n\n");
        }

        return output.toString();
    }


    public String listDecorOptions() {

        StringBuilder output = new StringBuilder();

        output.append("Decoration Options:\n\n");

        for (Decoration d : decorations) {

            output.append(d.facName)
                    .append("\n")
                    .append(d.description)
                    .append("\nPrice: £")
                    .append(d.facPrice)
                    .append("\n\n");
        }

        return output.toString();
    }
}
