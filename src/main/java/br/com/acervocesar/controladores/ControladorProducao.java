package br.com.acervocesar.controladores;

import br.com.acervocesar.entidades.usuario.Usuario;
import br.com.acervocesar.repositorios.RepositorioProducoes;
import br.com.acervocesar.repositorios.RepositorioUsuario;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("producoes")
public class ControladorProducao {

    @GetMapping
    public ResponseEntity getTodasProducoes() {

        return ResponseEntity.ok(RepositorioProducoes.all());
    }
}
