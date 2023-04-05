
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

//public class App extends Application {

    //@Override
    //public void start(Stage stage) {

        //PaneOrganizer organizer = new PaneOrganizer();
        //Scene scene = new Scene(organizer.getRoot(), 700, 700);
        //stage.setScene(scene);
        //stage.show();


    //}
    //public static void main(String[] argv) {
       // launch(argv);
  //  }
//}


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 ____                      _              _ _ _     _
 |  _ \  ___    _ __   ___ | |_    ___  __| (_) |_  | |
 | | | |/ _ \  | '_ \ / _ \| __|  / _ \/ _` | | __| | |
 | |_| | (_) | | | | | (_) | |_  |  __/ (_| | | |_  |_|
 |____/ \___/  |_| |_|\___/ \__|  \___|\__,_|_|\__| (_)
 This is support code for the lab. You may look at it if you are interested,
 but you will not have to change anything to complete your lab.
 */


public class App extends Application {

    /**
     * Sets up the stage, shows the scene, and creates an instance of ArrayVisualizer()
     */
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Lab 6");
        primaryStage.setScene(new Scene(new ArrayVisualizer().getRoot()));
        primaryStage.show();
    }

    /**
     * Main method. Do not edit!
     */
    public static void main(String[] args) {
        launch(args);
    }
}
