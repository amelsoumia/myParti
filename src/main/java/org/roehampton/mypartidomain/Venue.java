package org.roehampton.mypartidomain;

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


    @Override
    public String toString() {

        return getVenueName();
    }


    // Inherited Methods
    public void setState(VenueState venueState) {

        this.venueState= venueState;
    }

    public String getState() {

        return venueState.getVenueState();
    }


    public String book(User user, Facility food, Facility decor, EventType eventType, int guestCount, int duration) {

        String message = venueState.bookVenue(this, user, food, decor, eventType, guestCount, duration);

        return message;
    }


    public String getVenueName() {

        return venueName;
    }

    public int getCapacity() {

        return capacity;
    }

    public List<Catering> getCateringOptions() {

        return cateringOptions;
    }


    public List<Decoration> getDecorations() {

        return decorations;
    }


    public String displayCateringInfo(Facility c) {

        StringBuilder output = new StringBuilder();

        output.append(c.description)
                .append("\nPrice: £")
                .append(String.format("%.2f", c.facPrice))
                .append(" per person.");

        return output.toString();
    }


    public String displayDecorInfo(Facility d) {

        StringBuilder output = new StringBuilder();

        output.append(d.description)
                .append("\nPrice: £")
                .append(String.format("%.2f", d.facPrice))
                .append(".");

        return output.toString();
    }
}
