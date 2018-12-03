//  Created by
//  Elijah Luckey
//  Jericho Mowry
//  for COP3330 - Computer Programming 2 Section 02

package airlinetoolapp;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
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
            passengerNameRes, seatNumberRes, flightNumberOnMapField, 
            SpecificFlightTextField;
    
    @FXML
    private Pane newFlightPane, newReservationPane, seatMapPane, 
            listAllFlightsPane, listAllReservationsPane, 
            listAllFlightReservationsPane, exitPane;
    
    @FXML
    private TextArea seatMapArea, listAllFlightsArea, listOfAllPassangerReservations, 
    listOfSpecificPassangerReservations;
    
    @FXML
    void updatSeatMap(ActionEvent event) throws FileNotFoundException, IOException {
        
        String flightNumberOnMap = flightNumberOnMapField.getText();
        BufferedReader flightIn = null;
        
        seatMapArea.setText("");
        
        // used for creating file location - found in smae packagae as cwd
        final String dir = System.getProperty("user.dir");
        String packageString = "\\src\\airlinetoolapp\\";
        String fileName = "flights.txt";
        String fileNameFlights = dir + packageString + fileName;
        
        try{
            
            // using a Scanner object for "scanning"
            flightIn = new BufferedReader(new FileReader(fileNameFlights));
            String flightLine; // String use to display the whole line from .txt
            String[] lineArr; // initialized array
            
            while ( (flightLine = flightIn.readLine()) != null) {
                
                // splits the line into an array of the values 
                lineArr = flightLine.split("\t");
                
                // this location in the array will always hold the availble seats
                int arrLength = lineArr.length-1; 

                // the first [0] index in the array will always hold the flight#
                if(lineArr[0].equals(flightNumberOnMap)){
                    
                    int numSeats    = Integer.parseInt(lineArr[arrLength]);
                    int rowSeats    = numSeats / 7;
                    int lastRowSeat = numSeats % 7;
                    
                    String mapSkel = "\tA B     C D E     F G\n";
                    System.out.println(rowSeats + " " + lastRowSeat);
                    
                    // prints the rows onto the display
                    for (int i = 0; i < rowSeats; i++) {
                        seatMapArea.appendText((i+1) + mapSkel);
                    }
                    
                    if (lastRowSeat > 0){
                        switch (lastRowSeat){
                            case 1: seatMapArea.appendText((rowSeats + 1) 
                                    + "\tA\n");
                            break;
                            case 2: seatMapArea.appendText((rowSeats + 1) 
                                    + "\tA B\n");
                            break;
                            case 3: seatMapArea.appendText((rowSeats + 1) 
                                    + "\tA B     C\n");
                            break;
                            case 4: seatMapArea.appendText((rowSeats + 1) 
                                    + "\tA B     C D\n");
                            break;
                            case 5: seatMapArea.appendText((rowSeats + 1) 
                                    + "\tA B     C D E\n");
                            break;
                            case 6: seatMapArea.appendText((rowSeats + 1) 
                                    + "\tA B     C D E    F\n");
                            break;
                        }
                    }
                    
                }
            }
        }finally{
            flightIn.close();
        } 
    } 

    // addFlight() method adds the fields in the 
    @FXML
    void addFlight(ActionEvent event) throws FileNotFoundException, IOException {
        FileWriter flightsOut   = null;
        
        // setup of String values
        String flightNumber     = flightNumField.getText();
        String flightDate       = flightDateField.getText();
        String departureTime    = departureTimeField.getText();
        String arrivalTime      = arrivalTimeField.getText();
        String departureCity    = departureCityField.getText();
        String arrivalCity      = arrivalCityField.getText();
        String availableSeats   = availableSeatsField.getText();
        
        final String dir = System.getProperty("user.dir");
        String packageString = "\\src\\airlinetoolapp\\";
        String fileName = "flights.txt";
        String fileNameFlights = dir + packageString + fileName; // use print line to check

        try{
            // object assigned as a FileWrite object
            flightsOut = new FileWriter(fileNameFlights, true);
            
            // string for writing the data to the file
            String flightDataLine = flightNumber + "\t" + flightDate  + "\t" + 
                    departureTime + "\t" + arrivalTime + "\t" + departureCity + 
                    "\t" + arrivalCity + "\t" + availableSeats + "\n";
            flightsOut.write(flightDataLine); // data is written to file
        }finally{
            flightsOut.close();
            
        }
    }
    
    @FXML
    void addNewReservation(ActionEvent event) throws FileNotFoundException, IOException {
        // on button press, method should read all text fields and then add to 
        // appropiate .txt files
        
        // these create a String with proper file location
        final String dir        = System.getProperty("user.dir");
        String packageString    = "\\src\\airlinetoolapp\\";
        String fileName         = "reservations.txt";
        String fileNameFlights  = dir + packageString + fileName;
        
        // setup of String-grabbing for file writing
        String flightNumber     = flightNumberRes.getText();
        String passengerID      = PassengerIDRes.getText();
        String PassengerName    = passengerNameRes.getText();
        String seatNumber       = seatNumberRes.getText();
        
        try (FileWriter reservationsOut = new FileWriter(fileNameFlights, true)) {
            
            reservationsOut.write(passengerID + "\t" + PassengerName + "\t" +
                    seatNumber + "\t" + flightNumber + "\n");
        }
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
    void listAllFlightsButtonAction(ActionEvent event) throws FileNotFoundException, IOException {
        listAllFlightsPane.toFront();   // brings this pane to front at button press

        final String dir = System.getProperty("user.dir");
        String packageString = "\\src\\airlinetoolapp\\";
        String fileNameFlights = "flights.txt";
        
        listAllFlightsArea.setText("");
        BufferedReader bf = null;
        try{
            bf = new BufferedReader(new FileReader(dir+packageString+fileNameFlights));
            String str;
            while ((str = bf.readLine()) != null){
                listAllFlightsArea.appendText(str+"\n");
            }
        }
        finally{
            bf.close();
        }
    }

    @FXML
    void listAllReservationsButtonAction(ActionEvent event) throws IOException {
        
        listAllReservationsPane.toFront();  // brings this pane to front at button press
        
        final String dir = System.getProperty("user.dir");
        String packageString = "\\src\\airlinetoolapp\\";
        String fileNameFlights = "reservations.txt";
        
                
        listOfAllPassangerReservations.setText("");
        try(BufferedReader bf = new BufferedReader(new FileReader(dir+packageString+fileNameFlights))) {
            String str;
            while ((str = bf.readLine()) != null){
                listOfAllPassangerReservations.appendText(str+"\n");
            }
        }
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

    @FXML
    void showSpecificFlightReservations(ActionEvent event) throws FileNotFoundException, IOException {
        String flightNumber = SpecificFlightTextField.getText();
        final String dir = System.getProperty("user.dir");
        String packageString = "\\src\\airlinetoolapp\\";
        String fileNameFlights = "reservations.txt";
        
                
        listOfSpecificPassangerReservations.setText("");
	listOfSpecificPassangerReservations.appendText(String.format("%-25s %-20s %-15s %-10s%n", "ID", "Name", "SeatNumber", "Flight#"));
        BufferedReader bf = null;
        try{
            bf = new BufferedReader(new FileReader(dir+packageString+fileNameFlights));
	    
            String str;
            while ((str = bf.readLine()) != null){
                String[] strArray = str.split("\t");
                //listOfSpecificPassangerReservations.setText(strArray[3]);
		System.out.println(strArray[3]);
		
		//System.out.println(flightNumber);
                if (flightNumber.contentEquals(strArray[3])){
                    listOfSpecificPassangerReservations.appendText(String.format("%-20s %-20s %-15s %-10s%n", strArray[0], strArray[1], 
			    strArray[2], strArray[3]));
		    System.out.println("KK");
                }
            }
        }
        finally{
            bf.close();
        }
        

    }
    
}
