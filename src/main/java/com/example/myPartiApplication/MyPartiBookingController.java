package com.example.myPartiApplication;

import javafx.scene.control.*;
import javafx.stage.Stage;
import org.roehampton.myPartiDomain.*;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.collections.FXCollections;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

public class MyPartiBookingController implements Initializable {

    private Venue selectedVenue;
    private Catering selectedCatering;
    private Decoration selectedDecor;

    // Labels that are populated with text depending on user choices
    @FXML
    private Label venueName, cateringInfo, decorInfo, errorLabel;

    // Button to go back to home and button to book venue
    @FXML
    private Button homeBtn, bookBtn;

    // Allow users to select from multiple populated options
    @FXML
    private ComboBox<String> durationsCombo;
    @FXML
    private ComboBox<EventType> eventTypesCombo;
    @FXML
    private ComboBox<String> cateringOptionsCombo, decorOptions;

    // Handle raw user input
    @FXML
    private TextField guestCountInput, firstNameInput, lastNameInput, emailInput, phoneNumberInput;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        // Hides the catering and decor info text
        cateringInfo.setText("");
        decorInfo.setText("");
        errorLabel.setText("");

        // Loads allowed durations into ComboBox
        durationsCombo.setItems(FXCollections.observableArrayList("1 hour" , "3 hours", "6 hours", "12 hours"));

        // Loads event types from Enum into ComboBox
        eventTypesCombo.getItems().setAll(EventType.values());;

        // Displays the description for a selected catering option
        cateringOptionsCombo.valueProperty()
                .addListener((obs, prev, current) -> {

            // Traverses the catering options list, searching for the matching object to the selected option (using stream)
            this.selectedCatering = selectedVenue.getCateringOptions()
                    .stream()
                    .filter(c -> c.getFacilityName().equals(current))
                    .findFirst()
                    .orElse(null);

            if (this.selectedCatering != null) {

                cateringInfo.setText(selectedVenue.displayCateringInfo(this.selectedCatering));
            }
        });

        // Displays the description for a selected decoration option
        decorOptions.valueProperty()
                .addListener((obs, prev, current) -> {

                // Traverses the decorations list, searching for the matching object to the selected option (using stream)
                this.selectedDecor= selectedVenue.getDecorations()
                        .stream()
                        .filter(d -> d.getFacilityName().equals(current))
                        .findFirst()
                        .orElse(null);

                if (this.selectedDecor != null) {

                    decorInfo.setText(selectedVenue.displayDecorInfo(this.selectedDecor));
                }
            });

    }


    // Clears previous selections/inputs when the page is revisited
    private void resetPage() {

        durationsCombo.setValue(null);
        eventTypesCombo.setValue(null);
        cateringOptionsCombo.setValue(null);
        decorOptions.setValue(null);
        cateringOptionsCombo.getItems().clear();
        decorOptions.getItems().clear();

        guestCountInput.clear();
        firstNameInput.clear();
        lastNameInput.clear();
        emailInput.clear();
        phoneNumberInput.clear();

        cateringInfo.setText("");
        decorInfo.setText("");
        errorLabel.setText("");
    }

    // Sets selected venue and displays/loads its necessary info
    public void setVenue(Venue venue) {

        resetPage();

        this.selectedVenue = venue;

        // Loads the selected venue's name into the subheading label
        venueName.setText(selectedVenue.getVenueName());

        // Loads catering and decoration options for the selected venue
        for (Catering c : selectedVenue.getCateringOptions()) {
            cateringOptionsCombo.getItems().add(c.getFacilityName());
        }

        for (Decoration d : selectedVenue.getDecorations()) {
            decorOptions.getItems().add(d.getFacilityName());
        }

    }

    // Returns to home page upon pressing the button
    public void handleClickHomeBtn() {

        Stage stage = (Stage) homeBtn.getScene().getWindow();
        boolean wasWindowMaximised= stage.isMaximized();
        stage.setScene(MyPartiApplication.venueScene);

        // Keeps home page maximised if booking page was when button pressed
        stage.setMaximized(wasWindowMaximised);

    }

    // Converts string value to double for booking constructor later
    public int convertDurationSelection(String durationSelection) {

        return Integer.parseInt(durationSelection.split(" ")[0]);
    }

    // Checks guest count input
    public boolean isValidGuestCount(String guestCount) {

        int maxCount = selectedVenue.getCapacity();

        try {

            int guestCountNum = Integer.parseInt(guestCount);

            if (guestCountNum > 0 && guestCountNum <= maxCount) {

                return true;
            }

            else {

                return false;
            }

        }

        // If anything in the try bracket triggers an error, it is thrown and caught here
        catch (NumberFormatException | NullPointerException e) {

            return false;
        }

    }

    // Creates full name out of first and last name inputs
    public String getFullName(String firstName, String lastName) {

        return firstName + " " + lastName;
    }

    // Check first and last name inputs
    public boolean isValidName(String string) {

        if (string == null || string.isBlank()) {

            return false;
        }

        for (int i = 0; i < string.length(); i++) {

            if (!Character.isLetter(string.charAt(i)) && string.charAt(i) != ' ') {

                return false;
            }
        }

        return true;
    }

    // Checks email format
    public boolean isValidEmail(String email) {

        String emailFormat = "^[A-Za-z0-9._-]+@[A-Za-z0-9.-]+\\.[a-z]+$";
        Pattern pattern = Pattern.compile(emailFormat);

        if(email != null && !email.isBlank() && pattern.matcher(email).matches()) {

            return true;
        };

        return false;
    }

    // Checks phone number format
    public boolean isValidPhoneNumber(String phoneNumber) {

        if (phoneNumber == null || phoneNumber.isBlank()) {

            return false;
        }

        if (Pattern.matches("^\\+?[0-9 ]{7,20}$", phoneNumber)) {

            return true;
        }

        return false;

    }

    // Books the venue and handles its state
    public void handleBookBtn() {

        errorLabel.setText("");

        // Duration input
        String durationSelection = durationsCombo.getValue();

        // Event type input
        EventType eventType = eventTypesCombo.getValue();

        // Guest count input
        String guestCount = guestCountInput.getText().trim();

        // User details input
        String firstName = firstNameInput.getText().trim();
        String lastName = lastNameInput.getText().trim();
        String email = emailInput.getText().trim();
        String phoneNumber = phoneNumberInput.getText().trim();

        if (durationSelection == null ||
                eventType == null ||
                selectedCatering == null ||
                selectedDecor == null ||
                isValidGuestCount(guestCount) == false ||
                isValidName(firstName) == false ||
                isValidName(lastName) == false ||
                isValidEmail(email) == false ||
                isValidPhoneNumber(phoneNumber) == false) {

            errorLabel.setText("Unable to proceed. Please answer all sections correctly.");
        }

        else {

            // Converting inputs into suitable formats for constructor parameters
            String fullName = getFullName(firstName, lastName);
            int duration = convertDurationSelection(durationSelection);
            int guestCountNum = Integer.parseInt(guestCount);

            // Create user
            User user = new User(fullName, phoneNumber, email);

            // Create popup message once booking button is successfully clicked
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("");
            alert.setHeaderText(selectedVenue.getState());
            alert.setContentText(selectedVenue.book(user,selectedCatering, selectedDecor, eventType, guestCountNum, duration));

            // Shows alert, returns user to home page when 'ok' button is clicked
            alert.showAndWait().ifPresent(response -> {

                if (response == ButtonType.OK) {

                    handleClickHomeBtn();
                }
            });

        }

    }

}
