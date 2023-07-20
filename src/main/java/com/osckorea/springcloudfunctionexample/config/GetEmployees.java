package com.osckorea.springcloudfunctionexample.config;

import com.osckorea.springcloudfunctionexample.domain.model.Employee;
import com.osckorea.springcloudfunctionexample.domain.model.EmployeeRequestData;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class GetEmployees implements Supplier<EmployeeRequestData> {

    @Override
    public EmployeeRequestData get() {
        EmployeeRequestData employeeRequestData = new EmployeeRequestData();
        employeeRequestData.setEmployees(this.employees());
        return employeeRequestData;
    }

    // 리스트 생성

    private List<Employee> employees() {
        return new ArrayList<>() {{
           add(new Employee("1","hwan", "kohzzng@naver.com"));
            add(new Employee("2","rok", "kohzzng@naver.com"));
            add(new Employee("3","jiyoo", "kohzzng@naver.com"));
            add(new Employee("4","yeelyn", "kohzzng@naver.com"));
        }};
    }
}
