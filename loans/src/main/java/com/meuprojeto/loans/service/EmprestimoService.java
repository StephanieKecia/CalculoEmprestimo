package com.meuprojeto.loans.service;

import com.meuprojeto.loans.dto.LoanInfo;
import com.meuprojeto.loans.dto.Person;
import com.meuprojeto.loans.dto.PersonResponse;
import org.springframework.stereotype.Service;

import com.meuprojeto.loans.enums.ModalidadeEmprestimo;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class EmprestimoService {

    private PersonResponse personResponse;

    public List<String> listarModalidades(){
      return Arrays.stream(ModalidadeEmprestimo.values()).map(m ->m.name() + ": Taxa de juros de " + m.getTaxaJuros() + "%").collect(Collectors.toList());
    }


    public List<LoanInfo> returnLoans(Person person) {

        double income = Double.parseDouble(person.getIncome());
        int age = Integer.parseInt(person.getAge());
        String location = person.getLocation();


        double limiteMenor = 3.000;
        double limiteMaior = 5.000;
        Integer limiteIdade = 30;
        String cidadeRef = "São Paulo";


        if (income <= limiteMenor){
            return Arrays.stream(ModalidadeEmprestimo.values())
                    .filter(m -> m.name().equals("PESSOAL") || m.name().equals("GARANTIA")) // Filtra pelos nomes desejados
                    .map(m -> new LoanInfo(m.name(), m.getTaxaJuros()))
                    .collect(Collectors.toList());

        }
        else if (income >= limiteMenor && income <= limiteMaior && age < limiteIdade && cidadeRef.equals(location)){

            return Arrays.stream(ModalidadeEmprestimo.values())
                    .filter(m -> m.name().equals("PESSOAL") || m.name().equals("GARANTIA")) // Filtra pelos nomes desejados
                    .map(m -> new LoanInfo(m.name(), m.getTaxaJuros()))
                    .collect(Collectors.toList());
        }
        else if (income >= limiteMaior){

            return Arrays.stream(ModalidadeEmprestimo.values())
                    .filter(m -> m.name().equals("CONSIGNADO")).map(m -> new LoanInfo(m.name(), m.getTaxaJuros()))
                    .collect(Collectors.toList());
        }
        return List.of();
    }
}



