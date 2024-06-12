package br.com.acervocesar.controladores;

import br.com.acervocesar.dto.UsuarioDTO;
import br.com.acervocesar.mediator.UsuarioMediator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("usuarios")
public class ControladorUsuario {

    @Autowired
    private UsuarioMediator mediatorUsuario;

    @GetMapping
    public ResponseEntity getTodosUsuarios() {
        return ResponseEntity.ok(mediatorUsuario.getAllUsuarios());
    }

    @GetMapping("/{id}")
    public ResponseEntity getUser(@PathVariable String id) {
        return ResponseEntity.ok(mediatorUsuario.getUsuarioById(id));
    }

    @PostMapping
    public ResponseEntity adicionarUsuario(@RequestBody UsuarioDTO usuario){
        return ResponseEntity.status(201).body(mediatorUsuario.createUsuario(usuario));
    }

    @PostMapping("/{id}/aumentarNivel")
    public ResponseEntity aumentarNivel(@PathVariable String id){
        return ResponseEntity.ok(mediatorUsuario.aumentarNivelUsuarioPorId(id));
    }

    @GetMapping("/rank")
    public ResponseEntity getListarRank(){
        return ResponseEntity.ok(mediatorUsuario.rankGeralPorNivel());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletarProducao(@PathVariable String id){
        if (mediatorUsuario.deleteProducaoById(id)) {
            return ResponseEntity.status(200).body("");
        }
        return ResponseEntity.status(204).body("");
    }
}
