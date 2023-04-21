package br.sc.senai.avaliacaoSpring.controller;

import br.sc.senai.avaliacaoSpring.model.dto.CartaoCreditoDTO;
import br.sc.senai.avaliacaoSpring.model.entity.CartaoCredito;
import br.sc.senai.avaliacaoSpring.service.CartaoCreditoService;
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
@RequestMapping("/prova/cartaocredito")
public class CartaoCreditoController {
    CartaoCreditoService cartaoCreditoService;

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody @Valid CartaoCreditoDTO cartaoCreditoDTO) {
        CartaoCredito cartaoCredito = new CartaoCredito();
        BeanUtils.copyProperties(cartaoCreditoDTO, cartaoCredito);
        return ResponseEntity.status(HttpStatus.OK).body(cartaoCreditoService.save(cartaoCredito));
    }

    @PutMapping("/{id_cartao_credito}")
    public ResponseEntity<Object> save(@PathVariable(value = "id_cartao_credito") Long id_cartao_credito,
                                       @RequestBody @Valid CartaoCreditoDTO cartaoCreditoDTO) {
        CartaoCredito cartaoCredito = new CartaoCredito();

        if (!cartaoCreditoService.existsById(id_cartao_credito)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi encontrado o cartão de crédito.");
        }

        BeanUtils.copyProperties(cartaoCreditoDTO, cartaoCredito);
        return ResponseEntity.status(HttpStatus.OK).body(cartaoCreditoService.save(cartaoCredito));
    }

    @GetMapping
    public ResponseEntity<Object> findAll() {
        if (cartaoCreditoService.findAll().isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não há cartões de crédito cadastrados.");
        }
        return ResponseEntity.status(HttpStatus.FOUND).body(cartaoCreditoService.findAll());
    }

    @GetMapping("/{id_cartao_credito}")
    public ResponseEntity<Object> findById(@PathVariable(value = "id_cartao_credito") Long id_cartao_credito) {
        Optional<CartaoCredito> cartaoCreditoOptional = cartaoCreditoService.findById(id_cartao_credito);

        if (cartaoCreditoOptional.isEmpty()) {
            ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cartão de crédito não cadastrado.");
        }

        // Verificar esse retornos
        return ResponseEntity.status(HttpStatus.FOUND).body(cartaoCreditoOptional);
    }

    @DeleteMapping("/{id_cartao_credito}")
    public ResponseEntity<Object> deleteById(@PathVariable(value = "id_cartao_credito") Long id_cartao_credito) {
        if (!cartaoCreditoService.existsById(id_cartao_credito)) {
            ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cartão de crédito não encontrado.");
        }
        cartaoCreditoService.deleteById(id_cartao_credito);
        return ResponseEntity.status(HttpStatus.OK).body("Cartão de crédito removido com sucesso.");
    }


}
