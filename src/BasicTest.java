
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class BasicTest {

    /**
     * Example of testing 1 + 1 = 2
     */
    @Test
    public void testOnePlusOne() {
        assertTrue(1 ==1);

    }

    /**
     * Broken test
     * TODO: fix this test
     */
   @Test
    public void testTwoTimesThree() {
        assertTrue(3 * 2 == 6);
    }

    /**
     * TODO: Write a test that tests the output of 6 divided by 2
     * TODO: Follow the test method format above
     */
    @Test
    public void testSixDividedByTwo(){
        assertTrue(6/2 == 3);
    }

}