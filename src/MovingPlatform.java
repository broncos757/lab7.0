import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.util.Duration;
import javafx.scene.layout.Pane;

public class MovingPlatform extends Platform{
    public MovingPlatform(double x, double y){
        super(x,y);
        this.animation();
        super.changeColorBlue();
        super.setType("MovingPlatform");

    }

    public void animation(){
        KeyFrame kf = new KeyFrame(Duration.seconds(.03), (ActionEvent e) -> this.move());
        Timeline timeline = new Timeline(kf);
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    public void move(){
        super.setX(super.getXPos()+3);
        if(super.getXPos()> 700){
            super.setX(0);
        }
    }
}
