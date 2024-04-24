package br.com.acervocesar.controladores;

import br.com.acervocesar.entidades.producao.Producao;
import br.com.acervocesar.entidades.usuario.Ocupacao;
import br.com.acervocesar.entidades.usuario.Usuario;
import br.com.acervocesar.repositorios.RepositorioProducoes;
import br.com.acervocesar.repositorios.RepositorioUsuario;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("usuarios")
public class ControladorUsuario {

    @GetMapping
    public ResponseEntity getTodosUsuarios() {

        return ResponseEntity.ok(RepositorioUsuario.all());
    }

    @GetMapping("/{id}")
    public ResponseEntity getUser(@PathVariable int id) {
        return ResponseEntity.ok(RepositorioUsuario.getUsuarioId(id));
    }

    @PostMapping
    public ResponseEntity adicionarUsuarios(@RequestBody Usuario usuario){

        RepositorioUsuario.add(usuario);
        usuario.setId(RepositorioUsuario.all().size());

        return ResponseEntity.ok(usuario);
    }

    @PostMapping("/{id}/producao")
    public ResponseEntity adicionarProducao(@PathVariable int id, @RequestBody Producao producao){
        producao.setUsuario(RepositorioUsuario.getUsuarioId(id));
        RepositorioProducoes.add(producao);
        producao.setId(RepositorioProducoes.all().size());

        return ResponseEntity.ok(producao);
    }
}
