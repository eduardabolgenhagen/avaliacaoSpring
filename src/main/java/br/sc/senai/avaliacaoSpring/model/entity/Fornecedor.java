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
@Table(name = "fornecedor")
public class Fornecedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String cnpj;

    @ManyToMany(cascade = CascadeType.ALL)
    @Column(nullable = false)
    private List<Produto> produtos;

    @ManyToMany
    private List<Cliente> clientes;
}
