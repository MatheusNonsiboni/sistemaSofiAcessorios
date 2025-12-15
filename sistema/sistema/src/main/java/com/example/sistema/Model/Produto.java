package com.example.sistema.Model;

import jakarta.persistence.*;
import lombok.Data; 
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    private String descricao;

    @Column(nullable = false)
    private BigDecimal precoCusto;

    @Column(nullable = false)
    private BigDecimal precoVenda;

    @Column(nullable = false)
    private Integer quantidadeEstoque;

    private String categoria;

    private LocalDate dataCadastro = LocalDate.now();
}
