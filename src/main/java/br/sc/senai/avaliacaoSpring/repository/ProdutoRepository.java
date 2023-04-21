package br.sc.senai.avaliacaoSpring.repository;

import br.sc.senai.avaliacaoSpring.model.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
