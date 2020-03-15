package com.jiangjf.studyweb.controller;

import com.jiangjf.studyweb.model.Person;
import com.jiangjf.studyweb.model.PersonForProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PersonController {

    @Autowired
    private Person person;
    @Autowired
    private PersonForProperties personForProperties;

    @ResponseBody
    @RequestMapping("/person")
    public String person() {
        return person.getName() + "---" + person.getCity() + "---" + person.getEnv();
    }

    @ResponseBody
    @RequestMapping("/person-config")
    public String personConfig()
    {
        return personForProperties.getName() + "---" + personForProperties.getCity();
    }
}
