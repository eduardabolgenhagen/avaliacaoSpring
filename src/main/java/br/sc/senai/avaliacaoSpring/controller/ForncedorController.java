package br.sc.senai.avaliacaoSpring.controller;

import br.sc.senai.avaliacaoSpring.model.dto.CartaoCreditoDTO;
import br.sc.senai.avaliacaoSpring.model.dto.FornecedorDTO;
import br.sc.senai.avaliacaoSpring.model.entity.CartaoCredito;
import br.sc.senai.avaliacaoSpring.model.entity.Fornecedor;
import br.sc.senai.avaliacaoSpring.model.entity.Produto;
import br.sc.senai.avaliacaoSpring.service.FornecedorService;
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
@RequestMapping("/prova/fornecedor")
public class ForncedorController {
    FornecedorService fornecedorService;

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody @Valid FornecedorDTO fornecedorDTO) {
        Fornecedor fornecedor = new Fornecedor();
        BeanUtils.copyProperties(fornecedorDTO, fornecedor);

        for (Produto produto : fornecedor.getProdutos()) {
            if (produto.getPreco() < 0 || produto.getQuantidade() < 0) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body("Valores inseridos estão incorretos");
            }
        }

        return ResponseEntity.status(HttpStatus.OK).body(fornecedorService.save(fornecedor));
    }

    @PutMapping("/{id_fornecedor}")
    public ResponseEntity<Object> save(@PathVariable(value = "id_fornecedor") Long id_fornecedor,
                                       @RequestBody @Valid FornecedorDTO fornecedorDTO) {
        Fornecedor fornecedor = new Fornecedor();

        if (!fornecedorService.existsById(id_fornecedor)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi encontrado o fornecedor.");
        }

        BeanUtils.copyProperties(fornecedorDTO, fornecedor);
        return ResponseEntity.status(HttpStatus.OK).body(fornecedorService.save(fornecedor));
    }

    @GetMapping
    public ResponseEntity<Object> findAll() {
        if (fornecedorService.findAll().isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não há fornecedores cadastrados.");
        }
        return ResponseEntity.status(HttpStatus.FOUND).body(fornecedorService.findAll());
    }

    @GetMapping("/{id_fornecedor}")
    public ResponseEntity<Object> findById(@PathVariable(value = "id_fornecedor") Long id_fornecedor) {
        Optional<Fornecedor> fornecedorOptional = fornecedorService.findById(id_fornecedor);

        if (fornecedorOptional.isEmpty()) {
            ResponseEntity.status(HttpStatus.NOT_FOUND).body("Fornecedor não cadastrado.");
        }

        return ResponseEntity.status(HttpStatus.FOUND).body(fornecedorOptional);
    }

    @DeleteMapping("/{id_fornecedor}")
    public ResponseEntity<Object> deleteById(@PathVariable(value = "id_fornecedor") Long id_fornecedor) {
        if (!fornecedorService.existsById(id_fornecedor)) {
            ResponseEntity.status(HttpStatus.NOT_FOUND).body("Fornecedor não encontrado.");
        }
        fornecedorService.deleteById(id_fornecedor);
        return ResponseEntity.status(HttpStatus.OK).body("Fornecedor removido com sucesso.");
    }
}
