package com.gerenciamento.estoque.repository;

import com.gerenciamento.estoque.model.EmpresaModel;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface EmpresaRepository extends JpaRepository<EmpresaModel,Integer> {
    Optional<EmpresaModel> findByCdEmpresa(Integer cdEmpresa);
    Optional<EmpresaModel> findByNuCnpj(String nuCnpj);

    @Query("SELECT emp FROM EmpresaModel emp Where emp.flAtivo = 'S'")
    List<EmpresaModel> findByFlaAtivo();

    @Transactional
    Optional<EmpresaModel> deleteByCdEmpresa(Integer cdEmpresa);

}
