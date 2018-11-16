package org.blueballoon.calka.calkacore;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * Unit test for simple App.
 */
public class CalculatorCoreTest
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public CalculatorCoreTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( CalculatorCoreTest.class );
    }


    public void testCalculatorCore1()
    {
        CalculatorStackItem stackItem1 = new CalculatorStackItem(1.0);
        CalculatorStackItem stackItem2 = new CalculatorStackItem(2.0);
        CalculatorStack stack = new CalculatorStack();
        CalculatorCore calculator = new CalculatorCore(stack);

        stack.push(stackItem1);
        stack.push(stackItem2);
        calculator.Add();
        assertEquals(3.0, stack.pop().getDouble());

        stack.push(stackItem2);
        stack.push(stackItem2);
        calculator.Multiply();
        assertEquals(4.0, stack.pop().getDouble());

        stack.push(stackItem1);
        stack.push(stackItem2);
        calculator.Subtract();
        assertEquals(-1.0, stack.pop().getDouble());

        stack.push(stackItem1);
        stack.push(stackItem2);
        calculator.Divide();
        assertEquals(0.5, stack.pop().getDouble());
    }

    public void testCalculatorCore2()
    {
        CalculatorStackItem stackItem1 = new CalculatorStackItem(1.0);
        CalculatorStackItem stackItem2 = new CalculatorStackItem(-123.456);

        CalculatorStack stack = new CalculatorStack();
        CalculatorCore calculator = new CalculatorCore(stack);

        stack.push(stackItem1);
        calculator.ChangeSign();
        assertEquals(-1.0, stack.pop().getDouble());

        stack.push(stackItem2);
        calculator.ChangeSign();
        assertEquals(123.456, stack.pop().getDouble());
    }

    public void testCalculatorCore3()
    {
        CalculatorStackItem stackItem1 = new CalculatorStackItem(1.0);
        CalculatorStack stack = new CalculatorStack();
        CalculatorCore calculator = new CalculatorCore(stack);

        stack.push(stackItem1);
        calculator.Add();
        assertEquals(1.0, stack.pop().getDouble());

        stack.push(stackItem1);
        calculator.Multiply();
        assertEquals(1.0, stack.pop().getDouble());

        stack.push(stackItem1);
        calculator.Subtract();
        assertEquals(1.0, stack.pop().getDouble());

        stack.push(stackItem1);
        calculator.Divide();
        assertEquals(1.0, stack.pop().getDouble());
    }

    public void testCalculatorCore4()
    {
        CalculatorStackItem stackItem1 = new CalculatorStackItem(1.0);
        CalculatorStackItem stackItem2 = new CalculatorStackItem(0.0);
        CalculatorStack stack = new CalculatorStack();
        CalculatorCore calculator = new CalculatorCore(stack);

        stack.push(stackItem1);
        stack.push(stackItem2);
        calculator.Add();
        assertEquals(1.0, stack.pop().getDouble());

        stack.push(stackItem1);
        stack.push(stackItem2);
        calculator.Subtract();
        assertEquals(1.0, stack.pop().getDouble());

        stack.push(stackItem1);
        stack.push(stackItem2);
        calculator.Multiply();
        assertEquals(0.0, stack.pop().getDouble());

        stack.push(stackItem1);
        stack.push(stackItem2);
        calculator.Divide();
        assertTrue(stack.pop().getDouble().isInfinite());

        stack.push(stackItem2);
        stack.push(stackItem1);
        calculator.Divide();
        assertEquals(0.0, stack.pop().getDouble());
    }

}
