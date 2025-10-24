package org.roehampton.sd3.myparti.models;

public enum EventType {

    WEDDING(1.5),
    BIRTHDAY(1),
    OTHER(1);

    public double multiplier;

    EventType(double i) {

        multiplier = i;
    }

    public double getMultiplier() {

        return multiplier;
    }

}

