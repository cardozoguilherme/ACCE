package br.com.acervocesar.mediator;

import br.com.acervocesar.dao.UsuarioDAO;
import br.com.acervocesar.dto.UsuarioDTO;
import br.com.acervocesar.entidade.usuario.Usuario;
import br.com.acervocesar.utils.ComparadorUsuarioNivel;
import br.com.acervocesar.utils.Registro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Service
public class UsuarioMediator {

    @Autowired
    private UsuarioDAO usuarioDAO;

    // Retrieve all users
    public Usuario[] getAllUsuarios() {
        return usuarioDAO.buscarTodos();
    }

    // Retrieve a user by ID
    public Usuario getUsuarioById(String id) {
        return usuarioDAO.buscar(id);
    }

    // Create a new user
    public String createUsuario(UsuarioDTO usuarioDTO) {
        UUID uuid = UUID.randomUUID();
        ArrayList<String> conquistas = new ArrayList();
        Usuario usuario = new Usuario(uuid.toString(), usuarioDTO.nome(), usuarioDTO.sobrenome(), usuarioDTO.email(), usuarioDTO.fotoPerfil(), usuarioDTO.idLattes(), usuarioDTO.ocupacao(), usuarioDTO.senha(), conquistas, 0, 0);

        if (!usuarioDAO.incluir(usuario)) {
            return "Não foi possível incluir o usuário no banco de dados.";
        }

        return null;
    }

    // Update an existing user
    public boolean updateUsuario(Usuario usuarioAtualizado) {
        return usuarioDAO.alterar(usuarioAtualizado);
    }

    public boolean aumentarEXPUsuarioPorId(String id, int exp) {
        Usuario usuario = usuarioDAO.buscar(id);
        if (usuario != null) {
            usuario.setExp(usuario.getExp() + exp);
            usuarioDAO.alterar(usuario);

            if (usuario.getExp() >= 100) {
                aumentarNivelUsuarioPorId(id);
                usuario.setExp(0);
                usuarioDAO.alterar(usuario);
            }

            return true;
        }
        return false;
    }

    public boolean aumentarNivelUsuarioPorId(String id) {
        Usuario usuario = usuarioDAO.buscar(id);
        if (usuario != null) {

            usuario.setNivel(usuario.getNivel() + 1);

            if (usuario.getNivel() == 100) {
                usuario.adicionarConquista("Prêmio ACCE Bronze");
            } else if (usuario.getNivel() == 300) {
                usuario.adicionarConquista("Prêmio ACCE Prata");
            } else if (usuario.getNivel() == 500) {
                usuario.adicionarConquista("Prêmio ACCE Ouro");
            }

            usuarioDAO.alterar(usuario);

            return true;
        }
        return false;
    }

    // Delete a user by ID
    public boolean deleteProducaoById(String id) {
        return usuarioDAO.excluir(id);
    }

    public List<Usuario> rankGeralPorNivel() {
        List<Usuario> contas = new ArrayList<Usuario>();
        Registro[] regs = usuarioDAO.buscarTodos();
        for (Registro registro : regs) {
            contas.add((Usuario) registro);
        }
        Collections.sort(contas, new ComparadorUsuarioNivel());
        return contas;
    }
}