package com.osckorea.springcloudfunctionexample.domain.model;

import lombok.*;
import org.springframework.web.bind.annotation.RestController;

@Getter
@ToString
@AllArgsConstructor
@RequiredArgsConstructor
public class Employee {

    private String id;
    private String name;
    private String email;
}
