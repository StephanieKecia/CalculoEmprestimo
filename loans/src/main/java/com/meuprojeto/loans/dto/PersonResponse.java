package com.meuprojeto.loans.dto;

import com.meuprojeto.loans.enums.ModalidadeEmprestimo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonResponse {
    private String name;
    private List<LoanInfo> loans;
}



