package org.ds.spring_security_2.dto;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ErrorResponseDTO {
    private int status;
    private String message;
    private long timestamp;
}
