package br.sc.senai.avaliacaoSpring.repository;

import br.sc.senai.avaliacaoSpring.model.entity.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> {
}
