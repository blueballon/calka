package org.blueballoon.calka.calkaswt;

import org.eclipse.swt.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.layout.*;
import org.blueballoon.calka.calkaswt.SwtCalculatorButtons;
import org.blueballoon.calka.calkaswt.SwtInputLineDisplay;
import org.blueballoon.calka.CalkaController;

public class CalkaSwtApp
{
    public static void Runner( )
    {
        System.out.println( "Running Calka Java/SWT Version" );

        Display calkaDisplay = new Display();
        Shell calkaShell = new Shell(calkaDisplay);
        calkaShell.setSize(500,500);
        calkaShell.setText("CalKaSwt");
        calkaShell.setLayout(new RowLayout(SWT.VERTICAL));


        CalkaController controller = CalkaController.getInstance();

        // todo build the stack view and register it as subscriber at the CalkaController
        final SwtStackDisplay stackDisplay = new SwtStackDisplay(calkaShell, SWT.BORDER);
        controller.registerStackSubscriber(stackDisplay);

        // todo build the inputline view and register it as subscriber at the CalkaController
        final SwtInputLineDisplay inputLineDisplay = new SwtInputLineDisplay(calkaShell, SWT.BORDER);
        controller.registerInputLineSubscriber(inputLineDisplay);


        final SwtCalculatorButtons calculatorButtons = new SwtCalculatorButtons(calkaShell, SWT.BORDER);



        calkaShell.open();
        while(!calkaShell.isDisposed()) {
            if(!calkaDisplay.readAndDispatch()) {
                calkaDisplay.sleep();
            }
        }
        calkaDisplay.dispose();
    }
}
