package com.meuprojeto.loans.controller;

import com.meuprojeto.loans.dto.LoanInfo;
import com.meuprojeto.loans.dto.Person;

import com.meuprojeto.loans.dto.PersonResponse;
import com.meuprojeto.loans.enums.ModalidadeEmprestimo;
import com.meuprojeto.loans.service.EmprestimoService;
import com.meuprojeto.loans.service.PersonService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/customer-loans")
public class PersonController {

    private final EmprestimoService emprestimoService;
    private final PersonService personService;

    public PersonController( PersonService personService,EmprestimoService emprestimoService){
        this.personService = personService;
        this.emprestimoService = emprestimoService;
    }


    @PostMapping
    public PersonResponse getFull(@RequestBody Person person) {
        List<LoanInfo> listLoan = emprestimoService.returnLoans(person);
        String name = personService.returnName(person.getName());
        return new PersonResponse(name, listLoan);
    }
}
