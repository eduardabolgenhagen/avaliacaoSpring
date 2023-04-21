package br.sc.senai.avaliacaoSpring.service;

import br.sc.senai.avaliacaoSpring.model.entity.Produto;
import br.sc.senai.avaliacaoSpring.repository.ProdutoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProdutoService {
    ProdutoRepository produtoRepository;

    public List<Produto> findAll() {
        return produtoRepository.findAll();
    }

    public <S extends Produto> S save(S entity) {
        return produtoRepository.save(entity);
    }

    public Optional<Produto> findById(Long aLong) {
        return produtoRepository.findById(aLong);
    }

    public boolean existsById(Long aLong) {
        return produtoRepository.existsById(aLong);
    }

    public void deleteById(Long aLong) {
        produtoRepository.deleteById(aLong);
    }
}
