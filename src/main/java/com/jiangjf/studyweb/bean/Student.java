package com.jiangjf.studyweb.bean;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class Student {
    private String sno;
    private String name;
    private String sex;
}
