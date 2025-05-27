package br.com.anm.projeto_crud.crud_produtos.controle;

import org.springframework.web.bind.annotation.RestController;

import br.com.anm.projeto_crud.crud_produtos.modelo.ProdutoModelo;
import br.com.anm.projeto_crud.crud_produtos.modelo.RespostaModelo;
import br.com.anm.projeto_crud.crud_produtos.servico.ProdutoServico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@CrossOrigin(origins = "*")
public class ProdutoControle {
    //Injeção de dependências
    @Autowired
    private ProdutoServico ps;

    @GetMapping("/listar")
    public Iterable<ProdutoModelo> listar(){
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

    @DeleteMapping("/remover/{codigo}")
    public ResponseEntity<RespostaModelo> remover(@PathVariable long codigo){
        return ps.remover(codigo);
    }

    @GetMapping("/")
    public String rota(){
        return "A API está funcionando!";
    }
}