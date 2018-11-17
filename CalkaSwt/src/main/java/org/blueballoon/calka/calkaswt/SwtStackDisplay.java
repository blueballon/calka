package org.blueballoon.calka.calkaswt;

import org.eclipse.swt.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.layout.*;
import java.util.ArrayList;
import org.blueballoon.calka.interfaces.*;
import org.blueballoon.calka.calkacore.InputLineModel;
import org.blueballoon.calka.calkacore.CalculatorStack;

public class SwtStackDisplay extends Composite implements ISingleSubscriber
{
    final private Label m_stackLine1Display;
    final private Label m_stackLine2Display;
    final private Label m_stackLine3Display;
    final private Label m_stackLine4Display;

    public SwtStackDisplay(Composite parent, int style)
    {
        super(parent, style);

        // setup the layout
        RowLayout inputLineLayout = new RowLayout(SWT.VERTICAL);
        this.setLayout(inputLineLayout);

        m_stackLine4Display= new Label(this, SWT.NULL);
        m_stackLine4Display.setText("--- --- ---");
        m_stackLine3Display= new Label(this, SWT.NULL);
        m_stackLine3Display.setText("--- --- ---");
        m_stackLine2Display= new Label(this, SWT.NULL);
        m_stackLine2Display.setText("--- --- ---");
        m_stackLine1Display= new Label(this, SWT.NULL);
        m_stackLine1Display.setText("--- --- ---");
    }

    public void updateFromPublisher(Object publisher)
    {
        if (publisher instanceof CalculatorStack)
        {
            CalculatorStack calcStack = (CalculatorStack)publisher;
            ArrayList<String> currStackContent =  calcStack.getStackContent();
            int currStackSize = currStackContent.size();

            String[] displayArray = {"---","---","---","---"};
            int displayArrayIndex = 0;
            while (displayArrayIndex < currStackSize)
            {
                displayArray[displayArrayIndex]=currStackContent.get(displayArrayIndex);
                displayArrayIndex++;
            }

            m_stackLine1Display.setText(displayArray[0]);
            m_stackLine2Display.setText(displayArray[1]);
            m_stackLine3Display.setText(displayArray[2]);
            m_stackLine4Display.setText(displayArray[3]);
        }
    }
}
