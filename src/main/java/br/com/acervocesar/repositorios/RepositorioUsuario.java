package br.com.acervocesar.repositorios;

import br.com.acervocesar.entidades.producao.Producao;
import br.com.acervocesar.entidades.usuario.Usuario;

import java.util.ArrayList;
import java.util.List;

public class RepositorioUsuario {
    static private List<Usuario> listaUsuarios = new ArrayList<>();

    static public void add(Usuario usuario) {
        listaUsuarios.add(usuario);
    }

    static public List<Usuario> all() {
        return listaUsuarios;
    }

    static public Usuario getUsuarioId(int id) {
        for(Usuario usuario : listaUsuarios) {
            if(usuario.getId() == id) {
                return usuario;
            }
        }
        return null;
    }
    static public void remover(Usuario producao) {
        listaUsuarios.remove(producao);
    }
}
