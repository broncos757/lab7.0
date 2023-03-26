import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.scene.Node;

public class Doodle {
    private Ellipse doodle;
    public Doodle(double x, double y){
        doodle = new Ellipse(x, y, 20, 20);

    }
    public void setX(double x){
        doodle.setCenterX(x);
    }
    public void setY(double y){
        doodle.setCenterY(y);
    }
    public double getX(){
        return doodle.getCenterX();
    }

    public double getY(){
        return doodle.getCenterY();
    }
    public Node getNode(){
        return doodle;
    }
}
