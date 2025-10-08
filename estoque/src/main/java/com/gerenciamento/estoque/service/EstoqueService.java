package com.gerenciamento.estoque.service;

import com.gerenciamento.estoque.dto.EmpresaDto;
import com.gerenciamento.estoque.dto.EstoqueDto;
import com.gerenciamento.estoque.model.EstoqueModel;
import com.gerenciamento.estoque.repository.EstoqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstoqueService {

    @Autowired
    private EstoqueRepository repository;

    public EstoqueModel salvar(EstoqueDto dto){
        EstoqueModel estoqueModel = new EstoqueModel();
        estoqueModel.setCdLocalEstoque(dto.cdLocalEstoque());
        estoqueModel.setQtdEstoque(dto.qtdEstoque());
        estoqueModel.setFlAtivo(dto.flAtivo());
        return repository.save(estoqueModel);
    }

    public List<EstoqueModel> listarEstoqueAtivos(){
        return repository.findAllByFlAtivo();
    }

    public Optional<EstoqueModel> findByCdEstoque(Integer cdEstoque){
        return repository.findByCdEstoque(cdEstoque);
    }

    public Optional<EstoqueModel> atualizarDados(Integer cdEstoque,EstoqueDto dto){
       return repository.findByCdEstoque(cdEstoque).map(estoqueModel ->
       {   estoqueModel.setCdLocalEstoque(dto.cdLocalEstoque());
           estoqueModel.setQtdEstoque(dto.qtdEstoque());
           estoqueModel.setFlAtivo(dto.flAtivo());
           return repository.save(estoqueModel);
       });
    }

    public List<EstoqueModel> listarTodosEstoques(){
        return repository.findAll();
    }

}
