package br.sc.senai.avaliacaoSpring.model.dto;

import br.sc.senai.avaliacaoSpring.model.entity.Endereco;
import br.sc.senai.avaliacaoSpring.model.entity.Pedido;
import lombok.Data;

@Data
public class EnderecoEntregaDTO {
    private Endereco endereco;
    private Pedido pedido;

}
