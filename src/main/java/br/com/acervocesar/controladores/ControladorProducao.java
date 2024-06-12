package br.com.acervocesar.controladores;

import br.com.acervocesar.dto.ProducaoDTO;
import br.com.acervocesar.entidade.producao.Producao;
import br.com.acervocesar.mediator.MediatorProducao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("producoes")
public class ControladorProducao {

    @Autowired
    MediatorProducao mediatorProducao = new MediatorProducao();

    @GetMapping
    public ResponseEntity getTodasProducoes() {
        return ResponseEntity.ok(mediatorProducao.getAllProducoes());
    }

    @PostMapping("/{id}")
    public ResponseEntity adicionarProducao(@PathVariable String id, @RequestBody ProducaoDTO producao){
        return ResponseEntity.status(201).body(mediatorProducao.createProducao(producao, id));
    }

    @GetMapping("/{id}")
    public ResponseEntity getProducoesPorIdDoCriador(@PathVariable String id) {

        Producao[] producao = mediatorProducao.getAllProducoes();

        ArrayList<Producao> producaoFiltrada = new ArrayList();
        for (Producao p : producao) {
            if (p.getUsuarioId().equals(id)) {
                producaoFiltrada.add(p);
            }
        }
        return ResponseEntity.ok(producaoFiltrada);
    }

    @GetMapping("/pesquisar/{tag}")
    public ResponseEntity getArtigoByTag(@PathVariable String tag) {

        Producao[] producao = mediatorProducao.getAllProducoes();

        ArrayList<Producao> producaoFiltrada = new ArrayList();
        for (Producao p : producao) {
            for (String tagLocal: p.getTags()) {
                if (tagLocal.trim().equalsIgnoreCase(tag)) {
                    producaoFiltrada.add(p);
                    break;
                }
            }
        }
        return ResponseEntity.ok(producaoFiltrada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletarUsuario(@PathVariable String id){
        if (mediatorProducao.deleteProducaoById(id)) {
            return ResponseEntity.status(200).body("");
        }
        return ResponseEntity.status(204).body("");
    }
}
