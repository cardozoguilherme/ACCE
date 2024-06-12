package br.com.acervocesar.entidade.usuario;

import br.com.acervocesar.utils.Registro;
import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Usuario extends Registro {
    private String id;

    private String nome;

    private String sobrenome;

    private String email;

    private String fotoPerfil;

    private String idLattes;

    private String ocupacao;

    private String senha;

    private int nivel;

    @Override
    public String getIdUnico() {
        return id;
    }
}
