package br.sc.senai.avaliacaoSpring.controller;

import br.sc.senai.avaliacaoSpring.model.dto.ProdutoDTO;
import br.sc.senai.avaliacaoSpring.model.entity.Produto;
import br.sc.senai.avaliacaoSpring.service.ProdutoService;
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
@RequestMapping("/prova/produto")
public class ProdutoController {
    ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody @Valid ProdutoDTO produtoDTO) {
        Produto produto = new Produto();
        BeanUtils.copyProperties(produtoDTO, produto);
        return ResponseEntity.status(HttpStatus.OK).body(produtoService.save(produto));
    }

    @PutMapping("/{id_produto}")
    public ResponseEntity<Object> save(@PathVariable(value = "id_produto") Long id_produto,
                                       @RequestBody @Valid ProdutoDTO produtoDTO) {
        if (!produtoService.existsById(id_produto)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi encontrado o produto.");
        }

        Produto produto = new Produto();
        BeanUtils.copyProperties(produtoDTO, produto);
        return ResponseEntity.status(HttpStatus.OK).body(produtoService.save(produto));
    }

    @GetMapping
    public ResponseEntity<Object> findAll() {
        if (produtoService.findAll().isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não há produtos cadastrados.");
        }
        return ResponseEntity.status(HttpStatus.FOUND).body(produtoService.findAll());
    }

    @GetMapping("/{id_produto}")
    public ResponseEntity<Object> findById(@PathVariable(value = "id_produto") Long id_produto) {
        Optional<Produto> produtoOptional = produtoService.findById(id_produto);

        if (produtoOptional.isEmpty()) {
            ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não cadastrado.");
        }

        return ResponseEntity.status(HttpStatus.FOUND).body(produtoOptional);
    }

    @DeleteMapping("/{id_produto}")
    public ResponseEntity<Object> deleteById(@PathVariable(value = "id_produto") Long id_produto) {
        if (!produtoService.existsById(id_produto)) {
            ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado.");
        }
        produtoService.deleteById(id_produto);
        return ResponseEntity.status(HttpStatus.OK).body("Produto removido com sucesso.");
    }
}
