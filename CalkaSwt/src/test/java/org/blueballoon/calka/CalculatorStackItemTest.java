package org.blueballoon.calka;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
// import static junit.Assert.assertEquals;
/**
 * Unit test for simple App.
 */
public class CalculatorStackItemTest
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public CalculatorStackItemTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( CalculatorStackItemTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testCalculatorStackItem()
    {
        CalculatorStackItem stackItem = new CalculatorStackItem(37.0);
        assertEquals(37.0, stackItem.getDouble());
        assertEquals("37.0", stackItem.getString());

        CalculatorStackItem stackItem2 = new CalculatorStackItem(-123.456);
        assertEquals(-123.456, stackItem2.getDouble());
        assertEquals("-123.456", stackItem2.getString());

        CalculatorStackItem stackItem3 = new CalculatorStackItem(123.456e3);
        assertEquals(123456.0, stackItem3.getDouble());
        assertEquals("123456.0", stackItem3.getString());


    }

}
// public class CalculatorStackItemTest
// {
//      @Test
//      public void testCalculatorStackItem()
//      {
//          CalculatorStackItem stackItem = new CalculatorStackItem(37.0);
//          assertEquals(37.0, stackItem.getDouble());
//      }
// }
