package com.example.demoelasticsearch.controller;

import com.example.demoelasticsearch.model.Employee;
import com.example.demoelasticsearch.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.Calendar;
import java.util.List;

@RestController
@RequestMapping("/emp")
public class EmployeeController {
    private final EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    @PostConstruct
    public void init(){
        Employee employee = new Employee();
        employee.setName("Yusuf");
        employee.setSurname("Gökalp");
        employee.setAdress("Istanbul");
        employee.setBirthday(Calendar.getInstance().getTime());
        employee.setId("I001");
        employeeRepository.save(employee);
    }

    @GetMapping("/{search}")
    public ResponseEntity<List<Employee>>getEmployee(@PathVariable String search){
        List<Employee>employees = employeeRepository.findByNameLikeOrAdressLike(search ,search);
                return ResponseEntity.ok(employees);
    }
}
