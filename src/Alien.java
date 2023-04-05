import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;

/**
 * This class represents an Alien with three circles! When created, its position and
 * color is randomized using the randomLocGenerator() and randomColorGenerator methods().
 * The Alien's location and color can be changed using its mutator methods of setXPos(),
 * setYPos(), and setColor(). Additionally, the Alien can be removed from the pane with
 * the removeFromPane() method.
 */
public class Alien {

    private Circle body;
    private Circle leftEye;
    private Circle rightEye;
    private Pane alienPane;

    /**
     * The constructor takes in a pane and assigns it to the instance variable this.alienPane.
     * It's x and y location are calculated randomly as well as its color, and three circles
     * are created using the generated location and color (the aliens body, left eye, and right
     * eye) and then assigned to instance variables as well.
     */
    public Alien(Pane alienPane) {
        this.alienPane = alienPane;

        int xPos = this.randomLocGenerator();
        int yPos = this.randomLocGenerator();
        Color color = this.randomColorGenerator();

        this.body = new Circle(xPos, yPos, Constant.BODY_RADIUS, color);
        this.leftEye = new Circle(xPos-Constant.EYE_X_OFFSET, yPos-Constant.EYE_Y_OFFSET, Constant.EYE_RADIUS, Color.BLACK);
        this.rightEye = new Circle(xPos+Constant.EYE_X_OFFSET, yPos-Constant.EYE_Y_OFFSET, Constant.EYE_RADIUS, Color.BLACK);

        // TODO graphically add the body, leftEye, and rightEye to the pane
        this.alienPane.getChildren().addAll(body);

    }

    /**
     * Sets the x location of the aline to the given int.
     */
    public void setXPos(int xPos){
        this.body.setCenterX(xPos);
        this.leftEye.setCenterX(xPos-Constant.EYE_X_OFFSET);
        this.rightEye.setCenterX(xPos+Constant.EYE_X_OFFSET);
    }

    /**
     * Sets the y location of the aline to the given int.
     */
    public void setYPos(int yPos){
        this.body.setCenterY(yPos);
        this.leftEye.setCenterY(yPos-Constant.EYE_Y_OFFSET);
        this.rightEye.setCenterY(yPos-Constant.EYE_Y_OFFSET);
    }

    /**
     * Removes the alien graphically from the pane.
     */
    public void removeFromPane(){
        this.alienPane.getChildren().removeAll(this.body, this.leftEye, this.rightEye);
    }

    /**
     * Sets the color of the body of the Alien to the given Color value.
     */
    public void setColor(Color color){
        this.body.setFill(color);
    }

    /**
     * Accessor method for the Alien's body color.
     */
    public Color getColor() {
        return (Color) this.body.getFill();
    }

    /**
     * Generates a random number to be the (x or y) location of the Alien
     */
    private int randomLocGenerator(){
        //generates a random integer between 0 and panel width
        return (int) ((Constant.PANEL_HEIGHT - Constant.RANDOM_LOC_BOUND) * Math.random());
    }

    /**
     * Creates a random javaFX Color value using three random numbers.
     */
    private Color randomColorGenerator(){
        return Color.color(Math.random(), Math.random(), Math.random());
    }
}
