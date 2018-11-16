package org.blueballoon.calka.calkacore;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Arrays;
import java.util.stream.Collectors;
import org.blueballoon.calka.interfaces.ISinglePublisher;
import org.blueballoon.calka.interfaces.ISingleSubscriber;


/**
 * InputLineModel with DigitStack
 * Beside the digit stack, it carries also information if the stach is treated as
 * positive or negative
 */
public class InputLineModel implements ISinglePublisher
{
    private Deque<Character> m_digitStack;
    private Boolean m_isNegative;
    private ISingleSubscriber m_subscriber;

    public InputLineModel()
    {
        m_digitStack = new ArrayDeque<Character>();
        m_isNegative = false;  // per default, the input line is positive
        m_subscriber = null;
    }


    // removes the "most right" digit from the digit stack (fifo)
    public void removeLastDigit( )
    {
        m_digitStack.removeLast();
        this.notifySubscriber();
    }


    // pushes the given character to the "most right" position of the digit stack (fifo)
    public void pushDigit(Character digit)
    {
        m_digitStack.addLast(digit);
        this.notifySubscriber();
    }


    // inverts the sign of the input line
    public void invertSign()
    {
        m_isNegative = !m_isNegative;
        this.notifySubscriber();
    }


    // clears the digit stack and resets the sign setting
    public void clear()
    {
        m_digitStack.clear();
        m_isNegative = false;
        this.notifySubscriber();
    }


    // returns a CalculatorStackItem-Representation of the InputLineModel
    // and clears the InputLineModel
    public CalculatorStackItem popInputLine()
    {
        String inputLineAsString=this.getInputLineString();
        Double inputLineValue = Double.valueOf(inputLineAsString);
        this.clear();
        this.notifySubscriber();
        return(new CalculatorStackItem(inputLineValue));
    }


    // set the inputLineModel to the conent of the given CalculatorStackItem
    // the former content of inputLineModel is cleared
    // in future, to be used to pop the lowest calcstack-item back to input line,
    // modify it and push it back to calcstack
    public void pushInputLine(CalculatorStackItem calculatorStackItem)
    {
        if (null != calculatorStackItem)
        {
            // throw away old content of inputLineModel
            this.clear();

            char[] itemAsCharArray = calculatorStackItem.getString().toCharArray();
            for (char currChar: itemAsCharArray)
            {
                m_digitStack.addLast(currChar);
            }
        }
        this.notifySubscriber();
    }


    // returns the String-Representation of InputLineModel
    public String getInputLineString()
    {
        // evtl future: wenn stack leer, dann "0" als String zurueckgeben
        Character [] inputLineChars = m_digitStack.toArray(new Character[0]);
        // from Stackoverflow: https://stackoverflow.com/a/36188933
        // requires Java8
        String inputLineString = Arrays.stream(inputLineChars).map(Object::toString).collect( Collectors.joining() );
        if (m_isNegative)
        {
            inputLineString = "-"+inputLineString;
        }
        return inputLineString;
    }

    // implementation of the SinglePublisher-Interface
    public void registerSubscriber(ISingleSubscriber subscriber)
    {
        m_subscriber = subscriber;
    }

    public void deleteSubscriber()
    {
        m_subscriber = null;
    }

    public void notifySubscriber()
    {
        if (null != m_subscriber)
        {
            m_subscriber.updateFromPublisher(this);
        }
    }
}
