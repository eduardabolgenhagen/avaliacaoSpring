package br.sc.senai.avaliacaoSpring.model.dto;

import lombok.Data;

@Data
public class EnderecoDTO {
    private String rua;
    private String numero;
    private String bairro;
    private String cidade;
    private String estado;
    private String cep;
}
