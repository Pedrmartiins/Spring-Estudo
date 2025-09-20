package br.com.aweb.sistema_venda.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "produtos")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "nome é obrigatorio")
    @Column(nullable = false, length = 100)
    private String nome;

    @NotBlank(message = "Descricao e obrigatoria")
    @Column(nullable = false, length = 250)
    private String descricao;

    @NotBlank(message = "preco é obrigatorio")
    @Column(nullable = false)
    @Positive(message = "o valor deve ser maior que zero")

    private BigDecimal preco;
    @NotNull(message = "quantidade é obrigatorio")
    @Column(nullable = false)
    @Positive(message = "o valor deve ser maior ou igual a zero")

    private Integer quantidadeEmEstoque;

}
