package org.ds.spring_security_2.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class EmployeeDTO {
    private long id;
    private String firstName;
    private String lastName;
    private String email;
}
