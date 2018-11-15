package org.blueballoon.calka;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

//import java.util.ArrayList;

/**
 * Unit test for simple App.
 */
public class InputLineModelTest
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public InputLineModelTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( InputLineModelTest.class );
    }


    public void testInputLineModel1()
    {
        InputLineModel inputLine = new InputLineModel();
        inputLine.pushDigit('1');
        inputLine.pushDigit('2');
        inputLine.pushDigit('3');
        inputLine.pushDigit('4');
        inputLine.removeLastDigit();
        assertEquals("123",inputLine.getInputLineString() );
        assertEquals(123.0,inputLine.popInputLine().getDouble());
        assertEquals("",inputLine.getInputLineString() );
    }


    public void testInputLineModel2()
    {
        InputLineModel inputLine = new InputLineModel();
        inputLine.pushDigit('1');
        inputLine.pushDigit('2');
        inputLine.pushDigit('.');
        inputLine.pushDigit('3');
        assertEquals("12.3",inputLine.getInputLineString() );
        assertEquals(12.3,inputLine.popInputLine().getDouble());
    }

    public void testInputLineModel3()
    {
        InputLineModel inputLine = new InputLineModel();
        inputLine.pushDigit('1');
        inputLine.pushDigit('2');
        inputLine.pushDigit('.');
        inputLine.pushDigit('3');
        inputLine.pushDigit('4');
        inputLine.pushDigit('5');
        inputLine.invertSign();
        inputLine.removeLastDigit();
        assertEquals("-12.34",inputLine.getInputLineString() );
        assertEquals(-12.34,inputLine.popInputLine().getDouble());
    }
}
