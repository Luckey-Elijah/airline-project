//  Created by
//  Elijah Luckey
//  Jericho Mowry
//  for COP3330 - Computer Programming 2 Section 02

package airlinetoolapp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class windowFXMLController implements Initializable {
    
    @FXML
    private TextField flightNumField, flightDateField, departureTimeField, 
            arrivalTimeField, departureCityField, arrivalCityField, 
            availableSeatsField, flightNumberRes,  PassengerIDRes, 
            passengerNameRes, seatNumberRes;

    
    @FXML
    private Pane newFlightPane, newReservationPane, seatMapPane, 
            listAllFlightsPane, listAllReservationsPane, 
            listAllFlightReservationsPane, exitPane;
    
    
    @FXML
    private TextArea seatMapArea, listAllFlightsArea;

    
    @FXML
    void updatSeatMap(ActionEvent event) {
        
    }
    
    @FXML
    void addFlight(ActionEvent event) throws FileNotFoundException, IOException {
        FileInputStream flightsIn   = null;
        FileWriter flightsOut       = null;
        
        String flightNumber     = flightNumField.getText();
        String flightDate       = flightDateField.getText();
        String departureTime    = departureTimeField.getText();
        String arrivalTime      = arrivalTimeField.getText();
        String departureCity    = departureCityField.getText();
        String arrivalCity      = arrivalCityField.getText();
        String availableSeats   = availableSeatsField.getText();
        try{
            flightsIn = new FileInputStream("C:\\Java8\\AirlineToolApp\\src\\resources\\flights.txt");
            flightsOut = new FileWriter("C:\\Java8\\AirlineToolApp\\src\\resources\\flightsCopy.txt");
            
            final String dir = System.getProperty("user.dir");
            System.out.println("current dir = " + dir);
            
            int c;
            while ((c = flightsIn.read()) != -1){
                System.out.print(c);
                flightsOut.write(c);
            }
        }finally{
            if(flightsIn != null){
                flightsIn.close();
            }
            if(flightsOut != null){
                flightsOut.close();
            }
        }
    }
    
    @FXML
    void addNewReservation(ActionEvent event) {
        // on button press, method should read all text fields and then add to 
        // appropiate .txt files
        
        String flightNumber     = flightNumberRes.getText();
        String passengerID      = PassengerIDRes.getText();
        String PassengerName    = passengerNameRes.getText();
        String seatNumber       = seatNumberRes.getText();
    }
    
    @FXML
    void displaySeatMapButtonAction(ActionEvent event) {
        seatMapPane.toFront();  // brings seatMapPane to front at button press
    }

    @FXML
    void exitButtonAction(ActionEvent event) {
        exitPane.toFront();     // brings exitPane to front at button press
    }

    @FXML
    void listAllFlightReservationsAction(ActionEvent event) {
        listAllFlightReservationsPane.toFront(); // brings this pane to front at button press
    }

    @FXML
    void listAllFlightsButtonAction(ActionEvent event) {
        listAllFlightsPane.toFront();   // brings this pane to front at button press
    }

    @FXML
    void listAllReservationsButtonAction(ActionEvent event) {
        listAllReservationsPane.toFront();  // brings this pane to front at button press
    }

    @FXML
    void newFlightButtonAction(ActionEvent event) {
        newFlightPane.toFront();        // brings newFlightPane to front at button press
    }

    @FXML
    void newReservationButtonAction(ActionEvent event) {
        newReservationPane.toFront();   // brings this pane to front at button press
    }
    
    @FXML
    void exitApplication(ActionEvent event) {
        Platform.exit();    // when exitApplication button is pressed, the application exits
    }

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
