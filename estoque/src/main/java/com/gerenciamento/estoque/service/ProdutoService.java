package com.gerenciamento.estoque.service;

import com.gerenciamento.estoque.dto.ProdutoDto;
import com.gerenciamento.estoque.model.ProdutoModel;
import com.gerenciamento.estoque.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

   public ProdutoModel salvar(ProdutoDto dto){
        ProdutoModel produto = new ProdutoModel();
        produto.setNmProduto(dto.nmProduto());
        produto.setDsProduto(dto.dsProduto());
        produto.setFlAtivo(dto.flAtivo());
        return repository.save(produto);
    }


    public List<ProdutoModel> listarProdutosAtivos(){
        return repository.findAllByFlAtivo();
    }
    public List<ProdutoModel> listarProdutos(){
        return repository.findAll();
    }
    public Optional<ProdutoModel> getProdutoByCdProduto(Integer cdProduto){
        return repository.findByCdProduto(cdProduto);
    }

    public Optional<ProdutoModel> listarByCdProduto(Integer cdProduto, ProdutoDto dto){
        return repository.findByCdProduto(cdProduto).map(produto -> {
            produto.setNmProduto(dto.nmProduto());
            produto.setDsProduto(dto.dsProduto());
            produto.setFlAtivo(dto.flAtivo());
            return repository.save(produto);
        });
    }


}
