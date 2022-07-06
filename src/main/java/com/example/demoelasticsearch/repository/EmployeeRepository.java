package com.example.demoelasticsearch.repository;

import com.example.demoelasticsearch.model.Employee;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface EmployeeRepository extends ElasticsearchRepository<Employee,String> {

    @Query("{\"bool\": {\"must\": [{\"match\": {\"name\": \"?0\"}}]}}")
    List<Employee> getByCustomQuery(String search);

    List<Employee>  findByNameLikeOrAdressLike(String name, String adress);
}
