package org.blueballoon.calka;

//import org.eclipse.swt.*;
//import org.eclipse.swt.custom.*;
//import org.eclipse.swt.graphics.*;
import org.eclipse.swt.widgets.*;
//import org.eclipse.swt.layout.*;
/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        System.out.println( "Starting CalKa - the CALculator KAta (Java SWT Version)" );

        Display d = new Display();
        Shell s = new Shell(d);
        s.setSize(500,500);
        s.open();
        while(!s.isDisposed()) {
            if(!d.readAndDispatch()) {
                d.sleep();
            }
        }
        d.dispose();
    }
}
