package br.sc.senai.avaliacaoSpring.model.dto;

import br.sc.senai.avaliacaoSpring.model.entity.Cliente;
import br.sc.senai.avaliacaoSpring.model.entity.Produto;
import lombok.Data;

import java.util.List;

@Data
public class FornecedorDTO {
    private String nome;
    private String cnpj;
    private List<Produto> produtos;
    private List<Cliente> clientes;

}
