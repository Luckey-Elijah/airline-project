//  Created by
//  Elijah Luckey
//  Jericho Mowry
//  for COP3330 - Computer Programming 2 Section 02

package airlinetoolapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

//  This is the main Java class that will launch the instance of the Window.
public class AirlineToolApp extends Application {
    
    //  The start() method creates an object for launching the "windowFXML.fxml" 
    //  file. Edit the FXML to change the look and function of the window layout.
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("windowFXML.fxml"));
        
        //  create object for 
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }
    
    //  main() method calls the launch() method.
    public static void main(String[] args) {
        launch(args);
    }
    
}
