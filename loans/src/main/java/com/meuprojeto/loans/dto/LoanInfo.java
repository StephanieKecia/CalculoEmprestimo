package com.meuprojeto.loans.dto;

import com.meuprojeto.loans.enums.ModalidadeEmprestimo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoanInfo {
    private String type;
    private Double interestRate;
}
