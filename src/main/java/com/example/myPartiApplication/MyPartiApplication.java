package com.example.myPartiApplication;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MyPartiApplication extends Application {

    public static Scene venueScene;
    public static Scene bookingScene;
    public static Scene myBookingsScene;
    public static MyPartiBookingController bookingController;
    public static MyPartiMyBookingsController myBookingsController;

    @Override
    public void start(Stage stage) throws IOException {

        // Main page
        FXMLLoader venueLoader = new FXMLLoader(MyPartiApplication.class.getResource("venue-view.fxml"));
        venueScene = new Scene(venueLoader.load()); stage.setWidth(900); stage.setHeight(600);

        // Booking page
        FXMLLoader bookingLoader = new FXMLLoader(MyPartiApplication.class.getResource("booking-view.fxml"));
        bookingScene = new Scene(bookingLoader.load()); stage.setWidth(900); stage.setHeight(600);
        bookingController = bookingLoader.getController();

        // Receipts page
        FXMLLoader myBookingsLoader = new FXMLLoader(MyPartiApplication.class.getResource("my-bookings-view.fxml"));
        myBookingsScene = new Scene(myBookingsLoader.load()); stage.setWidth(900); stage.setHeight(600);
        myBookingsController = myBookingsLoader.getController();



        // Opens the main scene when run
        stage.setTitle("myParti");
        stage.setScene(venueScene);
        stage.show();

    }
}
