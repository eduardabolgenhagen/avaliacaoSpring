package br.sc.senai.avaliacaoSpring.controller;

import br.sc.senai.avaliacaoSpring.model.dto.EnderecoEntregaDTO;
import br.sc.senai.avaliacaoSpring.model.entity.EnderecoEntrega;
import br.sc.senai.avaliacaoSpring.service.EnderecoEntregaService;
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
@RequestMapping("/prova/endereco-entrega")
public class EnderecoEntregaController {
    EnderecoEntregaService enderecoEntregaService;

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody @Valid EnderecoEntregaDTO enderecoEntregaDTO) {
        EnderecoEntrega enderecoEntrega = new EnderecoEntrega();
        BeanUtils.copyProperties(enderecoEntregaDTO, enderecoEntrega);

        return ResponseEntity.status(HttpStatus.OK).body(enderecoEntregaService.save(enderecoEntrega));
    }

    @PutMapping("/{id_endereco_entrega}")
    public ResponseEntity<Object> save(@PathVariable(value = "id_endereco_entrega") Long id_endereco_entrega,
                                       @RequestBody @Valid EnderecoEntregaDTO enderecoEntregaDTO) {
        EnderecoEntrega enderecoEntrega = new EnderecoEntrega();

        if (!enderecoEntregaService.existsById(id_endereco_entrega)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi encontrado o Endereço Entrega.");
        }

        BeanUtils.copyProperties(enderecoEntregaDTO, enderecoEntrega);
        return ResponseEntity.status(HttpStatus.OK).body(enderecoEntregaService.save(enderecoEntrega));
    }

    @GetMapping
    public ResponseEntity<Object> findAll() {
        if (enderecoEntregaService.findAll().isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não há Endereços Entregas cadastrados.");
        }
        return ResponseEntity.status(HttpStatus.FOUND).body(enderecoEntregaService.findAll());
    }

    @GetMapping("/{id_endereco_entrega}")
    public ResponseEntity<Object> findById(@PathVariable(value = "id_endereco_entrega") Long id_endereco_entrega) {
        Optional<EnderecoEntrega> enderecoEntregaOptional = enderecoEntregaService.findById(id_endereco_entrega);

        if (enderecoEntregaOptional.isEmpty()) {
            ResponseEntity.status(HttpStatus.NOT_FOUND).body("Endereço Entrega não cadastrado.");
        }

        return ResponseEntity.status(HttpStatus.FOUND).body(enderecoEntregaOptional);
    }

    @DeleteMapping("/{id_endereco_entrega}")
    public ResponseEntity<Object> deleteById(@PathVariable(value = "id_endereco_entrega") Long id_endereco_entrega) {
        if (!enderecoEntregaService.existsById(id_endereco_entrega)) {
            ResponseEntity.status(HttpStatus.NOT_FOUND).body("Endereço Entrega não encontrado.");
        }
        enderecoEntregaService.deleteById(id_endereco_entrega);
        return ResponseEntity.status(HttpStatus.OK).body("Endereço Entrega removido com sucesso.");
    }
}
