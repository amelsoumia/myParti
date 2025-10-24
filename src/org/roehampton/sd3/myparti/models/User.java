package org.roehampton.sd3.myparti.models;

import org.roehampton.sd3.myparti.interfaces.IdGenerator;


public class User implements IdGenerator{

    private static int usedID = 0;

    private String userID, fullName, phoneNumber, email;

    public User(String fullName, String phoneNumber, String email) {

        // Manually initiating users for now, will take user input for details later //
        this.userID = generateID();
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    @Override
    public String generateID() {

        int newID =+ usedID;  // increments ID everytime the method is called
        usedID = newID;

        return "USER" + newID;
    }

    public String getName(){

        return fullName;
    }


    // private String takeDetails() here //


}
