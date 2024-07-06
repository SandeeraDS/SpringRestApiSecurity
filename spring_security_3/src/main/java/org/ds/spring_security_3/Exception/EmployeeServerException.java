package org.ds.spring_security_3.Exception;

public class EmployeeServerException extends RuntimeException {
    public EmployeeServerException() {
        super();
    }

    public EmployeeServerException(String message) {
        super(message);
    }

    public EmployeeServerException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmployeeServerException(Throwable cause) {
        super(cause);
    }
}
