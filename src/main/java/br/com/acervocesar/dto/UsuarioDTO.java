package br.com.acervocesar.dto;

public record UsuarioDTO(
    String nome,
    String sobrenome,
    String email,
    String fotoPerfil,
    String idLattes,
    String ocupacao,
    String senha
) { }
