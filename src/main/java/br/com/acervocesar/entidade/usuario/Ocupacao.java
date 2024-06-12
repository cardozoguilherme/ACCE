package br.com.acervocesar.entidade.usuario;

public enum Ocupacao {
    ESTUDANTE("Estudante"),
    COLABORADOR("Colaborador(a)");

    private String ocupacao;

    Ocupacao(String ocupacao) {
        this.ocupacao = ocupacao;
    }

    public String getOcupacao() {
        return ocupacao;
    }
}
