package com.gerenciamento.estoque.controller;

import com.gerenciamento.estoque.dto.EstoqueDto;
import com.gerenciamento.estoque.model.EstoqueModel;
import com.gerenciamento.estoque.service.EstoqueService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/estoque")
@CrossOrigin("*")
public class EstoqueController {

    @Autowired
    private EstoqueService service;

    @PostMapping
    public ResponseEntity<EstoqueModel> salvarEstoque(@RequestBody@Valid EstoqueDto dto){
        return ResponseEntity.ok(service.salvar(dto));
    }

    @GetMapping("/ativos")
    public ResponseEntity<List<EstoqueModel>> getAllEstoquesAtivos(){
        return ResponseEntity.ok(service.listarEstoqueAtivos());
    }
    
    @GetMapping
    public ResponseEntity<List<EstoqueModel>> listarTodosEstoques(){
        return ResponseEntity.ok(service.listarTodosEstoques());
    }

    @GetMapping("{cdEstoque}")
    public ResponseEntity<EstoqueModel> editarEstoque(@PathVariable Integer cdEstoque){
        return service.findByCdEstoque(cdEstoque)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}
