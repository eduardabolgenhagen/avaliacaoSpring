package br.sc.senai.avaliacaoSpring.controller;

import br.sc.senai.avaliacaoSpring.model.dto.PedidoDTO;
import br.sc.senai.avaliacaoSpring.model.entity.EnderecoEntrega;
import br.sc.senai.avaliacaoSpring.model.entity.Pedido;
import br.sc.senai.avaliacaoSpring.model.entity.ProdutoPedido;
import br.sc.senai.avaliacaoSpring.service.EnderecoEntregaService;
import br.sc.senai.avaliacaoSpring.service.PedidoService;
import br.sc.senai.avaliacaoSpring.service.ProdutoPedidoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@AllArgsConstructor
@RequestMapping("/prova/pedido")
public class PedidoController {
    PedidoService pedidoService;
    ProdutoPedidoService produtoPedidoService;
    EnderecoEntregaService enderecoEntregaService;

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody @Valid PedidoDTO pedidoDTO) {
        Pedido pedido = new Pedido();

        if (pedidoDTO.getValorTotal() <= 0) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Valor inseridos estão incorretos.");
        }

        BeanUtils.copyProperties(pedidoDTO, pedido);

        // Objeto filho: endereço entrega
        EnderecoEntrega enderecoEntrega = pedido.getEndereco();
        enderecoEntrega.setPedido(pedido);
        enderecoEntregaService.save(enderecoEntrega);

        // Objeto filho : produto pedido
        for (ProdutoPedido produtoPedido : pedidoDTO.getProdutos()) {
            System.out.println(produtoPedido);
            produtoPedido.setPedido(pedido);
            produtoPedidoService.save(produtoPedido);
        }

        return ResponseEntity.status(HttpStatus.OK).body(pedidoService.save(pedido));
    }

    @PutMapping("/{id_pedido}")
    public ResponseEntity<Object> save(@PathVariable(value = "id_pedido") Long id_pedido,
                                       @RequestBody @Valid PedidoDTO pedidoDTO) {
        if (!pedidoService.existsById(id_pedido)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi encontrado o pedido.");
        }

        Pedido pedido = new Pedido();

        if (pedidoDTO.getValorTotal() <= 0) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Valor inseridos estão incorretos.");
        }

        BeanUtils.copyProperties(pedidoDTO, pedido);

        // Objeto filho: endereço entrega
        EnderecoEntrega enderecoEntrega = new EnderecoEntrega();
        enderecoEntrega = pedido.getEndereco();
        enderecoEntrega.setPedido(pedido);
        enderecoEntregaService.save(enderecoEntrega);

        // Objeto filho : produto pedido
        for (ProdutoPedido produtoPedido : pedidoDTO.getProdutos()) {
            System.out.println(produtoPedido);
            produtoPedido.setPedido(pedido);
            produtoPedidoService.save(produtoPedido);
        }

        return ResponseEntity.status(HttpStatus.OK).body(pedidoService.save(pedido));
    }

    @GetMapping
    public ResponseEntity<Object> findAll() {
        if (pedidoService.findAll().isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não há pedidos cadastrados.");
        }
        return ResponseEntity.status(HttpStatus.FOUND).body(pedidoService.findAll());
    }

    @GetMapping("/{id_pedido}")
    public ResponseEntity<Object> findById(@PathVariable(value = "id_pedido") Long id_pedido) {
        Optional<Pedido> pedidoOptional = pedidoService.findById(id_pedido);

        if (pedidoOptional.isEmpty()) {
            ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pedido não cadastrado.");
        }

        return ResponseEntity.status(HttpStatus.FOUND).body(pedidoOptional);
    }

    @DeleteMapping("/{id_pedido}")
    public ResponseEntity<Object> deleteById(@PathVariable(value = "id_pedido") Long id_pedido) {
        if (!pedidoService.existsById(id_pedido)) {
            ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pedido não encontrado.");
        }
        pedidoService.deleteById(id_pedido);
        return ResponseEntity.status(HttpStatus.OK).body("Pedido removido com sucesso.");
    }
}
