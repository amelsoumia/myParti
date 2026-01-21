package com.example.myPartiApplication;

import org.roehampton.myPartiDomain.*;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.stage.Stage;

import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Button;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.net.URL;
import java.util.ResourceBundle;


public class MyPartiMyBookingsController implements Initializable{

    @FXML
    Button homeBtn, cancelBookingBtn;

    @FXML
    private ListView<Booking> bookingsList;

    @FXML
    private Label bookingDetails;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        // Hides the booking information side
        bookingDetails.setText("");
        cancelBookingBtn.setVisible(false);

        // Display venue information for the one that is clicked
        bookingsList.getSelectionModel()
                .selectedItemProperty()
                .addListener((obs, prev, current) -> {

                    if (current != null) {

                        bookingDetails.setText(current.displayBooking());
                        bookingDetails.setVisible(true);
                        cancelBookingBtn.setVisible(true);
                    }

                });
    }

    // Clears all content
    public void refreshPage() {

        bookingDetails.setText("");
        cancelBookingBtn.setVisible(false);

        bookingsList.getItems().clear();
    }

    // Populates the page with updated content
    public void setBookingsList() {

        refreshPage();

        // Add bookings to list
        for (Booking b : BookingManager.getInstance().getBookings()) {

            bookingsList.getItems().add(b);
        }

        // Sizes the ListView to the number of bookings
        bookingsList.setFixedCellSize(40);
        bookingsList.setPrefHeight(bookingsList.getFixedCellSize() * bookingsList.getItems().size());
    }

    // Returns to home page upon pressing the button
    public void handleClickHomeBtn() {

        Stage stage = (Stage) homeBtn.getScene().getWindow();
        boolean wasWindowMaximised= stage.isMaximized();
        stage.setScene(MyPartiApplication.venueScene);

        // Keeps home page maximised if booking page was when button pressed
        stage.setMaximized(wasWindowMaximised);
    }

    // Cancels a user's selected booking
    public void cancelBooking() {

        // Checks if user intends to cancel
        Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
        confirm.setContentText("Are you sure you would like to cancel your booking?");
        confirm.setTitle("");
        confirm.setHeaderText("Confirmation");

        ButtonType yesBtn = new ButtonType("Yes");
        confirm.getButtonTypes().setAll(yesBtn);

        // Cancels if the yes button is pressed
        confirm.showAndWait().ifPresent(btn -> {
            if (btn == yesBtn) {

                // Removes selected booking from bookings list and UI
                Booking currentBooking = bookingsList.getSelectionModel().getSelectedItem();
                BookingManager.getInstance().cancelBooking(currentBooking);

                setBookingsList(); // Refreshes and removes the deleted booking
            }
        });
    }
}
