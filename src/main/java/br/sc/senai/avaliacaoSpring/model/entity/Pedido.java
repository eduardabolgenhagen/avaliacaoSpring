package br.sc.senai.avaliacaoSpring.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "pedido")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Verificar se é maior que 0
    @Column(nullable = false)
    private Double valorTotal;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pedido")
    private List<ProdutoPedido> produtos;

    @OneToOne
    private Cliente cliente;

    @OneToOne(cascade = CascadeType.ALL)
    private EnderecoEntrega endereco;
}
