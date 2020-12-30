package org.blueballoon.universalstack;

public class USIOperatorAdd extends UnivStackItemOperator {
    public USIOperatorAdd(UnivStack currentStack) {
        super(currentStack);
    }

    public String toString() {
        return("Operator_ADD");
    }

    public OperationStatus doOperation() {
        //Boolean success=false;
        //String errorString="unknown error";

        // add benoetigt 2 Operanden - stack pruefen ob min 2 items am stack sind - ansonsten error-abbruch
        
        // hole die naechsten 2 items vom stack

        // pruefe, ob beide items operanden sind - ansonsten wieder auf stack pushen und  error-abbruch
        // evtl methode, ob N items alle vom typ operand sind, als protected-methode in UnivStackOperator

        // stelle typ der beiden operanden fest

        // pruefe kompatibilitaet, ansosnten wieder auf stack pushen und error-abbruch
        // anm: evtl eigene methode fuer stack-restore (ueberlegen ob stackitems als objattribute oder methodenvariablen)
        // kompatibilitaets-check als eigene methode

        // je nach operandentyp - durchfuehrung der operation
        // evtl je nach operandentyp/-paarung eine eigene methode

        return(new OperationStatus(true,""));
    }
}
