package br.sc.senai.avaliacaoSpring.controller;

import br.sc.senai.avaliacaoSpring.model.dto.ClienteDTO;
import br.sc.senai.avaliacaoSpring.model.entity.Cliente;
import br.sc.senai.avaliacaoSpring.service.ClienteService;
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
@RequestMapping("/prova/cliente")
public class ClienteController {
    ClienteService clienteService;

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody @Valid ClienteDTO clienteDTO) {
        Cliente cliente = new Cliente();
        BeanUtils.copyProperties(clienteDTO, cliente);
        return ResponseEntity.status(HttpStatus.OK).body(clienteService.save(cliente));
    }

    @PutMapping("/{id_cliente}")
    public ResponseEntity<Object> save(@PathVariable(value = "id_cliente") Long id_cliente,
                                       @RequestBody @Valid ClienteDTO clienteDTO) {
        Cliente cliente = new Cliente();

        if (!clienteService.existsById(id_cliente)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi encontrado o cliente.");
        }

        BeanUtils.copyProperties(clienteDTO, cliente);
        return ResponseEntity.status(HttpStatus.OK).body(clienteService.save(cliente));
    }

    @GetMapping
    public ResponseEntity<Object> findAll() {
        if (clienteService.findAll().isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não há clientes cadastrados.");
        }
        return ResponseEntity.status(HttpStatus.FOUND).body(clienteService.findAll());
    }

    @GetMapping("/{id_cliente}")
    public ResponseEntity<Object> findById(@PathVariable(value = "id_cliente") Long id_cliente) {
        Optional<Cliente> clienteOptional = clienteService.findById(id_cliente);

        if (clienteOptional.isEmpty()) {
            ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não cadastrado.");
        }

        return ResponseEntity.status(HttpStatus.FOUND).body(clienteOptional);
    }

    @DeleteMapping("/{id_cliente}")
    public ResponseEntity<Object> deleteById(@PathVariable(value = "id_cliente") Long id_cliente) {
        if (!clienteService.existsById(id_cliente)) {
            ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado.");
        }
        clienteService.deleteById(id_cliente);
        return ResponseEntity.status(HttpStatus.OK).body("Cliente removido com sucesso.");
    }

}
