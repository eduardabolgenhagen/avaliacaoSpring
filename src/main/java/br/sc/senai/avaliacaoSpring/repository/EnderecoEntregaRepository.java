package br.sc.senai.avaliacaoSpring.repository;

import br.sc.senai.avaliacaoSpring.model.entity.EnderecoEntrega;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoEntregaRepository extends JpaRepository<EnderecoEntrega, Long> {
}
