package org.blueballoon.calka.calkaswt;

import org.eclipse.swt.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.layout.*;
// import org.eclipse.swt.events.*;
// import org.eclipse.swt.custom.*;
// import org.eclipse.swt.graphics.*;
import org.blueballoon.calka.uiwrapper.UiEvents;
// import org.blueballoon.calka.CalkaController;

public class SwtCalculatorButtons extends Composite
{
    // buttons for number creation
    final private Button m_buttonDigit0;
    final private Button m_buttonDigit1;
    final private Button m_buttonDigit2;
    final private Button m_buttonDigit3;
    final private Button m_buttonDigit4;
    final private Button m_buttonDigit5;
    final private Button m_buttonDigit6;
    final private Button m_buttonDigit7;
    final private Button m_buttonDigit8;
    final private Button m_buttonDigit9;
    final private Button m_buttonComma;
    final private Button m_buttonChangeSign;

    // buttons for mathematical operations
    final private Button m_buttonPlus;
    final private Button m_buttonMinus;
    final private Button m_buttonMultiply;
    final private Button m_buttonDivide;

    // buttons for stack manipulation
    final private Button m_buttonEnter;
    final private Button m_buttonDrop;
    final private Button m_buttonClear;
    final private Button m_buttonSwap;


    public SwtCalculatorButtons(Composite parent, int style)
    {
        super(parent, style);

        // setup the layout
        final Integer numGridCols = 4;
        final boolean identicalColumnWidth = true;
        GridLayout buttonGrid = new GridLayout(numGridCols, identicalColumnWidth);
        this.setLayout(buttonGrid);

        // place and fill the button row 1
        m_buttonDigit1 = new Button(this, SWT.PUSH);
        m_buttonDigit1.setText("1");
        m_buttonDigit1.addSelectionListener(new CalkaSwtSelectionAdapter(UiEvents.DIGIT_1));
        m_buttonDigit2 = new Button(this, SWT.PUSH);
        m_buttonDigit2.setText("2");
        m_buttonDigit2.addSelectionListener(new CalkaSwtSelectionAdapter(UiEvents.DIGIT_2));
        m_buttonDigit3 = new Button(this, SWT.PUSH);
        m_buttonDigit3.setText("3");
        m_buttonDigit3.addSelectionListener(new CalkaSwtSelectionAdapter(UiEvents.DIGIT_3));
        m_buttonPlus = new Button(this, SWT.PUSH);
        m_buttonPlus.setText("+");
        m_buttonPlus.addSelectionListener(new CalkaSwtSelectionAdapter(UiEvents.OPERATION_PLUS));

        // place and fill the button row 2
        m_buttonDigit4 = new Button(this, SWT.PUSH);
        m_buttonDigit4.setText("4");
        m_buttonDigit4.addSelectionListener(new CalkaSwtSelectionAdapter(UiEvents.DIGIT_4));
        m_buttonDigit5 = new Button(this, SWT.PUSH);
        m_buttonDigit5.setText("5");
        m_buttonDigit5.addSelectionListener(new CalkaSwtSelectionAdapter(UiEvents.DIGIT_5));
        m_buttonDigit6 = new Button(this, SWT.PUSH);
        m_buttonDigit6.setText("6");
        m_buttonDigit6.addSelectionListener(new CalkaSwtSelectionAdapter(UiEvents.DIGIT_6));
        m_buttonMinus = new Button(this, SWT.PUSH);
        m_buttonMinus.setText("-");
        m_buttonMinus.addSelectionListener(new CalkaSwtSelectionAdapter(UiEvents.OPERATION_MINUS));

        // place and fill the button row 3
        m_buttonDigit7 = new Button(this, SWT.PUSH);
        m_buttonDigit7.setText("7");
        m_buttonDigit7.addSelectionListener(new CalkaSwtSelectionAdapter(UiEvents.DIGIT_7));
        m_buttonDigit8 = new Button(this, SWT.PUSH);
        m_buttonDigit8.setText("8");
        m_buttonDigit8.addSelectionListener(new CalkaSwtSelectionAdapter(UiEvents.DIGIT_8));
        m_buttonDigit9 = new Button(this, SWT.PUSH);
        m_buttonDigit9.setText("9");
        m_buttonDigit9.addSelectionListener(new CalkaSwtSelectionAdapter(UiEvents.DIGIT_9));
        m_buttonMultiply = new Button(this, SWT.PUSH);
        m_buttonMultiply.setText("x");
        m_buttonMultiply.addSelectionListener(new CalkaSwtSelectionAdapter(UiEvents.OPERATION_MULTIPLY));

        // place and fill the button row 4
        m_buttonDigit0 = new Button(this, SWT.PUSH);
        m_buttonDigit0.setText("0");
        m_buttonDigit0.addSelectionListener(new CalkaSwtSelectionAdapter(UiEvents.DIGIT_0));
        m_buttonComma = new Button(this, SWT.PUSH);
        m_buttonComma.setText(".");
        m_buttonComma.addSelectionListener(new CalkaSwtSelectionAdapter(UiEvents.DIGIT_COMMA));
        m_buttonChangeSign = new Button(this, SWT.PUSH);
        m_buttonChangeSign.setText("S");
        m_buttonChangeSign.addSelectionListener(new CalkaSwtSelectionAdapter(UiEvents.MODIFIER_CHANGESIGN));
        m_buttonDivide = new Button(this, SWT.PUSH);
        m_buttonDivide.setText("/");
        m_buttonDivide.addSelectionListener(new CalkaSwtSelectionAdapter(UiEvents.OPERATION_DIVIDE));

        // place and fill the button row 4
        m_buttonEnter= new Button(this, SWT.PUSH);
        m_buttonEnter.setText("E");
        m_buttonEnter.addSelectionListener(new CalkaSwtSelectionAdapter(UiEvents.STACK_ENTER));
        m_buttonSwap = new Button(this, SWT.PUSH);
        m_buttonSwap.setText("W");
        m_buttonSwap.addSelectionListener(new CalkaSwtSelectionAdapter(UiEvents.STACK_SWAP));
        m_buttonDrop = new Button(this, SWT.PUSH);
        m_buttonDrop.setText("D");
        m_buttonDrop.addSelectionListener(new CalkaSwtSelectionAdapter(UiEvents.STACK_DROP));
        m_buttonClear = new Button(this, SWT.PUSH);
        m_buttonClear.setText("C");
        m_buttonClear.addSelectionListener(new CalkaSwtSelectionAdapter(UiEvents.STACK_CLEAR));
    }
}
