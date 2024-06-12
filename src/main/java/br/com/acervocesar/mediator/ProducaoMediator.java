package br.com.acervocesar.mediator;

import br.com.acervocesar.dto.ProducaoDTO;
import br.com.acervocesar.entidade.producao.Producao;
import br.com.acervocesar.dao.ProducaoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProducaoMediator {

    @Autowired
    private ProducaoDAO producaoDao;

    @Autowired
    private UsuarioMediator usuarioMediator;

    // Retrieve all users
    public Producao[] getAllProducoes() {
        return producaoDao.buscarTodos();
    }

    // Retrieve a user by ID
    public Producao getProducaoById(String id) {
        return producaoDao.buscar(id);
    }

    // Create a new user
    public String createProducao(ProducaoDTO producaoDTO, String id) {
        UUID uuid = UUID.randomUUID();
        Producao producao = new Producao(uuid.toString(), id, producaoDTO.coAutores(), producaoDTO.tipoProducao(), 0, 0, producaoDTO.tags(), producaoDTO.titulo(), producaoDTO.localDePublicacao(), producaoDTO.url());

        if (!producaoDao.incluir(producao)) {
            return "Não foi possível incluir a produção no banco de dados.";
        }

        return null;
    }

    public boolean aumentarVotosPositivosPorId(String id) {
        Producao producao = producaoDao.buscar(id);
        if (producao != null) {
            producao.setVotosPositivos(producao.getVotosPositivos() + 1);

            usuarioMediator.aumentarEXPUsuarioPorId(producao.getUsuarioId(), 50);

            producaoDao.alterar(producao);
            return true;
        }
        return false;
    }

    public boolean aumentarVotosNegativosPorId(String id) {
        Producao producao = producaoDao.buscar(id);
        if (producao != null) {
            producao.setVotosNegativos(producao.getVotosNegativos() + 1);

            producaoDao.alterar(producao);
            return true;
        }
        return false;
    }

    // Update an existing user
    public boolean updateProducao(Producao producaoAtualizada) {
        return producaoDao.alterar(producaoAtualizada);
    }

    // Delete a user by ID
    public boolean deleteProducaoById(String id) {
        return producaoDao.excluir(id);
    }
}
