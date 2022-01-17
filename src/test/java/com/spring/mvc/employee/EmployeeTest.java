package com.spring.mvc.employee;

import mvc.employee.Employee;
import org.junit.jupiter.api.Test;

class EmployeeTest {

    @Test
    void empNumTest() {
        Employee e1 = new Employee("김철수", "대리");
        Employee e2 = new Employee("박영희", "부장");
        System.out.println("e1 = " + e1);
        System.out.println("e2 = " + e2);
    }

}