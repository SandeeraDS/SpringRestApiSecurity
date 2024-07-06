package org.ds.spring_security_3.Exception;

public class EmployeeClientException extends RuntimeException {
    public EmployeeClientException() {
        super();
    }

    public EmployeeClientException(String message) {
        super(message);
    }

    public EmployeeClientException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmployeeClientException(Throwable cause) {
        super(cause);
    }
}
