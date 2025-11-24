package org.roehampton.sd3.myparti.models;

import org.roehampton.sd3.myparti.interfaces.IdGenerator;


public class User implements IdGenerator{

    // Attributes
    private static int usedID = 0;

    private String userID, fullName, phoneNumber, email;


    // Constructor
    public User(String fullName, String phoneNumber, String email) {

        this.userID = generateID();
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }


    // Implemented method
    @Override
    public String generateID() {

        int newID = ++usedID;  // Increments ID everytime the method is called

        return "USER" + String.format("%03d", newID);
    }


    // Class method
    public String getName() {

        return fullName;
    }

}
