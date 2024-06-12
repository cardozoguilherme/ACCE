package br.com.acervocesar.utils;

public abstract class SuperDAO {
    protected DAOGenerico daoGenerico;

    public SuperDAO() {
        this.daoGenerico = new DAOGenerico(obterTipo());
    }

    public abstract Class<?> obterTipo();
}