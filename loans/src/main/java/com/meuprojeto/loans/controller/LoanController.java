package com.meuprojeto.loans.controller;


import com.meuprojeto.loans.dto.LoanInfo;
import com.meuprojeto.loans.dto.Person;
import com.meuprojeto.loans.enums.ModalidadeEmprestimo;
import com.meuprojeto.loans.service.PersonService;
import org.springframework.web.bind.annotation.*;

import com.meuprojeto.loans.service.EmprestimoService;
import java.util.List;

@RestController
@RequestMapping("/loan")
public class LoanController {

    private final EmprestimoService emprestimoService;

    public LoanController(EmprestimoService emprestimoService, PersonService personService){
        this.emprestimoService = emprestimoService;

    }

    @GetMapping
    public List<String> getModalidades(){
        return emprestimoService.listarModalidades();
    }

    @PostMapping
    public List<LoanInfo> getFull(@RequestBody Person person){
        return emprestimoService.returnLoans(person);
    }

}
