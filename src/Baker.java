import cs15.labs.cupcakeSupport.CS15Cupcake;
public class Baker {
    private int num;
    public Baker(){
        this.num = 0;
    }

    public CS15Cupcake chocolate(){
        this.num += 1;
        CS15Cupcake cup = new CS15Cupcake();
        cup.addChocolateFrosting();
        return cup;
    }
    public CS15Cupcake vanilla(){
        this.num += 1;
        CS15Cupcake cup = new CS15Cupcake();
        cup.addVanillaFrosting();
        return cup;
    }

    public CS15Cupcake strawberry(){
        this.num +=1;
        CS15Cupcake cup = new CS15Cupcake();
        cup.addStrawberryFrosting();
        return cup;
    }

    public String workUpdate(){
        return "The baker has made "+ this.num + " cupcakes";
    }
}
