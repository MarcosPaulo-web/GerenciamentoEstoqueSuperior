package com.gerenciamento.estoque.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record EmpresaDto(
        @NotBlank(message = "O nome razão da empresa não pode estar em branco")
        String nmRazao,

        String nmFantasia,

        @NotBlank(message = "O CNPJ da empresa não pode estar em branco")
        String nuCnpj,

        String nuTelefone,

        @NotBlank(message = "A descrição do endereço da empresa não pode estar em branco")
        String dsEndereco,

        @NotBlank(message = "O nome razão da empresa não pode estar em branco")
        String nuEndereco,

        @Pattern(regexp = "^S|N$", message = "Só é possivel salvar a empresa se com 'S' ou 'N' para indicar status")
        String flAtivo

) {
}
