package org.blueballoon.calka;


/**
 * The core "business logic" for the Calculator
 * Provides all mathematical operations that are applied on the stack
 * CalculatorCore has its stack as attribute
 */
public class CalculatorCore
{
    private CalculatorStack m_stack;

    public CalculatorCore(CalculatorStack stack)
    {
        m_stack = stack;
    }

    // adds the two lowest entries of the stack and pushes the result back to stack
    // if less the two items are on the stack, no action is performed
    public void Add()
    {
        if (m_stack.size() >= 2)
        {
            CalculatorStackItem summand1 = m_stack.pop();
            CalculatorStackItem summand2 = m_stack.pop();
            CalculatorStackItem result = new CalculatorStackItem(summand1.getDouble() + summand2.getDouble());
            m_stack.push(result);
        }
    }

    // subtracts the lowest item from the second-lowest item of the stack and pushes the result back to stack
    // if less the two items are on the stack, no action is performed
    public void Subtract()
    {
        if (m_stack.size() >= 2)
        {
            CalculatorStackItem subtrahend = m_stack.pop();
            CalculatorStackItem minuend = m_stack.pop();
            CalculatorStackItem result = new CalculatorStackItem(minuend.getDouble() - subtrahend.getDouble());
            m_stack.push(result);
        }
    }

    // multiplies the two lowest items of the stack and pushes the result back to stack
    // if less the two items are on the stack, no action is performed
    public void Multiply()
    {
        if (m_stack.size() >= 2)
        {
            CalculatorStackItem factor1 = m_stack.pop();
            CalculatorStackItem factor2 = m_stack.pop();
            CalculatorStackItem result = new CalculatorStackItem(factor1.getDouble() * factor2.getDouble());
            m_stack.push(result);
        }
    }

    // divides  the second-lowest thru the lowest item of the stack and pushes the result back to stack
    // if less the two items are on the stack, no action is performed
    public void Divide()
    {
        if (m_stack.size() >= 2)
        {
            CalculatorStackItem divisor = m_stack.pop();
            CalculatorStackItem dividend = m_stack.pop();
            CalculatorStackItem result = new CalculatorStackItem(dividend.getDouble() / divisor.getDouble());
            m_stack.push(result);
        }
    }

    // changes the sing of the lowest item of the stack and pushes the result back to stack
    // if less the one item is on the stack, no action is performed
    public void ChangeSign()
    {
        if (m_stack.size() >= 1)
        {
            CalculatorStackItem item = m_stack.pop();
            CalculatorStackItem result = new CalculatorStackItem(0 - item.getDouble());
            m_stack.push(result);
        }
    }

}
