package br.sc.senai.avaliacaoSpring.service;

import br.sc.senai.avaliacaoSpring.model.entity.ProdutoPedido;
import br.sc.senai.avaliacaoSpring.repository.ProdutoPedidoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProdutoPedidoService {
    ProdutoPedidoRepository produtoPedidoRepository;

    public List<ProdutoPedido> findAll() {
        return produtoPedidoRepository.findAll();
    }

    public <S extends ProdutoPedido> S save(S entity) {
        return produtoPedidoRepository.save(entity);
    }

    public Optional<ProdutoPedido> findById(Long aLong) {
        return produtoPedidoRepository.findById(aLong);
    }

    public boolean existsById(Long aLong) {
        return produtoPedidoRepository.existsById(aLong);
    }

    public void deleteById(Long aLong) {
        produtoPedidoRepository.deleteById(aLong);
    }
}
