package com.example.demoelasticsearch.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "employees" )
public class Employee {
    @Id
    private String id;

    @Field(name= "name",type = FieldType.Text)
    private String name;

    @Field(name="surname",type = FieldType.Text)
    private String surname;

    @Field(name="adress",type = FieldType.Text)
    private String adress;

    @Field(name="birthday",type = FieldType.Date)
    private Date birthday;


}
