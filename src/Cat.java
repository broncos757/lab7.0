import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
public class Cat {
    private Ellipse face;
    private Rectangle body;
    private Rectangle leg1;
    private Rectangle leg2;

    public Cat(Pane root){
        this.face = new Ellipse(140, 45,40,40);
        this.body = new Rectangle(0, 60,120,50);
        this.leg1 = new Rectangle(0, 60,40,100);
        this.leg2 = new Rectangle(120, 60,40,100);
        root.getChildren().addAll(this.body, this.leg1, this.leg2, this.face);
    }
    public void moveRight() {
        this.face.setCenterX(face.getCenterX()+5);
        this.body.setX(body.getX()+5);
        this.leg1.setX(leg1.getX()+5);
        this.leg2.setX(leg2.getX()+5);

        if(this.getPos()>500){
            this.face.setCenterX(140);
            this.body.setX(0);
            this.leg1.setX(0);
            this.leg2.setX(120);
        }

    }

    public void changeOutfit(){
        int r = (int) (Math.random() * 256);
        int g = (int) (Math.random() * 256);
        int b = (int) (Math.random() * 256);
        Color col = Color.rgb(r, g, b);
        this.face.setFill(col);
        this.body.setFill(col);
        this.leg1.setFill(col);
        this.leg2.setFill(col);
    }


    public double getPos(){

        return this.body.getX();
    }

}
