package br.com.acervocesar.controladores;

import br.com.acervocesar.entidades.producao.Producao;
import br.com.acervocesar.repositorios.RepositorioProducoes;
import br.com.acervocesar.repositorios.RepositorioUsuario;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("producoes")
public class ControladorProducao {

    @GetMapping
    public ResponseEntity getTodasProducoes() {
        return ResponseEntity.ok("teste");
    }

    @PostMapping("/{id}")
    public ResponseEntity adicionarProducao(@PathVariable int id, @RequestBody Producao producao){
        return ResponseEntity.ok("teste");
    }
}
