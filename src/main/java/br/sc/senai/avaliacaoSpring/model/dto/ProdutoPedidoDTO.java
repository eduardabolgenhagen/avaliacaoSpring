package br.sc.senai.avaliacaoSpring.model.dto;

import br.sc.senai.avaliacaoSpring.model.entity.Pedido;
import br.sc.senai.avaliacaoSpring.model.entity.Produto;
import lombok.Data;

@Data
public class ProdutoPedidoDTO {
    private Integer quantidade;
    private Produto produto;
    private Pedido pedido;

}
