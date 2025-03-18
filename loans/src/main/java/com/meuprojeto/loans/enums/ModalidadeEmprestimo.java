package com.meuprojeto.loans.enums;

import lombok.AllArgsConstructor;



@AllArgsConstructor
public enum ModalidadeEmprestimo {

    PESSOAL(4.0),
    GARANTIA(3.0),
    CONSIGNADO(2.0);

    private final double taxaJuros;


    public double getTaxaJuros(){
        return taxaJuros;
    }

}
