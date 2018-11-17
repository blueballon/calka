package org.blueballoon.calka;

import org.blueballoon.calka.uiwrapper.UiEvents;
import org.blueballoon.calka.calkacore.*;
import org.blueballoon.calka.interfaces.ISingleSubscriber;


// central controller calls for Calka, implemented as singelton
// the controller receives the events from the UI, applies the controller logic
// end, if needed applies actions to the model
// needs to kwon the model, does not need to know the views as the UI knows the
// controller due to its singelton character
public class CalkaController
{
    // for singelton: controller instance
    private static CalkaController m_instance;

    // the controller attributes
    // here, the controller _owns_ the model, he provides methods so that the views
    // can register themselves as Subscriber
    private static CalculatorCore m_calcCore;
    private static CalculatorStack m_calcStack;
    private static InputLineModel m_inputLine;


    // for singelton: hidden constructor
    private CalkaController () {}


    // for singelton: instance method
    public static CalkaController getInstance () {
        if (CalkaController.m_instance == null) {
            CalkaController.m_instance = new CalkaController();

            // setup the model
            CalkaController.m_calcStack = new CalculatorStack();
            CalkaController.m_inputLine = new InputLineModel();
            CalkaController.m_calcCore = new CalculatorCore(CalkaController.m_calcStack);
        }
        return CalkaController.m_instance;
    }


    // the inputline-view will be subscribed here
    public void registerInputLineSubscriber(ISingleSubscriber subscriber)
    {
        // check is obsolete as non-static method can only be called on instance
        if (CalkaController.m_instance != null)
        {
            CalkaController.m_inputLine.registerSubscriber(subscriber);
        }
    }


    // the stack-view will be subscribed here
    public void registerStackSubscriber(ISingleSubscriber subscriber)
    {
        if (CalkaController.m_instance != null)
        {
            CalkaController.m_calcStack.registerSubscriber(subscriber);
        }
    }


    // receives framework-neutral ui-events
    // intended to be called from ui-listeners
    public void receiveUiEvent(UiEvents event)
    {
        // debug System.out.println("The event was: " + event);
        // in future: maybe log the events here
        if (CalkaController.m_instance != null)
        {
            performLogic(event);
        }
    }


    // if not null, pushes the itemline to the stack
    // returns ok if inputLine was not null, false otherwise
    private boolean tryPushInputLineToStack()
    {
        CalculatorStackItem inputLineItem = CalkaController.m_inputLine.popInputLine();
        if (inputLineItem != null)
        {
            CalkaController.m_calcStack.push(inputLineItem);
            return(true);
        }
        return(false);
    }


    // the calka controller logic
    private void performLogic(UiEvents event)
    {
        // here has the controller logic to be implemented
        switch(event)
        {
            case DIGIT_0:
                CalkaController.m_inputLine.pushDigit('0');
                break;
            case DIGIT_1:
                CalkaController.m_inputLine.pushDigit('1');
                break;
            case DIGIT_2:
                CalkaController.m_inputLine.pushDigit('2');
                break;
            case DIGIT_3:
                CalkaController.m_inputLine.pushDigit('3');
                break;
            case DIGIT_4:
                CalkaController.m_inputLine.pushDigit('4');
                break;
            case DIGIT_5:
                CalkaController.m_inputLine.pushDigit('5');
                break;
            case DIGIT_6:
                CalkaController.m_inputLine.pushDigit('6');
                break;
            case DIGIT_7:
                CalkaController.m_inputLine.pushDigit('7');
                break;
            case DIGIT_8:
                CalkaController.m_inputLine.pushDigit('8');
                break;
            case DIGIT_9:
                CalkaController.m_inputLine.pushDigit('9');
                break;
            case DIGIT_COMMA:
                CalkaController.m_inputLine.pushDigit('.');
                break;
            case MODIFIER_CHANGESIGN:
                CalkaController.m_inputLine.invertSign();
                break;
            case OPERATION_PLUS:
                tryPushInputLineToStack();
                CalkaController.m_calcCore.Add();
                break;
            case OPERATION_MINUS:
                tryPushInputLineToStack();
                CalkaController.m_calcCore.Subtract();
                break;
            case OPERATION_MULTIPLY:
                tryPushInputLineToStack();
                CalkaController.m_calcCore.Multiply();
                break;
            case OPERATION_DIVIDE:
                tryPushInputLineToStack();
                CalkaController.m_calcCore.Divide();
                break;
            case STACK_ENTER:
                if (!tryPushInputLineToStack())
                {
                    CalkaController.m_calcStack.dup();
                }
                break;
            case STACK_SWAP:
                tryPushInputLineToStack();
                CalkaController.m_calcStack.swap();
                break;
            case STACK_DROP:
                tryPushInputLineToStack();
                CalkaController.m_calcStack.drop();
                break;
            case STACK_CLEAR:
                tryPushInputLineToStack();
                CalkaController.m_calcStack.clear();
                break;
        }
    }




}
