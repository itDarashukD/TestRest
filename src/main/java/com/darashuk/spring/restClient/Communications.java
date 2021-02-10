package com.darashuk.spring.restClient;

import com.darashuk.spring.restClient.entity.Employee;
import com.darashuk.spring.restClient.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class Communications {

    private RestTemplate restTemplate;

    @Autowired
    public Communications(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    private final String URL = "http://localhost:8080/TestRest_war_exploded/api/employees";


    public List<Employee> getAll() {
        //получаем в  ResponseEntity<List<Employee>>  - ответы на все запросы по URL
        //т.е. делаем запрос по  URL к Service из прошлого приложение (TEST_REST, там включен сервер).
        // это приложение получает все данные которые есть в БД
        ResponseEntity<List<Employee>> responseEntity = restTemplate.exchange(URL, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Employee>>() {
                });

        List<Employee> employees = responseEntity.getBody();


        return employees;
    }

    public Employee getById(int id) {
       Employee employee = restTemplate.getForObject(URL +"/"+id,Employee.class);


        return employee;
    }

    public void saveOrUpdate(Employee employee) {
        int id = employee.getId();
        if (id == 0) {
            ResponseEntity responseEntity = restTemplate.postForEntity(URL,employee,String.class);
            System.out.println("new employee was added "+ responseEntity.getBody());
        }
        else restTemplate.put(URL,employee);
        System.out.println("employee with "+ id + " was updated");

    }

    public void delete(int id) {
        restTemplate.delete(URL +"/"+id);
        System.out.println("employee with "+ id + " was deleted");

    }

}
