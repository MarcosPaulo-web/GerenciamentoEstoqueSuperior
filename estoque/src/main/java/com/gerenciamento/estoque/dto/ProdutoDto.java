package com.gerenciamento.estoque.dto;

import jakarta.validation.constraints.NotBlank;

public record ProdutoDto(
        @NotBlank(message = "O nome do produto não pode estar em branco")
        String nmProduto,

        String dsProduto,

        @NotBlank(message = "A flag não pode estar ativa")
        String flAtivo

) {
}
