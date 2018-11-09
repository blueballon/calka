package org.blueballoon.calka;

/**
 * StackItem for Calculator
 *
 */
public class CalculatorStackItem
{
    // first variant: use (Java)Double as internal representation of calculator CalculatorStackItemTest
    Double m_itemData;

    public CalculatorStackItem(Double itemData)
    {
       m_itemData = itemData;
    }

    public Double getDouble()
    {
        return(m_itemData);
    }

    public String getString()
    {
        return(m_itemData.toString());
    }


}