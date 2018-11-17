package org.blueballoon.calka.calkacore;

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
/*
    zukuenftig: string-repraesentation mit vorgegebener Formatierung liefern
    entweder durch eigene oder durch ueberladene Methode
    (see: nuberformat, NumberNotation in ideas)

    public String getStringFormatted(NumberFormat numberFormat)
    {
        // see https://stackoverflow.com/a/4885377
        // https://en.wikipedia.org/wiki/Scientific_notation
        return(m_itemData.toString());
    }
    */
}
