package br.sc.senai.avaliacaoSpring.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "produto")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    @PositiveOrZero
    private Double preco;

    @Column(nullable = false)
    @PositiveOrZero
    private Integer quantidade;

    @ManyToMany(mappedBy = "produtos")
    @JsonIgnore
    private List<Fornecedor> fornecedores;

}
