package br.sc.senai.avaliacaoSpring.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "endereco_entrega")
public class EnderecoEntrega {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Endereco endereco;

    @OneToOne(mappedBy = "endereco")
    private Pedido pedido;
}
