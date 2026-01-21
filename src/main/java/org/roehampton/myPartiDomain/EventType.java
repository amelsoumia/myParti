package org.roehampton.myPartiDomain;


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


    @Override
    public String toString() {

        String s = name();
        return Character.toUpperCase(s.charAt(0)) + s.substring(1).toLowerCase();
    }

}

