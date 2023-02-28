import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.animation.KeyFrame;
import javafx.util.Duration;
import javafx.animation.Animation;
import javafx.animation.Timeline;
public class PaneOrganizer {

    private VBox root;
    private Cat cat;

    private Label label;

    public PaneOrganizer() {
        this.root = new VBox();
        Pane catPane = new Pane();
        this.cat = new Cat(catPane);
        this.root.getChildren().addAll(catPane);

        label = new Label();
        this.root.getChildren().add(label);

        Button b = new Button("quit");
        this.root.getChildren().addAll(b);
        b.setOnAction((ActionEvent e)-> System.exit(1));

        Button a = new Button("Change Outfit");
        this.root.getChildren().addAll(a);
        a.setOnAction((ActionEvent e)-> cat.changeOutfit());

        label = new Label("label");
        this.root.getChildren().add(label);

        this.setupTimeline();

    }

    private void setupTimeline(){
        KeyFrame kf = new KeyFrame(Duration.seconds(.1), (ActionEvent e) -> this.update());
        Timeline timeline = new Timeline(kf);
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }
    private void update(){
        this.cat.moveRight();
        this.updateLabel();
    }

    private void updateLabel(){
        double x = cat.getPos();
        this.label.setText("The Position is: " + x);
    }


    public Pane getRoot() {
        return this.root;
    }
}