package br.com.acervocesar.utils;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Setter
@Getter
public abstract class Registro implements Serializable {
    private LocalDateTime dhInclusao;

    private LocalDateTime dhUltimaAtualizacao;

    public Registro() {
        dhInclusao = LocalDateTime.now();
    }

    public abstract String getIdUnico();
}