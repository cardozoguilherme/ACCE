package br.com.acervocesar.entidade.usuario;

import br.com.acervocesar.utils.Registro;
import lombok.*;

import java.util.ArrayList;

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

    private ArrayList<String> conquistas = new ArrayList<>();

    private int nivel;

    private int exp;

    public void adicionarConquista(String conquista) {
        conquistas.add(conquista);
    }

    @Override
    public String getIdUnico() {
        return id;
    }
}
