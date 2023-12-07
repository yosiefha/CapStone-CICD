package com.nashss.se.hms.exceptions;

public class MedicationNotFoundException extends RuntimeException {


    private static final long serialVersionUID = -111486133021682490L;
    public MedicationNotFoundException() {
        super();
    }

    public MedicationNotFoundException(String message) {
        super(message);
    }

    public MedicationNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public MedicationNotFoundException(Throwable cause) {
        super(cause);
    }


}
