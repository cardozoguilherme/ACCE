package br.com.acervocesar.dao;

import br.com.acervocesar.entidade.producao.Producao;
import br.com.acervocesar.utils.Registro;
import br.com.acervocesar.utils.SuperDAO;
import org.springframework.stereotype.Service;

@Service
public class ProducaoDAO extends SuperDAO {

    @Override
    public Class<?> obterTipo() {
        return Producao.class;
    }

    public Producao buscar(String id) {
        return (Producao) daoGenerico.buscar(id);
    }

    public boolean incluir(Producao producao) {
        return daoGenerico.incluir(producao);
    }

    public boolean alterar(Producao producao) {
        return daoGenerico.alterar(producao);
    }

    public boolean excluir(String id) {
        return daoGenerico.excluir(id);
    }

    public Producao[] buscarTodos() {
        Registro[] registros = daoGenerico.buscarTodos();

        if (registros == null) {
            return null;
        }

        Producao[] producoes = new Producao[registros.length];
        for (int i = 0; i < registros.length; i++) {
            producoes[i] = (Producao) registros[i];
        }
        return producoes;
    }
}
