package br.com.acervocesar.entidade.producao;

import br.com.acervocesar.entidade.usuario.Usuario;
import br.com.acervocesar.utils.Registro;
import lombok.*;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Producao extends Registro {
    private String id;

    private String usuarioId;

    private String coAutores;

    private String tipoProducao;

    private int votosPositivos;

    private int votosNegativos;

    private String[] tags;

    private String titulo;

    private String localDePublicacao;

    private String url;

    @Override
    public String getIdUnico() {
        return id;
    }
}
