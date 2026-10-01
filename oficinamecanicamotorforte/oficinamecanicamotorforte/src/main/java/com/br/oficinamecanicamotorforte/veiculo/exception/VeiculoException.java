package com.br.oficinamecanicamotorforte.veiculo.exception;

public class VeiculoException extends RuntimeException {
    public VeiculoException(Long id) {
        super("Veículo não encontrado com ID: " + id);
    }
}