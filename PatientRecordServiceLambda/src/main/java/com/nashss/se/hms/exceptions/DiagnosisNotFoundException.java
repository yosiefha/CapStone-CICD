package com.nashss.se.hms.exceptions;

public class DiagnosisNotFoundException extends RuntimeException {
    private static final long serialVersionUID = -509174827663617974L;

    public DiagnosisNotFoundException() {
        super();
    }

    public DiagnosisNotFoundException(String message) {
        super(message);
    }

    public DiagnosisNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public DiagnosisNotFoundException(Throwable cause) {
        super(cause);
    }

}
