package br.com.acervocesar.dao;

import br.com.acervocesar.entidade.usuario.Usuario;
import br.com.acervocesar.utils.Registro;
import br.com.acervocesar.utils.SuperDAO;
import org.springframework.stereotype.Service;

@Service
public class UsuarioDAO extends SuperDAO {

    @Override
    public Class<?> obterTipo() {
        return Usuario.class;
    }

    public Usuario buscar(String id) {
        return (Usuario) daoGenerico.buscar(id);
    }

    public boolean incluir(Usuario usuario) {
        return daoGenerico.incluir(usuario);
    }

    public boolean alterar(Usuario usuario) {
        return daoGenerico.alterar(usuario);
    }

    public boolean excluir(String id) {
        return daoGenerico.excluir(id);
    }

    public Usuario[] buscarTodos() {
        Registro[] registros = daoGenerico.buscarTodos();
        if (registros == null) {
            return null;
        }
        Usuario[] clientes = new Usuario[registros.length];
        for (int i = 0; i < registros.length; i++) {
            clientes[i] = (Usuario) registros[i];
        }
        return clientes;
    }
}
