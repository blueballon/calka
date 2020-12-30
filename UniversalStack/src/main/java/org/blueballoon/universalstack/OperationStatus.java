package org.blueballoon.universalstack;

public class OperationStatus {
    private Boolean m_success;
    private String  m_errorString;

    public OperationStatus(Boolean success,
                           String errorString) {
        m_success = success;
        m_errorString = errorString;
    }

    public Boolean getSuccess() {
        return(m_success);
    }

    public String getErrorString() {
        return(m_errorString);
    }
}
