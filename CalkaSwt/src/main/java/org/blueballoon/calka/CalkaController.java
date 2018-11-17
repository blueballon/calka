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
        System.out.println("The event was: " + event);
        // in future: maybe log the events here
        if (CalkaController.m_instance != null)
        {
            performLogic(event);
        }
    }


    // the calka controller logic
    private void performLogic(UiEvents event)
    {
        // here has the controller logic to be implemented
        switch(event)
        {
            case DIGIT_0:
            case DIGIT_1:
            case DIGIT_2:
            case DIGIT_3:
            case DIGIT_4:
            case DIGIT_5:
            case DIGIT_6:
            case DIGIT_7:
            case DIGIT_8:
            case DIGIT_9:
            case DIGIT_COMMA:
            case MODIFIER_CHANGESIGN:
            case OPERATION_PLUS:
            case OPERATION_MINUS:
            case OPERATION_MULTIPLY:
            case OPERATION_DIVIDE:
            case STACK_ENTER:
            case STACK_SWAP:
            case STACK_DROP:
            case STACK_CLEAR:
        }
    }




}
