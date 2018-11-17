package org.blueballoon.calka;

import org.eclipse.swt.*;
//import org.eclipse.swt.custom.*;
//import org.eclipse.swt.graphics.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.layout.*;
import org.blueballoon.calka.calkaswt.SwtCalculatorButtons;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        System.out.println( "Starting CalKa - the CALculator KAta (Java SWT Version)" );

        Display calkaDisplay = new Display();
        Shell calkaShell = new Shell(calkaDisplay);
        calkaShell.setSize(500,500);
        calkaShell.setText("CalKaSwt");
        calkaShell.setLayout(new RowLayout());

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
