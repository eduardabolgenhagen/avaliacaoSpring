package br.sc.senai.avaliacaoSpring.service;

import br.sc.senai.avaliacaoSpring.model.entity.CartaoCredito;
import br.sc.senai.avaliacaoSpring.repository.CartaoCreditoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CartaoCreditoService {
    CartaoCreditoRepository cartaoCreditoRepository;

    public List<CartaoCredito> findAll() {
        return cartaoCreditoRepository.findAll();
    }

    public <S extends CartaoCredito> S save(S entity) {
        return cartaoCreditoRepository.save(entity);
    }

    public Optional<CartaoCredito> findById(Long aLong) {
        return cartaoCreditoRepository.findById(aLong);
    }

    public boolean existsById(Long aLong) {
        return cartaoCreditoRepository.existsById(aLong);
    }

    public void deleteById(Long aLong) {
        cartaoCreditoRepository.deleteById(aLong);
    }


}
