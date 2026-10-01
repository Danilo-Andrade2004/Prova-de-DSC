package com.br.oficinamecanicamotorforte.veiculo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class VeiculoRequestDTO {
    @NotBlank(message="Placa não pode ser nula ou vazia")
    private String placa;

    @NotBlank (message="Modelo é obrigatório")
    private String modelo;

    @NotNull (message="Ano de fabricação é obrigatório")
    private Integer anoFabricacao;

    @NotBlank (message="Tipo de veículo é obrigatório")
    private String tipo;

    @NotBlank (message="O nome do proprietário do veículo é obrigatório")
    private String proprietario;
}