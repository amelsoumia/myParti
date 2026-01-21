package com.example.myPartiApplication;

import org.roehampton.myPartiDomain.*;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;


public class MyPartiVenueController implements Initializable {


    // List loaded to be displayed in GUI
    @FXML
    private ListView<Venue> venueList;

    // Label that is populated with venue details
    @FXML
    private Label venueDetails;

    // Button that takes the user to a venue's booking page
    @FXML
    private Button selectVenueBtn, menuBtn1, menuBtn2, myBookingsBtn;

    @FXML
    private VBox menuBarLayer;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        // Hides the 'venue information side'
        venueDetails.setVisible(false);
        selectVenueBtn.setVisible(false);

        // Catering and decoration info for venue1
        List<String> cateringNames1 = List.of("Indian", "Middle Eastern");
        List<String> cateringDescs1 = List.of("Rice served with staple Indian curries.", "Rice served with grilled meats and salad.");
        List<Double> cateringPrice1 = List.of(10.00, 15.00);

        List<String> decorNames1 = List.of("Classic Wedding", "Woodland Fairy");
        List<String> decorDescs1 = List.of("Simple and silver theme, includes flowers.", "Suitable for themed children's birthday parties.");
        List<Double> decorPrice1 = List.of(500.00, 200.00);


        // Catering and decoration info for venue2
        List<String> cateringNames2 = List.of("Indian", "British");
        List<String> cateringDescs2 = List.of("Rice served with staple Indian curries.", "Classic British meat dishes served with soup.");
        List<Double> cateringPrice2 = List.of(10.00, 10.00);

        List<String> decorNames2 = List.of("Classic Wedding", "Woodland Fairy");
        List<String> decorDescs2 = List.of("Simple and silver theme, includes flowers.", "Suitable for themed children's birthday parties.");
        List<Double> decorPrice2 = List.of(500.00, 200.00);


        // Catering and decoration info for venue3
        List<String> cateringNames3 = List.of("Pizza Party", "Aperitif", "Afternoon Tea");
        List<String> cateringDescs3 = List.of("Selection of pizza options for everyone.", "Classic French snacks and drinks served.", "English tea served with cake and snacks." );
        List<Double> cateringPrice3 = List.of(15.00, 20.00, 10.00);

        List<String> decorNames3 = List.of("Classic Wedding", "Woodland Fairy");
        List<String> decorDescs3 = List.of("Simple and silver theme, includes flowers.", "Suitable for themed children's birthday parties.");
        List<Double> decorPrice3 = List.of(500.00, 200.00);


        // Creating the venues
        Venue v1 = new Hall("Fete D'Or", "A luxurious hall fit for any event.", "London", 500, cateringNames1, cateringDescs1, cateringPrice1, decorNames1, decorDescs1, decorPrice1);
        Venue v2 = new Garden("Paradise", "A beautiful outdoor space that holds many happy memories.", "Oxford", 500, cateringNames2, cateringDescs2, cateringPrice2, decorNames2, decorDescs2, decorPrice2);
        Venue v3 = new Rooftop("The Diamond", "Great space for parties, providing a full view of London.", "London", 200, cateringNames3, cateringDescs3, cateringPrice3, decorNames3, decorDescs3, decorPrice3);


        // Add venues to the list
        venueList.getItems().addAll(v1, v2, v3);

        // Sets size of the ListView relative to the number of cells (venues)
        venueList.setFixedCellSize(40);

        venueList.prefHeightProperty()
                .bind(venueList.fixedCellSizeProperty()
                .multiply(venueList.getItems().size()));

        // Display venue information for the one that is clicked
        venueList.getSelectionModel()
                .selectedItemProperty()
                .addListener((obs, prev, current) -> {

                    if (current != null) {

                        venueDetails.setText(current.displayVenue());
                        venueDetails.setVisible(true);
                        selectVenueBtn.setVisible(true);
                    }
                }
        );

    }

    // Opens a new 'booking' window upon pressing the button
    @FXML
    private void handleSelectVenueBtn() {

        // Selected venue upon button click stored
        Venue selectedVenue= venueList.getSelectionModel().getSelectedItem();

        MyPartiApplication.bookingController.setVenue(selectedVenue);

        // Booking page loaded after button click
        Stage stage = (Stage) selectVenueBtn.getScene().getWindow();
        boolean wasWindowMaximised= stage.isMaximized();
        stage.setScene(MyPartiApplication.bookingScene);

        // Keeps new window maximised if original window was when button pressed
        stage.setMaximized(wasWindowMaximised);

    }

    @FXML
    private void openMenu() {

        menuBarLayer.setVisible(true);
        menuBarLayer.setManaged(true);
    }

    @FXML
    private void closeMenu() {

        menuBarLayer.setVisible(false);
        menuBarLayer.setManaged(false);
    }

    // Opens the 'My Bookings' page
    @FXML
    private void handleMyBookingsBtn() {

        MyPartiApplication.myBookingsController.setBookingsList();

        // 'My Bookings' page loaded after button click
        Stage stage = (Stage) myBookingsBtn.getScene().getWindow();
        boolean wasWindowMaximised= stage.isMaximized();
        stage.setScene(MyPartiApplication.myBookingsScene);

        // Keeps the window maximised if the home page was
        stage.setMaximized(wasWindowMaximised);

    }


}
