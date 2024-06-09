package br.com.acervocesar.entidades.usuario;

import jakarta.persistence.*;
import lombok.*;

@Entity(name="Usuario")  // Nome único da entidade
@Table(name="usuario")   // Nome único da tabela
@EqualsAndHashCode(of="id")
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Use IDENTITY para PostgreSQL
    private int id;

    private String nome;

    private String sobrenome;

    private String email;

    private String idLattes;

    private String ocupacao;

    private String senha;

    private int nivel;

    public Usuario(String nome, String sobrenome, String email, String idLattes, String ocupacao, String fotoPerfil, String senha, int nivel) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.idLattes = idLattes;
        this.ocupacao = ocupacao;
        this.senha = senha;
        this.nivel = nivel;
    }
}
