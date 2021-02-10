package com.darashuk.spring.restClient;

import com.darashuk.spring.restClient.configuration.MyConfiguration;
import com.darashuk.spring.restClient.entity.Employee;
import com.darashuk.spring.restClient.configuration.MyConfiguration;
import com.darashuk.spring.restClient.entity.Employee;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

/**
 "этот REST Client работает в паре с приложением TEST_REST"
 */
public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfiguration.class);

        Communications communications = context.getBean("communications", Communications.class);

        getAllEmployee(communications);
//        getEmployeeById(communications);
//       saveOrUpdateEmployee(communications);
 //        deleteEmployee(communications);

    }

    private static void getAllEmployee(Communications communications) {
        List<Employee> employeeList = communications.getAll();
        employeeList.stream().forEach(x-> System.out.println(x));
    }

    private static void getEmployeeById(Communications communications) {
        Employee employee = communications.getById(1);
        System.out.println(employee);

    }

    private static void saveOrUpdateEmployee(Communications communications) {
        Employee employee = new Employee();
        employee.setId(16);
        employee.setName("sveta");
        employee.setSurname("sokolova");
        employee.setDepartment("HR");
        employee.setSalary(888);

        communications.saveOrUpdate(employee);

    }
    private static void deleteEmployee(Communications communications) {
        communications.delete(16);

    }

}
