
import cs15.labs.cupcakeSupport.CS15Cupcake;
import cs15.labs.cupcakeSupport.CS15Decorator;
import cs15.labs.cupcakeSupport.CupcakeShopSupport;

/**
 * This is our top-level class that represents a CupcakeShop!
 */
public class CupcakeShop extends CupcakeShopSupport {

    // this declares our instance variable "decorator"
    private CS15Decorator decorator;
    private Baker myBaker;

    /**
     * This is the constructor of the CupcakeShop class. You should initialize all your
     * instance variables here, and be sure to open shop!
     */
    public CupcakeShop() {
        super();

        // this initializes our instance variable "decorator"
        this.decorator = new CS15Decorator();
        this.myBaker = new Baker();
        this.openShop();
        System.out.println("testing");

    }

    /**
     * This method is called automatically when the user clicks "Order 1". Check out
     * the Javadocs for more information.
     */
    @Override
    public void order1() {
        CS15Cupcake t = this.myBaker.chocolate();
        displayPrice(t);
        System.out.println(this.myBaker.workUpdate());
    }

    /**
     * This method is called automatically when the user clicks "Order 2". Check out
     * the Javadocs for more information.
     */
    @Override
    public void order2() {
        CS15Cupcake t = this.myBaker.vanilla();
        this.decorator.addSprinkles(t);
        displayPrice(t);
        System.out.println(this.myBaker.workUpdate());
    }

    /**
     * This method is called automatically when the user clicks "Order 3". Check out
     * the Javadocs for more information.
     */
    @Override
    public void order3() {
        CS15Cupcake r = this.myBaker.vanilla();
        this.decorator.addCherry(r);
        this.displayPrice(r);
        System.out.println(this.myBaker.workUpdate());
    }

    /**
     * This method is called automatically when the user clicks "Order 4". Check out
     * the Javadocs for more information.
     */
    @Override
    public void order4() {
        CS15Cupcake r = this.myBaker.strawberry();
        this.decorator.addSprinkles(r);
        this.decorator.addCherry(r);
        this.displayPrice(r);
        System.out.println(this.myBaker.workUpdate());
    }

    /**
     * This method is called automatically when the user clicks "Order 5". Check out
     * the Javadocs for more information.
     */
    @Override
    public void order5() {
        CS15Cupcake r = this.myBaker.strawberry();
        this.decorator.addSprinkles(r);
        this.decorator.addCandle(r);
        this.displayPrice(r);
        this.displayPrice(r);
        System.out.println(this.myBaker.workUpdate());
    }

    //new code

}