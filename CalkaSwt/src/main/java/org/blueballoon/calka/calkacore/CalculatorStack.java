package org.blueballoon.calka.calkacore;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.ArrayList;
import org.blueballoon.calka.interfaces.ISinglePublisher;
import org.blueballoon.calka.interfaces.ISingleSubscriber;
/**
 * Stack for Calculator
 *
 */
public class CalculatorStack implements ISinglePublisher
{
    private Deque<CalculatorStackItem> m_stack;
    private ISingleSubscriber m_subscriber;

    public CalculatorStack()
    {
        m_stack = new ArrayDeque<CalculatorStackItem>();
        m_subscriber = null;
    }

    // pops the "lowest" item from the stack (fifo)
    public CalculatorStackItem pop( )
    {
        // use pollFirst instead of pop as we want to return an null object in case of an empty stack
        CalculatorStackItem item = m_stack.pollFirst();
        this.notifySubscriber();
        return(item);
    }

    // pushes the given value to the lowest position of the stack (fifo)
    public void push(CalculatorStackItem item)
    {
        m_stack.addFirst(item);
        this.notifySubscriber();
    }

    // swaps the 2 lowest stack entries (slot 1 and slot 2)
    // if less then 2 items are on stack, no action is performed
    public void swap()
    {
        if (m_stack.size() >= 2)
        {
            CalculatorStackItem item1=this.pop();
            CalculatorStackItem item2=this.pop();
            // now push the two items in reverse order to swap them on the stack
            this.push(item1);
            this.push(item2);
        }
        this.notifySubscriber();
    }

    // removes the "lowest" item from the stack
    public void drop()
    {
        if (!m_stack.isEmpty())
        {
             m_stack.removeFirst();
        }
        this.notifySubscriber();
    }

    // clears the whole stack
    public void clear()
    {
        m_stack.clear();
        this.notifySubscriber();
    }

    // returns the content of the stack as String-ArrayList
    // to be used for "display"-purposes
    // note: the first pushed item has the highest index (size-1),
    // the last pushed item has the lowest index 0
    public ArrayList<String> getStackContent()
    {
        ArrayList<String> stackContent = new ArrayList<String>();

        for (CalculatorStackItem currItem : m_stack)
        {
            stackContent.add(currItem.getString());
        }

        // debug only
        /*for (String s : stackContent)
        {
            System.out.println(s);
        }*/

        return stackContent;
    }

    // returns the number of items on the stack
    // especially required to check the stack condition before performing a mathematical operation
    public Integer size()
    {
        return m_stack.size();
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
