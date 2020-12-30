package org.blueballoon.universalstack;

public class USIOperandDouble extends UnivStackItemOperand {
    private Double m_payload;

    public USIOperandDouble(Double payload) {
        m_payload = payload;
    }

    public Double getPayload() {
        return(m_payload);
    }

    public String toString() {
        return(m_payload.toString());
    }
}
