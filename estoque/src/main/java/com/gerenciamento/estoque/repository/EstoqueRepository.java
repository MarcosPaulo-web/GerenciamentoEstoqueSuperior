package com.gerenciamento.estoque.repository;

import com.gerenciamento.estoque.model.EstoqueModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface EstoqueRepository extends JpaRepository<EstoqueModel,Integer> {
    Optional<EstoqueModel> findByCdEstoque(Integer cdEstoque);

        @Query("Select estq FROM EstoqueModel estq WHERE estq.flAtivo = 'S'")
    List<EstoqueModel> findAllByFlAtivo();
}
