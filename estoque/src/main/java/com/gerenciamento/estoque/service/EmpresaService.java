package com.gerenciamento.estoque.service;

import com.gerenciamento.estoque.dto.EmpresaDto;
import com.gerenciamento.estoque.model.EmpresaModel;
import com.gerenciamento.estoque.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpresaService {
    //Armazena as regras de negocio
    @Autowired
    private  EmpresaRepository rep;

    public EmpresaModel salvar(EmpresaDto dto){
        EmpresaModel empresa = new EmpresaModel();
        empresa.setNmFantasia(dto.nmFantasia());
        empresa.setNmRazao(dto.nmRazao());
        empresa.setNuCnpj(dto.nuCnpj());
        empresa.setFlAtivo(dto.flAtivo());
        empresa.setDsEndereco(dto.dsEndereco());
        empresa.setNuEndereco(dto.nuEndereco());
        return rep.save(empresa);

    }

    public List<EmpresaModel> listarEmpresasAtivas(){
        return rep.findByFlaAtivo();
    }
    public List<EmpresaModel> listarTodasEmpresas(){
        return rep.findAll();
    }

    public Optional<EmpresaModel> findByCdEmpresa(Integer cd){
        return  rep.findByCdEmpresa(cd);
    }

    public Optional<EmpresaModel> findByNuCnpj(String nuCnpj){
        return  rep.findByNuCnpj(nuCnpj);
    }

    public Optional<EmpresaModel> atualizarDados(Integer cdEmpresa,EmpresaDto dto){

        return rep.findByCdEmpresa(cdEmpresa).map(empresaModel ->
        {empresaModel.setNuCnpj(dto.nuCnpj());
        empresaModel.setNuEndereco(dto.nuEndereco());
        empresaModel.setNmFantasia(dto.nmFantasia());
        empresaModel.setDsEndereco(dto.dsEndereco());
        empresaModel.setNuTelefone(dto.nuTelefone());
        empresaModel.setFlAtivo(dto.flAtivo());
        return rep.save(empresaModel);
        });



    }

    public void deletarEmpresa(Integer cd){
         rep.deleteByCdEmpresa(cd);
    }

}
