package br.com.acervocesar.entidades.producao;

public enum TipoProducao {
    PRODUCAO_BIBLIOGRAFICA("Produção Bibliográfica"),
    PRODUCAO_TECNICA("Produção Técnica");

    private String tipoProducao;

    TipoProducao(String tipoProducao){
        this.tipoProducao = tipoProducao;
    }

    public String getTipoProducao(){
        return tipoProducao;
    }
}
