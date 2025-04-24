package br.com.anm.projeto_crud.produtos.Repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.anm.projeto_crud.produtos.Modelo.ProdutoModelo;

@Repository
public interface ProdutoRepositorio extends CrudRepository<ProdutoModelo, Long>{
    
}
