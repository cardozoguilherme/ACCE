package br.com.acervocesar.dto;

public record ProducaoDTO(
        String coAutores,
        String tipoProducao,
        String[] tags,
        String titulo,
        String localDePublicacao,
        String url
) { }
