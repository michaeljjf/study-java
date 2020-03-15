package com.jiangjf.studyweb.model;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@Data
@PropertySource("classpath:person.properties")
@ConfigurationProperties(prefix = "person2")
public class PersonForProperties {

    private String name;

    private String city;
}
