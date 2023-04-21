package br.sc.senai.avaliacaoSpring.controller;

import br.sc.senai.avaliacaoSpring.model.dto.ProdutoPedidoDTO;
import br.sc.senai.avaliacaoSpring.model.entity.ProdutoPedido;
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
@RequestMapping("/prova/produto-pedido")
public class ProdutoPedidoController {
    ProdutoPedidoService produtoPedidoService;

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody @Valid ProdutoPedidoDTO produtoPedidoDTO) {
        ProdutoPedido produtoPedido = new ProdutoPedido();

        BeanUtils.copyProperties(produtoPedidoDTO, produtoPedidoDTO);
        return ResponseEntity.status(HttpStatus.OK).body(produtoPedidoService.save(produtoPedido));
    }

    @PutMapping("/{id_produto_pedido}")
    public ResponseEntity<Object> save(@PathVariable(value = "id_produto_pedido") Long id_produto_pedido,
                                       @RequestBody @Valid ProdutoPedidoDTO produtoPedidoDTO) {
        if (!produtoPedidoService.existsById(id_produto_pedido)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi encontrado o Produto Pedido.");
        }

        ProdutoPedido produtoPedido = new ProdutoPedido();

        BeanUtils.copyProperties(produtoPedidoDTO, produtoPedidoDTO);
        return ResponseEntity.status(HttpStatus.OK).body(produtoPedidoService.save(produtoPedido));
    }

    @GetMapping
    public ResponseEntity<Object> findAll() {
        if (produtoPedidoService.findAll().isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não há Produtos pedidos cadastrados.");
        }
        return ResponseEntity.status(HttpStatus.FOUND).body(produtoPedidoService.findAll());
    }

    @GetMapping("/{id_produto_pedido}")
    public ResponseEntity<Object> findById(@PathVariable(value = "id_produto_pedido") Long id_produto_pedido) {
        Optional<ProdutoPedido> produtoPedidoOptional = produtoPedidoService.findById(id_produto_pedido);

        if (produtoPedidoOptional.isEmpty()) {
            ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto Pedido não cadastrado.");
        }

        return ResponseEntity.status(HttpStatus.FOUND).body(produtoPedidoOptional);
    }

    @DeleteMapping("/{id_produto_pedido}")
    public ResponseEntity<Object> deleteById(@PathVariable(value = "id_produto_pedido") Long id_produto_pedido) {
        if (!produtoPedidoService.existsById(id_produto_pedido)) {
            ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto Pedido não encontrado.");
        }
        produtoPedidoService.deleteById(id_produto_pedido);
        return ResponseEntity.status(HttpStatus.OK).body("Produto Pedido removido com sucesso.");
    }
}
