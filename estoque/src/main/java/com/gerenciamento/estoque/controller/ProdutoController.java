package com.gerenciamento.estoque.controller;

import com.gerenciamento.estoque.dto.ProdutoDto;
import com.gerenciamento.estoque.model.ProdutoModel;
import com.gerenciamento.estoque.service.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @PostMapping
    public ResponseEntity<ProdutoModel> save(@Valid @RequestBody ProdutoDto dto) {
        return ResponseEntity.ok(service.salvar(dto));
    }

    @GetMapping
    public ResponseEntity<List<ProdutoModel>> getAllProdutos() {
        return ResponseEntity.ok(service.listarProdutos());
    }
    @GetMapping("/ativos")
    public ResponseEntity<List<ProdutoModel>> getAllProdutosAtivos() {
        return ResponseEntity.ok(service.listarProdutosAtivos());
    }

    @GetMapping("/cdProduto")
    ResponseEntity<ProdutoModel> listarPorCdProduto(@PathVariable Integer cdProduto){
        return service.getProdutoByCdProduto(cdProduto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());

    }
}
