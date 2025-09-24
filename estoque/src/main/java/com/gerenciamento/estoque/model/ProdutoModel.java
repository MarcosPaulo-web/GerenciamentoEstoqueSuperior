package com.gerenciamento.estoque.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name ="TBPRODUTO")
public class ProdutoModel {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CDPRODUTO")
    private Integer cdProduto;

    @Column(name = "NMPRODUTO")
    private String nmProduto;

    @Column(name = "DSPRODUTO")
    private String dsProduto;

    @Column(name = "FLATIVO")
    private String flAtivo;

}
