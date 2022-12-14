package com.itau.escolaItauSpring.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Getter
@Setter
@Audited
@AuditTable(value = "endereco_auditoria")
public class Endereco {
    @Id
    @GeneratedValue
    @Type(type="org.hibernate.type.UUIDCharType")
    private UUID id;
    private String logradouro;
    private Long numero;
    private String cep;
    private String complemento;
    private String cidade;
    private String estado;
}
