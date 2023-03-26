import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.animation.KeyFrame;
import javafx.util.Duration;
import javafx.animation.Animation;
import javafx.animation.Timeline;
import javafx.scene.input.KeyCode;
public class PaneOrganizer {

    private VBox root;
    private Game g;
    private Pane gamePane;


    public PaneOrganizer() {
        this.root = new VBox();

        gamePane = new Pane();
        g = new Game(gamePane);
        root.getChildren().addAll(gamePane);

        root.setFocusTraversable(true);
        root.setOnKeyPressed(event -> {
        if (event.getCode() == KeyCode.RIGHT) {
            g.moveRight();
        }
        else if(event.getCode() == KeyCode.LEFT) {
                g.moveLeft();
            }
        });

        Platform p = new ExtraBouncyPlatform(50,50);

    }

    public Pane getRoot() {
        return this.root;
    }
}

