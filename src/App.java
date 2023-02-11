

import cs15.labs.cupcakeSupport.CS15CupcakeFrame;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * This is the second lab, where you are going to run a cupcake shop!
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        // This sets up the empty GUI (Graphical User Interface) frame!
        new CS15CupcakeFrame(stage);
        CupcakeShop t = new CupcakeShop();
        //TODO Instantiate the CupcakeShop here
    }

    /*
     * This is the main method. Don't worry about it, as it just makes an
     * instance of the App class.
     *
     * DO NOT CHANGE THIS CODE.
     */
    public static void main(String[] args) {
        launch(args);
    }
}