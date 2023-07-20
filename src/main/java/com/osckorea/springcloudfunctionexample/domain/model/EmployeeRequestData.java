package com.osckorea.springcloudfunctionexample.domain.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class EmployeeRequestData {

    private List<Employee> employees;
}
