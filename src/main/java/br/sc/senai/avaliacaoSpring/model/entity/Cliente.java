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
@Table(name = "cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    // Valida se o email é único e contém a formatação correta
    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String telefone;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Endereco> enderecos;

    @OneToOne(cascade = CascadeType.ALL)
    private CartaoCredito cartao;
}
