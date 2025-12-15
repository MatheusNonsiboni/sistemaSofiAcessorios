package com.example.sistema.Model;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dataHora = LocalDateTime.now(); // Pega data e hora atuais

    @Column(nullable = false)
    private BigDecimal valorTotal;

    @Enumerated(EnumType.STRING) // Grava "PIX" no banco ao invés de um número 0 ou 1
    private FormaPagamento formaPagamento;

    // Relacionamento: Uma Venda tem Vários Itens
    // 'mappedBy' diz que o dono da relação é o campo 'venda' lá na classe ItemVenda
    // 'CascadeType.ALL' significa: Se eu salvar a Venda, o Java salva os Itens automaticamente
    @OneToMany(mappedBy = "venda", cascade = CascadeType.ALL)
    private List<ItemVenda> itens;
}
