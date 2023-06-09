
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class AlienArrayCreator {

    private Alien[] alienArray; // we're declaring the array variable here!
    private Pane alienPane;

    public AlienArrayCreator(Pane alienPane) {
        this.alienPane = alienPane;
        alienArray = new Alien[10];

        //TODO: Initialize the array here
    }

    public void generateAliens() {
        this.reset(); //don't worry about this! it's just to make sure you don't double generate

        /*TODO:
            1. Loop through the length of your alien array
            2. At each iteration, create an Alien object
            3. Store the Alien object in the array
            4. Don't forget to add the Alien to the pane!
         */
        for(int i = 0; i <alienArray.length; i++){
            Alien a = new Alien(Color.BLUE);
            alienArray[i] = a;
            a.addToPane(alienPane);
        }
    }

    public void alternateAlienColors() {
        /*TODO:
            1. Loop through your alien array
            2. If the alien's index is even, change it's color to blue
            3. If the alien's index is odd, change it's color to green

         */
        for(int i = 0; i < alienArray.length;i++){
            if(i%2 == 0){
                alienArray[i].setColor(Color.LIGHTGREEN);
            }
            else{
                alienArray[i].setColor(Color.SKYBLUE);
            }
        }
    }

    public void lineUpAliens() {
        /*TODO:
            1. Loop through your alien array
            2. For every alien, make the y position the center of the screen (250)
            3. For every alien, make the x position dependent on it's index in the array
                See the handout for an example
         */
        for(int i = 0; i < alienArray.length; i++){
            Alien a = alienArray[i];
            a.setYPos(250);
        }
        for (int i =0; i < alienArray.length; i ++) {
             Alien a = alienArray[i];
             a.setXPos(i * 50 + 30);
         }
    }

    public void removeBlue() {
        /*TODO:
            1. Loop through your alien array
            2. If the color of the alien is SKYBLUE, remove that alien from the array
            3. Don't forget to also remove the alien from the pane
         */

        for(int i = 0; i < alienArray.length; i++){
            if(alienArray[i]== null){

            }
            else{
                if(alienArray[i].getColor() == Color.SKYBLUE){
                    alienArray[i].removeFromPane(alienPane);
                    alienArray[i] = null;
                    return;
                }
                else{

                }
            }

        }
    }

    /**
     * This is a helper method that we call in your code. Feel free to read through it but please
     * don't change anything!
     **/
    public void reset() {
        this.alienArray = new Alien[10];
        this.alienPane.getChildren().clear();
    }

}