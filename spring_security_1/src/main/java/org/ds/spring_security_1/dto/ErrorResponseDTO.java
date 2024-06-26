package org.ds.spring_security_1.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;


@Getter
@Setter
public class ErrorResponseDTO {
    private int status;
    private String message;

    private long timestamp;
}
