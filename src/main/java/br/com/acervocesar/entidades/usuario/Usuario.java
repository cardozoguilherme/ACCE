package br.com.acervocesar.entidades.usuario;


import br.com.acervocesar.entidades.producao.Producao;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Usuario {

    private int id;

    private String nome;

    private String sobrenome;

    private String email;

    private String idLattes;

    private Ocupacao ocupacao;

    private String fotoPerfil;

    private String senha;

    private int nivel;

    public Usuario(String nome, String sobrenome, String email, String idLattes, Ocupacao ocupacao, String fotoPerfil, String senha, int nivel) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.idLattes = idLattes;
        this.ocupacao = ocupacao;
        this.fotoPerfil = fotoPerfil;
        this.senha = senha;
        this.nivel = nivel;
    }
}
