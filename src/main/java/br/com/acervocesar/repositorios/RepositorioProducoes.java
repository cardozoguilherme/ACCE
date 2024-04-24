package br.com.acervocesar.repositorios;

import br.com.acervocesar.entidades.producao.Producao;

import java.util.ArrayList;
import java.util.List;

public class RepositorioProducoes {
    static private List<Producao> listaProducoes = new ArrayList<>();

    static public void add(Producao producao) {
        listaProducoes.add(producao);
    }

    static public List<Producao> all() {
        return listaProducoes;
    }

    static public Producao getId(int id) {
        for(Producao producao : listaProducoes) {
            if(producao.getId() == id) {
                return producao;
            }
        }
        return null;
    }
    static public void remover(Producao producao) {
        listaProducoes.remove(producao);
    }
}
