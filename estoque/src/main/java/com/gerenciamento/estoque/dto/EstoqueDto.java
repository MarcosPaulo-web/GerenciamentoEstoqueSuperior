package com.gerenciamento.estoque.dto;

import jakarta.validation.constraints.*;

public record EstoqueDto(

        @NotNull(message = "O código do local estoque não pode ser nullo")
        Integer cdLocalEstoque,

        @Min(value = 0,message = "A quantidade não pode ser menor que zero")
        Integer qtdEstoque,

        @NotBlank(message = "A flag não pode ser nulla")
        @Pattern(regexp = "^S|N$", message = "Só é possivel salvar o estoque se com 'S' ou 'N' para indicar status")
        String flAtivo
) {
}
