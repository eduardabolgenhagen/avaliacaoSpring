package br.sc.senai.avaliacaoSpring.repository;

import br.sc.senai.avaliacaoSpring.model.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
