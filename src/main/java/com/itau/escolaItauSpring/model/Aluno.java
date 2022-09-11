package com.itau.escolaItauSpring.model;



import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Audited
public class Aluno {
    @Id
    @GeneratedValue
    @Type(type="org.hibernate.type.UUIDCharType")

    private UUID id;


    @Column(nullable = false, length = 200)
    private String nome;
    private LocalDate dataNascimento;
    @Column(nullable = false, unique = true, length = 11)
    private String cpf;
    private String telefone;
    @Column(nullable = false, unique = true)
    private String email;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ENDERECO_ID")
    private Endereco endereco;

}

