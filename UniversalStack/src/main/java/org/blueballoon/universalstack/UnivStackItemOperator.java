package org.blueballoon.universalstack;

public abstract class UnivStackItemOperator extends UnivStackItem {
    // the stack the operator belongs to and operates on
    protected UnivStack m_operatorStack;

    protected UnivStackItemOperator(UnivStack currentStack) {
        m_operatorStack = currentStack;
    }


    /// returns the error object of the operation, if available, NULL otherwise (oder immer, evtl leer?)
    public abstract OperationStatus doOperation();
}
