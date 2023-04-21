package br.sc.senai.avaliacaoSpring.model.dto;

import br.sc.senai.avaliacaoSpring.model.entity.CartaoCredito;
import br.sc.senai.avaliacaoSpring.model.entity.Endereco;
import jakarta.validation.constraints.Email;
import lombok.Data;

import java.util.List;

@Data
public class ClienteDTO {
    private String nome;

    @Email
    private String email;
    private String telefone;
    private List<Endereco> enderecos;
    private CartaoCredito cartao;

}
