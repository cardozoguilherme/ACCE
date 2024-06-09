package br.com.acervocesar.controladores;

import br.com.acervocesar.entidades.producao.Producao;
import br.com.acervocesar.entidades.usuario.Usuario;
import br.com.acervocesar.repositorios.RepositorioProducoes;
import br.com.acervocesar.repositorios.RepositorioUsuario;
import br.com.acervocesar.servicos.ServicoUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("usuarios")
public class ControladorUsuario {

    @Autowired
    private ServicoUsuario servicoUsuario;

    @GetMapping
    public ResponseEntity getTodosUsuarios() {
        return ResponseEntity.ok(servicoUsuario.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity getUser(@PathVariable int id) {
        return ResponseEntity.ok(servicoUsuario.getUserById(id));
    }

    @PostMapping
    public ResponseEntity adicionarUsuario(@RequestBody Usuario usuario){
        return ResponseEntity.ok("teste");
    }
}
