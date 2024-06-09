package br.com.acervocesar.servicos;

import br.com.acervocesar.entidades.usuario.Usuario;
import br.com.acervocesar.repositorios.RepositorioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicoUsuario {

    @Autowired
    private RepositorioUsuario repositorioUsuario;

    // Retrieve all users
    public List<Usuario> getAllUsers() {
        return repositorioUsuario.findAll();
    }

    // Retrieve a user by ID
    public Optional<Usuario> getUserById(int id) {
        return repositorioUsuario.findById(id);
    }

    // Create a new user
    public Usuario createUser(Usuario usuario) {
        return repositorioUsuario.save(usuario);
    }

    // Update an existing user
    public Usuario updateUser(int id, Usuario usuarioAtualizado) {
        Optional<Usuario> optionalUsuario = repositorioUsuario.findById(id);
        if (optionalUsuario.isPresent()) {
            Usuario usuarioExistente = optionalUsuario.get();
            usuarioExistente.setNome(usuarioAtualizado.getNome());
            usuarioExistente.setSobrenome(usuarioAtualizado.getSobrenome());
            usuarioExistente.setEmail(usuarioAtualizado.getEmail());
            usuarioExistente.setIdLattes(usuarioAtualizado.getIdLattes());
            usuarioExistente.setOcupacao(usuarioAtualizado.getOcupacao());
            usuarioExistente.setSenha(usuarioAtualizado.getSenha());
            usuarioExistente.setNivel(usuarioAtualizado.getNivel());
            return repositorioUsuario.save(usuarioExistente);
        } else {
            throw new RuntimeException("Usuário não encontrado com o ID: " + id);
        }
    }

    // Delete a user by ID
    public void deleteUser(int id) {
        repositorioUsuario.deleteById(id);
    }
}
