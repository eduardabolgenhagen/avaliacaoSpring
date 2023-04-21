package br.sc.senai.avaliacaoSpring.model.dto;

import br.sc.senai.avaliacaoSpring.model.entity.Fornecedor;
import lombok.Data;

import java.util.List;

@Data
public class ProdutoDTO {
    private String nome;

    private Double preco;

    private Integer quantidade;

    private List<Fornecedor> fornecedores;

}
