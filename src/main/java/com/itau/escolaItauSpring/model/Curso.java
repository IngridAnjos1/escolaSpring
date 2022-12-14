package com.itau.escolaItauSpring.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;


@Entity
@Getter @Setter
public class Curso {
    @Id
    @GeneratedValue
    @Type(type="org.hibernate.type.UUIDCharType")
    private UUID id;
    @Column(nullable = false, unique = true)
    private String nome;
    private String descricao;


    // Turno -> ENUM

    // Carga Horária
    // Data término
    // Ementa -> OUTRO OBJETO
}
