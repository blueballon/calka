package org.blueballoon.calka.calkaswt;

import org.eclipse.swt.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.layout.*;
import org.blueballoon.calka.interfaces.*;
import org.blueballoon.calka.calkacore.InputLineModel;


public class SwtInputLineDisplay extends Composite implements ISingleSubscriber
{
    final private Label m_inputLineDisplay;

    public SwtInputLineDisplay(Composite parent, int style)
    {
        super(parent, style);

        // setup the layout
        RowLayout inputLineLayout = new RowLayout();
        this.setLayout(inputLineLayout);

        m_inputLineDisplay= new Label(this, SWT.BORDER);
        m_inputLineDisplay.setText("000 000 000");
    }

    public void updateFromPublisher(Object publisher)
    {
        if (publisher instanceof InputLineModel)
        {
            InputLineModel inputLineModel = (InputLineModel)publisher;
            String currDisplay = inputLineModel.getInputLineString();
            m_inputLineDisplay.setText(currDisplay);
        }
    }
}
