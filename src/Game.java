import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.input.KeyCode;
import javafx.util.Duration;
import javafx.scene.layout.Pane;
import java.util.ArrayList;
import java.lang.Thread;
import java.util.concurrent.TimeUnit;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Ellipse;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.control.Label;
import javafx.scene.text.Font;

import javafx.scene.control.Label;
import java.lang.InterruptedException;


public class Game {
    private Doodle doodle;
    private Pane gamePane;
    private double velocity;
    private double position;
    private Platform platform;

    private ArrayList<Platform> platforms;

    private Label label;

    private int score = 0;


public Game(Pane game){
    gamePane = game;

    this.platform = new Platform(300,600);
    this.gamePane.getChildren().addAll(platform.getNode());

    this.doodle = new Doodle(300,550);
    this.gamePane.getChildren().addAll(doodle.getNode());


    this.platforms = new ArrayList<Platform>();
    platforms.add(platform);

    Button a = new Button("Quit");
    a.setLayoutY(15);
    this.gamePane.getChildren().addAll(a);
    a.setOnAction((ActionEvent e)-> System.exit(0));

    this.generatePlatforms();
    this.setupTimeline();
}

public void gameOver(){
    for(int i = 0; i < platforms.size(); i++){
        this.gamePane.getChildren().remove(platforms.get(i).getNode());
    }
    Label l = new Label("Game Over!");
    Label s = new Label("Your Score was:"+ score );
    l.setLayoutY(200);
    l.setLayoutX(30);
    s.setLayoutY(330);
    s.setLayoutX(100);
    Font font = new Font("Arial", 120);
    Font f = new Font("Arial", 60);
    l.setFont(font);
    s.setFont(f);
    this.gamePane.getChildren().addAll(l,s);
}
public double semiRandom(double x, double y) {
    double num = Math.abs(x-y) * Math.random();

    return x + num;
}

public void keepInsidePane(){
    if(this.platform.getXPos()>750 || this.platform.getXPos()<50){
        this.platform.setX(400);
    }
}

public void keepDoodleInsidePane(){
    if(doodle.getX()>700){
        doodle.setX(0);
    }
    if(doodle.getX()<0){
        doodle.setX(700);
    }
}

public void generatePlatforms(){
    //not sure how to fix this
    while(this.platform.getYPos()>-10000) {
        double num = Math.random();

        if(num < .25){
            Platform n = new MovingPlatform(this.platform.getXPos() + this.semiRandom(-150, 150), this.platform.getYPos() -this.semiRandom(100, 60));
            platforms.add(n);
            platform = n;
            this.keepInsidePane();
            this.gamePane.getChildren().addAll(platform.getNode());
        }
        else if(num <.5){
            Platform n = new ExtraBouncyPlatform(this.platform.getXPos() + this.semiRandom(-150, 150), this.platform.getYPos() -this.semiRandom(100, 60));
            platforms.add(n);
            platform = n;
            this.keepInsidePane();
            this.gamePane.getChildren().addAll(platform.getNode());
        }
        else if(num < .75){
            Platform n = new DisappearingPlatform(this.platform.getXPos() + this.semiRandom(-150, 150), this.platform.getYPos() -this.semiRandom(100, 60));
            platforms.add(n);
            platform = n;
            this.keepInsidePane();
            this.gamePane.getChildren().addAll(platform.getNode());
        }
        else {
            Platform n = new Platform(this.platform.getXPos() + this.semiRandom(-150, 150), this.platform.getYPos() - this.semiRandom(100, 60));
            platforms.add(n);
            platform = n;
            this.keepInsidePane();
            this.gamePane.getChildren().addAll(platform.getNode());
        }
    }
}

private void setupTimeline(){
        KeyFrame kf = new KeyFrame(Duration.seconds(.05), (ActionEvent e) -> this.updatePos());
        Timeline timeline = new Timeline(kf);
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    private void updatePos(){
    this.gamePane.getChildren().removeAll(label);
    label = new Label("The score is: "+ score);
    this.gamePane.getChildren().addAll(label);

    this.endGame();
    this.handle();
    this.scrollPlatforms();
    this.keepDoodleInsidePane();
    velocity = velocity + Constants.GRAVITY * Constants.DURATION;
    position = doodle.getY() + velocity * Constants.DURATION;
    doodle.setY(position);
}



public void moveRight(){
    doodle.setX(doodle.getX()+3.5);
}
public void moveLeft(){
        doodle.setX(doodle.getX()-3.5);
    }

public boolean intersects(double x, double y, double width, double height){
    if((x + width >= doodle.getX() && x-width <= doodle.getX())&&
            (y + height +15>= doodle.getY() && y-height <= doodle.getY())){
        if(velocity > 0) {
            return true;
        }
        return false;
    }
    return false;
}

public void handle(){
    for(int i = 0; i < platforms.size(); i++){
        if(intersects(platforms.get(i).getXPos(),platforms.get(i).getYPos(),50,20)){

            if(platforms.get(i).getType().equals("ExtraBouncyPlatform")){
                velocity = Constants.REBOUND_VELOCITY*2;

          }
            else if(platforms.get(i).getType().equals("DisappearingPlatform")){
                this.gamePane.getChildren().remove(platforms.get(i).getNode());
                platforms.remove(i);
                velocity = Constants.REBOUND_VELOCITY;

            }
            else{
                velocity = Constants.REBOUND_VELOCITY;
            }
        }
    }
}

public void endGame(){
    if(doodle.getY()> 700){
            this.gameOver();
            doodle.setY(1000);
}
}



public void scrollPlatforms() {
    if (doodle.getY() < 350) {
        double difference = 350- doodle.getY();
        for (int i = 0; i < platforms.size(); i++) {
            platforms.get(i).setY(platforms.get(i).getYPos() + difference);
            this.doodle.setY(700 / 2);
        }
        score++;
    }
}



}
