package br.sc.senai.avaliacaoSpring.controller;

import br.sc.senai.avaliacaoSpring.model.dto.EnderecoDTO;
import br.sc.senai.avaliacaoSpring.model.entity.Endereco;
import br.sc.senai.avaliacaoSpring.service.EnderecoService;
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
@RequestMapping("/prova/endereco")
public class EnderecoController {
    EnderecoService enderecoService;

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody @Valid EnderecoDTO enderecoDTO) {
        Endereco endereco = new Endereco();
        BeanUtils.copyProperties(enderecoDTO, endereco);
        return ResponseEntity.status(HttpStatus.OK).body(enderecoService.save(endereco));
    }

    @PutMapping("/{id_endereco}")
    public ResponseEntity<Object> save(@PathVariable(value = "id_endereco") Long id_endereco,
                                       @RequestBody @Valid EnderecoDTO enderecoDTO) {
        Endereco endereco = new Endereco();

        if (!enderecoService.existsById(id_endereco)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi encontrado o endereço.");
        }

        BeanUtils.copyProperties(enderecoDTO, endereco);
        return ResponseEntity.status(HttpStatus.OK).body(enderecoService.save(endereco));
    }

    @GetMapping
    public ResponseEntity<Object> findAll() {
        if (enderecoService.findAll().isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não há endereços cadastrados.");
        }
        return ResponseEntity.status(HttpStatus.FOUND).body(enderecoService.findAll());
    }


    @GetMapping("/{id_endereco}")
    public ResponseEntity<Object> findById(@PathVariable(value = "id_endereco") Long id_endereco) {
        Optional<Endereco> enderecoOptional = enderecoService.findById(id_endereco);

        if (enderecoOptional.isEmpty()) {
            ResponseEntity.status(HttpStatus.NOT_FOUND).body("Endereço não cadastrado.");
        }

        // Verificar esse retornos
        return ResponseEntity.status(HttpStatus.FOUND).body(enderecoOptional);
    }

    @DeleteMapping("/{id_endereco}")
    public ResponseEntity<Object> deleteById(@PathVariable(value = "id_endereco") Long id_endereco) {
        if (!enderecoService.existsById(id_endereco)) {
            ResponseEntity.status(HttpStatus.NOT_FOUND).body("Endereço não encontrado.");
        }
        enderecoService.deleteById(id_endereco);
        return ResponseEntity.status(HttpStatus.OK).body("Endereço removido com sucesso.");
    }
}
