package com.nashss.se.hms.exceptions;

public class PatientNotFoundException extends RuntimeException{


    private static final long serialVersionUID = 1398547381682727285L;

    public PatientNotFoundException() {
        super();
    }

    public PatientNotFoundException(String message) {
        super(message);
    }

    public PatientNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public PatientNotFoundException(Throwable cause) {
        super(cause);
    }


}
