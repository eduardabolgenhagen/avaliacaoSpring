package br.sc.senai.avaliacaoSpring.service;

import br.sc.senai.avaliacaoSpring.model.entity.Fornecedor;
import br.sc.senai.avaliacaoSpring.repository.FornecedorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class FornecedorService {
    FornecedorRepository fornecedorRepository;

    public List<Fornecedor> findAll() {
        return fornecedorRepository.findAll();
    }

    public <S extends Fornecedor> S save(S entity) {
        return fornecedorRepository.save(entity);
    }

    public Optional<Fornecedor> findById(Long aLong) {
        return fornecedorRepository.findById(aLong);
    }

    public boolean existsById(Long aLong) {
        return fornecedorRepository.existsById(aLong);
    }

    public void deleteById(Long aLong) {
        fornecedorRepository.deleteById(aLong);
    }
}
