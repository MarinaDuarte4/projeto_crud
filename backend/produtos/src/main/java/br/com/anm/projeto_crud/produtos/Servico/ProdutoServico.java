package br.com.anm.projeto_crud.produtos.Servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.anm.projeto_crud.produtos.Repositorio.ProdutoRepositorio;
import br.com.anm.projeto_crud.produtos.modelo.ProdutoModelo;
import br.com.anm.projeto_crud.produtos.modelo.RespostaModelo;

@Service
public class ProdutoServico {
    
    @Autowired
    private ProdutoRepositorio pr;

    private RespostaModelo rm;

    //Listar produto
    public Iterable<ProdutoModelo> listar(){
        return pr.findAll();

    }

    public ResponseEntity <?> cadastrarAlterar(ProdutoModelo pm, String acao){
        if(pm.getNome().equals("")){
            rm.setResposta("O nome do produto é obrigatório!");
            return new ResponseEntity<RespostaModelo>(rm, HttpStatus.BAD_REQUEST);
        }else if(pm.getMarca().equals("")){
            rm.setResposta("A marca do produto é obrigatório!");
            return new ResponseEntity<RespostaModelo>(rm,HttpStatus.BAD_REQUEST);
        }else{
            if(acao.equals("cadastrar")){
                return new ResponseEntity<ProdutoModelo>(pr.save(pm), HttpStatus.CREATED);
            }else{
                return new ResponseEntity<ProdutoModelo>(pr.save(pm), HttpStatus.OK);
                
            }
        }
    }

    //Cadastrar produtos
    public ResponseEntity<?> cadastrar(ProdutoModelo pm){
        if (pm.getNome().equals("")){
            rm.setResposta("O nome do produto é obrigatório!");
            return new ResponseEntity<RespostaModelo>(rm,HttpStatus.BAD_REQUEST);
        }else if (pm.getMarca().equals("")){
            rm.setResposta("O nome da marca do produto é obrigatório!");
            return new ResponseEntity<RespostaModelo>(rm,HttpStatus.BAD_REQUEST);
        }else{
            return new ResponseEntity<ProdutoModelo>(pr.save(pm) ,HttpStatus.CREATED);
        }
}
}