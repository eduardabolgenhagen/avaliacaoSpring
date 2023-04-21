package br.sc.senai.avaliacaoSpring.model.dto;

import br.sc.senai.avaliacaoSpring.model.entity.Cliente;
import br.sc.senai.avaliacaoSpring.model.entity.EnderecoEntrega;
import br.sc.senai.avaliacaoSpring.model.entity.ProdutoPedido;
import lombok.Data;

import java.util.List;

@Data
public class PedidoDTO {
    private Double valorTotal;
    private List<ProdutoPedido> produtos;
    private Cliente cliente;
    private EnderecoEntrega endereco;
}
