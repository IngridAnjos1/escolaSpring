package com.itau.escolaItauSpring.dto.response;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;


@Data
public class AlunoResponse {
    private UUID id;
    private String nome;
    private LocalDate dataNascimento;
    private String telefone;
    private String email;
}
