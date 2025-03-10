package br.com.anm.projeto_crud.produtos.Servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.anm.projeto_crud.produtos.Repositorio.ProdutoRepositorio;
import br.com.anm.projeto_crud.produtos.modelo.ProdutoModelo;

@Service
public class ProdutoServico {
    
    @Autowired
    private ProdutoRepositorio pr;

    public Iterable<ProdutoModelo> listar(){
        return pr.findAll();

    }
}
