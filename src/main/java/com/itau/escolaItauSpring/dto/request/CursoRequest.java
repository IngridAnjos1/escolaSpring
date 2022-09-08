package com.itau.escolaItauSpring.dto.request;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class CursoRequest {
    @NotBlank(message = "O nome deve ser informado")
    private String nome;
    private String descricao;

}

