package com.meuprojeto.loans.service;

import com.meuprojeto.loans.dto.Person;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    public Person returnPerson(Person person){
        return person;
    }

    public String returnName(String name){
        return name;
    }

}
