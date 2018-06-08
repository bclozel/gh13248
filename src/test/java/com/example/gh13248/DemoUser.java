package com.example.gh13248;

import javax.validation.constraints.NotBlank;

import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

@Data
@Builder
//@AllArgsConstructor
//@NoArgsConstructor
public class DemoUser {
    private String id;
    @NotBlank
    private String name;
    @Range(min = 10,max = 100)
    private Integer age;
}
