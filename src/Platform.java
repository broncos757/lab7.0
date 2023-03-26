import javafx.scene.shape.Rectangle;
import javafx.scene.Node;
import javafx.scene.paint.Color;
public class Platform {
    private Rectangle platform;

    private String type = "defaultPlatform";
public Platform(double x, double y){

    platform = new Rectangle(x, y, 50, 20);

}
public void setType(String s){
    type = s;
}
public String getType(){
    return type;
}
public void setX(double x){
    platform.setX(x);
}

public void setY(double y){
    platform.setY(y);
}
public double getXPos(){
    return platform.getX();
}

public double getYPos(){
    return platform.getY();
}

public void changeColorBlue(){
    platform.setFill(Color.BLUE);
}
public void changeColorRed(){
    platform.setFill(Color.RED);
}

public void changeColorGreen(){
    platform.setFill(Color.GREEN);
}

public Node getNode(){
    return platform;
}
}


