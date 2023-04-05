import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

/**
 ____                      _              _ _ _     _
 |  _ \  ___    _ __   ___ | |_    ___  __| (_) |_  | |
 | | | |/ _ \  | '_ \ / _ \| __|  / _ \/ _` | | __| | |
 | |_| | (_) | | | | | (_) | |_  |  __/ (_| | | |_  |_|
 |____/ \___/  |_| |_|\___/ \__|  \___|\__,_|_|\__| (_)
 This is support code for the lab. You may look at it if you are interested,
 but you will not have to change anything to complete your lab.
 */

/**
 * This class creates a visualizer for ArrayBuilder to display the different Arrays.
 * (Acts as a PaneOrganizer class)
 */
public class ArrayVisualizer {

    private BorderPane root;
    private AlienArrayListCreator alienArrayListCreator;

    /**
     * The constructor for ArrayVisualizer creates a root pane, creates and adds a
     * pane for the Aliens, aligns the panes and calls the helper method
     * createArrayListControlPanel(). It also creates an instance of the
     * AlienArrayListCreator and passes it the Alien pane
     */
    public ArrayVisualizer() {
        this.root = new BorderPane();
        this.root.setPrefSize(Constant.PANEL_WIDTH, Constant.PANEL_HEIGHT + Constant.CP_HEIGHT);
        this.root.setBottom(this.createArrayListControlPanel());
        Pane alienPane = new Pane();

        this.root.setCenter(alienPane);

        this.alienArrayListCreator = new AlienArrayListCreator(alienPane);
    }


    /**
     * Accessor method for the root pane
     */
    public Pane getRoot(){
        return this.root;
    }

    /**
     * Sets up and returns a pane for the user to interact/generate Aliens.
     * Creates three buttons, and calls the corresponding methods via lambda
     * expressions on the instance of AlienArrayListCreator() when the button
     * is clicked.
     */
    private Pane createArrayListControlPanel() {
        HBox controlPane = new HBox(Constant.PADDING);
        controlPane.setAlignment(Pos.CENTER);
        controlPane.setPadding(new Insets(Constant.PADDING, Constant.PADDING, Constant.PADDING, Constant.PADDING));
        Button addThreeButton = new Button("Add Five");
        addThreeButton.setOnMouseReleased((MouseEvent e) -> this.alienArrayListCreator.addFiveAliens());
        Button makeGreenButton = new Button("Make All Green");
        makeGreenButton.setOnMouseReleased((MouseEvent e) -> this.alienArrayListCreator.makeAllGreen());
        Button removeTwoButton = new Button("Remove Three");
        removeTwoButton.setOnMouseReleased((MouseEvent e) -> this.alienArrayListCreator.removeThreeAliens());
        controlPane.getChildren().addAll(addThreeButton, makeGreenButton, removeTwoButton);
        return controlPane;
    }
}