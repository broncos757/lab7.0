
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class AlienArrayCreator2D {

    private Pane alienPane;
    private Alien[][] alienArray2D; //here's the declaration of the array variable!
    private Alien w;

    private Boolean rowMajor = true;

    public AlienArrayCreator2D(Pane alienPane) {
        this.alienPane = alienPane;

        //TODO: Initialize the 2D-array here
        alienArray2D = new Alien[7][5];
    }

    public void generateAliens() {
        this.reset(); //don't worry about this! it's just to make sure you don't double generate

        /* TODO:
            1. Loop to each array in your array of arrays
            2. Loop through each index in each array in your array of arrays
                (hint: it's a double for-loop!)
            3. At each internal loop, create an Alien object
            4. Alien color should be BLUE if the major index is even, otherwise GREEN
            3. Store the Alien object in the array at that index pair
            4. Don't forget to add the Alien to the pane! - Use the helper method
         */

        for(int i = 0; i < alienArray2D.length; i++){
            for(int c = 0; c < alienArray2D[0].length; c++){
               // Alien a = new Alien(Color.BLUE); - why does it give me an error here!?
                if(c%2==0){
                    w = new Alien(Color.BLUE);
                    alienArray2D[i][c] = w;
                    w.addToPane(alienPane);

                }
                else{
                    w = new Alien(Color.GREEN);
                    alienArray2D[i][c] = w;
                    w.addToPane(alienPane);
                }
            }
        }
    }

    public void lineUpAliens() {
        /* TODO:
            1. Loop through your 2d array (double for-loop again!)
            2. For every alien, make the x and y positions dependent on the alien's location in the array
                Remember that in a 2D array there is a pair of indices that correspond to an alien's location
                If my alien is at indices (4, 2) (alienArray2D[4][2]) maybe I want my alien to exist
                at coordinates (40, 20)
            3. Set the y position based on the row (major index)
            4. Set the x position based on the column (minor index)

         */
        for(int i = 0; i < alienArray2D.length; i++){
            for(int c = 0; c < alienArray2D[0].length; c++){
                if(i %2 ==0){
                    alienArray2D[i][c].setColor(Color.SKYBLUE);
                }
                else{
                    alienArray2D[i][c].setColor(Color.LIGHTGREEN);
                }
                alienArray2D[i][c].setXPos(50 + c *60);
                alienArray2D[i][c].setYPos(50+ i *60);
                }
            }
        rowMajor = true;
        }





    public void rowToCol() {
        /* TODO:
            After the lineup method, your array should be organized in a row-major fashion
               this means the 2d array is organized as a stack of row arrays, which we want
               to change to column arrays.
               ____________          |  |  |
               ____________   --->   |  |  |
               ____________          |  |  |
            1. Loop through your alien array
            2. Set the y position based on the column (major index)
            3. Set the x position based on the row (minor index)
         */
        for(int i = 0; i < alienArray2D.length; i++){
            for(int c = 0; c < alienArray2D[0].length; c++){
                alienArray2D[i][c].setXPos(50 + i *60);
                alienArray2D[i][c].setYPos(50+ c *60);
            }
        }
        rowMajor = false;

    }

    public boolean checkEvilAliens(Alien[] aliens) {
        /* TODO:
               You want to check whether the given 1-D array of aliens contains at least 3 evil aliens. If
               it contains at least 3 evil aliens then the whole row is evil and you want to return true
               and false otherwise.
               1. Loop through the given 1-D array of aliens and keep track of how many evil aliens you have
               2. Return true when you see that the number of evil aliens is 3
               3. If the for-loop finishes and it did not count 3 evil aliens within the loop then return
                   false
        */
        int counter = 0;
        for(int i = 0; i < aliens.length; i++) {
            if (aliens[i].getIsEvil()) {
                counter++;
            }
            if (counter >= 3) {
                return true;
            }
        }
            return false;
        }



    public void revealEvil() {
         /* TODO:
               You want to check each of the rows (or columns if you have them lined up in column-major) and
               determine whether it is an evil row which is based on the boolean returned by the
               checkEvilAliens method. If a row (or column) is determined to be evil then set the color
               of all aliens in that row to be red.
               1. Loop through all the rows (or columns if column-major) of alien  array
               2. Check if the row (or column) is evil
               3. If the row is evil, change the color of all aliens to be red
        */
            if(rowMajor) {
                System.out.println("rowMajor");
                for (int i = 0; i < alienArray2D.length; i++) {
                    if (checkEvilAliens(alienArray2D[i])) {
                        for (int d = 0; d < alienArray2D[0].length; d++) {
                            alienArray2D[i][d].setColor(Color.RED);
                        }

                    }
                }
            }
            else{
                System.out.println("colMajor");
                for (int i = 0; i < alienArray2D[0].length; i++){
                    Alien[] arr = new Alien[alienArray2D.length];

                    for(int c = 0; c < alienArray2D.length; c++){
                        arr[c] = alienArray2D[c][i];
                    }
                    if(checkEvilAliens(arr)){
                        for(int e = 0; e < alienArray2D.length; e++){
                            alienArray2D[e][i].setColor(Color.RED);
                        }
                    }
                }
            }
        }




    /**
     * These are helper methods that we call in your code. Feel free to read through them but please
     * don't change anything!
     **/

    public void reset() {
        this.alienArray2D = new Alien[7][5];
        this.alienPane.getChildren().clear();
    }
}
