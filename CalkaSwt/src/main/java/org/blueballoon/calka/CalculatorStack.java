package org.blueballoon.calka;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Stack for Calculator
 *
 */
public class CalculatorStack
{
    Deque<CalculatorStackItem> m_stack;

    public CalculatorStack()
    {
        m_stack = new ArrayDeque<CalculatorStackItem>();
    }

    // pops the "lowest" item from the stack (fifo)
    public CalculatorStackItem pop( )
    {
        // use pollFirst instead of pop as we want to return an null object in case of an empty stack
        return( m_stack.pollFirst() );
    }

    // pushes the given value to the lowest position of the stack (fifo)
    public void push(CalculatorStackItem item)
    {
        m_stack.addFirst(item);
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
    }

    // removes the "lowest" item from the stack
    public void drop()
    {
        if (!m_stack.isEmpty())
        {
             m_stack.removeFirst();
        }
    }

    // clears the whole stack
    public void clear()
    {
        m_stack.clear();
    }

}
