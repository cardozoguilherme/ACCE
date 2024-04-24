package br.com.acervocesar.entidades.producao;

import br.com.acervocesar.entidades.usuario.Usuario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Producao {

    private int id;

    private Usuario usuario;

    private String autor;

    private String coAutores;

    private TipoProducao tipoProducao;

    private String titulo;

    private String localDePublicacao;

    private String url;

    public Producao(String autor,String coAutores, TipoProducao tipoProducao, String titulo, String localDePublicacao, String url) {
        this.autor = autor;
        this.coAutores = coAutores;
        this.tipoProducao = tipoProducao;
        this.titulo = titulo;
        this.localDePublicacao = localDePublicacao;
        this.url = url;
    }
}
