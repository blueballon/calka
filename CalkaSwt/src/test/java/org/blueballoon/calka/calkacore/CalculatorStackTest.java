package org.blueballoon.calka.calkacore;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.ArrayList;

/**
 * Unit test for simple App.
 */
public class CalculatorStackTest
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public CalculatorStackTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( CalculatorStackTest.class );
    }


    public void testCalculatorStack1()
    {
        CalculatorStackItem stackItem1 = new CalculatorStackItem(37.0);
        CalculatorStack stack1 = new CalculatorStack();

        stack1.push(stackItem1);
        assertEquals(37.0, stack1.pop().getDouble());
        assertEquals(null,stack1.pop());    // a null object is returned when popping an empty stack
        try {
            stack1.pop().getDouble();
            assertTrue(false);              // this line must not reached, an exception has to be thrown before
        } catch (Exception e) {
            System.out.println("Remark - expected exception:" + e.toString());
            assertTrue(true);               // we expect that we caught a null pointer exception
        }

    }


    public void testCalculatorStack2()
    {
        CalculatorStackItem stackItem1 = new CalculatorStackItem(37.0);
        CalculatorStackItem stackItem2 = new CalculatorStackItem(-123.456);
        CalculatorStackItem stackItem3 = new CalculatorStackItem(45.67e2);

        CalculatorStack stack1 = new CalculatorStack();

        stack1.push(stackItem1);
        stack1.push(stackItem2);
        stack1.push(stackItem3);

        assertEquals(45.67e2, stack1.pop().getDouble());
        assertEquals(-123.456, stack1.pop().getDouble());
        assertEquals(37.0, stack1.pop().getDouble());
    }


    public void testCalculatorStack3()
    {
        CalculatorStackItem stackItem1 = new CalculatorStackItem(1.0);
        CalculatorStackItem stackItem2 = new CalculatorStackItem(2.0);
        CalculatorStackItem stackItem3 = new CalculatorStackItem(3.0);

        CalculatorStack stack1 = new CalculatorStack();

        stack1.push(stackItem1);
        stack1.push(stackItem2);
        stack1.push(stackItem3);

        stack1.swap();

        assertEquals(2.0, stack1.pop().getDouble());
        assertEquals(3.0, stack1.pop().getDouble());
        assertEquals(1.0, stack1.pop().getDouble());
    }


    public void testCalculatorStack4()
    {
        CalculatorStackItem stackItem1 = new CalculatorStackItem(1.0);
        CalculatorStackItem stackItem2 = new CalculatorStackItem(2.0);
        CalculatorStackItem stackItem3 = new CalculatorStackItem(3.0);

        CalculatorStack stack1 = new CalculatorStack();

        stack1.push(stackItem1);
        stack1.push(stackItem2);
        stack1.push(stackItem3);

        stack1.drop();

        assertEquals(2.0, stack1.pop().getDouble());
        assertEquals(1.0, stack1.pop().getDouble());
        assertEquals(null, stack1.pop());

        stack1.push(stackItem1);
        stack1.push(stackItem2);
        stack1.push(stackItem3);

        stack1.getStackContent();

        stack1.clear();
        assertEquals(null, stack1.pop());
    }


    public void testCalculatorStack5()
    {
        CalculatorStackItem stackItem1 = new CalculatorStackItem(1.0);
        CalculatorStackItem stackItem2 = new CalculatorStackItem(2.0);
        CalculatorStackItem stackItem3 = new CalculatorStackItem(3.0);

        CalculatorStack stack1 = new CalculatorStack();

        stack1.push(stackItem1);
        stack1.push(stackItem2);
        stack1.push(stackItem3);

        ArrayList<String> stackContent = stack1.getStackContent();
        assertEquals(3, stackContent.size());
        assertEquals("3.0", stackContent.get(0));
        assertEquals("2.0", stackContent.get(1));
        assertEquals("1.0", stackContent.get(2));
    }

}
