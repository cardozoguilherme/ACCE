package br.com.acervocesar.entidades.producao;

import br.com.acervocesar.entidades.usuario.Usuario;
import jakarta.persistence.*;
import lombok.*;

@Entity(name="Producao")  // Nome único da entidade
@Table(name="producao")   // Nome único da tabela
@EqualsAndHashCode(of="id")
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Producao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Use IDENTITY para PostgreSQL
    private int id;

    @ManyToOne
    private Usuario usuarioId;

    private String autor;

    private String coAutores;

    private String tipoProducao;

    private int votosPositivos;

    private int votosNegativos;

    private String titulo;

    private String localDePublicacao;

    private String url;

    public Producao(String autor, String coAutores, String tipoProducao, String titulo, String localDePublicacao, String url) {
        this.autor = autor;
        this.coAutores = coAutores;
        this.tipoProducao = tipoProducao;
        this.titulo = titulo;
        this.localDePublicacao = localDePublicacao;
        this.url = url;
    }
}
