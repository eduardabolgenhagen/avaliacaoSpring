package br.sc.senai.avaliacaoSpring.repository;

import br.sc.senai.avaliacaoSpring.model.entity.ProdutoPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoPedidoRepository extends JpaRepository<ProdutoPedido, Long> {
}
