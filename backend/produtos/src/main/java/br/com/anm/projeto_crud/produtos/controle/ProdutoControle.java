package br.com.anm.projeto_crud.produtos.controle;

import org.springframework.web.bind.annotation.RestController;

import br.com.anm.projeto_crud.produtos.Servico.ProdutoServico;
import br.com.anm.projeto_crud.produtos.modelo.ProdutoModelo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class ProdutoControle {

    @Autowired
    private ProdutoServico ps;
 

    @GetMapping("/listar")
    public Iterable<ProdutoModelo>listar(){
        return ps.listar();

    }

    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrar(@RequestBody ProdutoModelo pm){
        return ps.cadastrarAlterar(pm, "cadastrar");
    }
    
    @PutMapping("/alterar")
    public ResponseEntity<?> alterar(@RequestBody ProdutoModelo pm){
        return ps.cadastrarAlterar(pm, "alterar");
    }

    @GetMapping("/")
    public String rota(){
        return "A API está funcionando!";
    }

}