package com.gerenciamento.estoque.controller;

import com.gerenciamento.estoque.dto.EmpresaDto;
import com.gerenciamento.estoque.model.EmpresaModel;
import com.gerenciamento.estoque.service.EmpresaService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j// = log for jay , tem uma configuração melhorada de log
@RestController
@RequestMapping("/api/v1/empresa")
@CrossOrigin("*")
public class EmpresaController {
    @Autowired
    private EmpresaService service;

    @PostMapping
    public ResponseEntity<EmpresaModel> save(@RequestBody@Valid EmpresaDto dto){
        EmpresaModel empresa = service.salvar(dto);
        return ResponseEntity.ok(empresa);
    }

    @GetMapping
    public ResponseEntity<List<EmpresaModel>> listarTodos(){
        return ResponseEntity.ok(service.listarTodasEmpresas());
    }

    @GetMapping("/ativas")
    public ResponseEntity<List<EmpresaModel>> listarAtivas(){
        return ResponseEntity.ok(service.listarEmpresasAtivas());
    }

    @GetMapping("/{cdEmpresa}")
    public ResponseEntity<EmpresaModel> listarPorCdEmpresa(@PathVariable Integer cdEmpresa){
        return service.findByCdEmpresa(cdEmpresa)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());

    }
}
