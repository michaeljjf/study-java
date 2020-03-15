package com.jiangjf.studyweb.model;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
public class Person {

    @Value("${person.name}")
    private String name;

    @Value("${person.city}")
    private String city;

    @Value("${person.env}")
    private String env;
}
