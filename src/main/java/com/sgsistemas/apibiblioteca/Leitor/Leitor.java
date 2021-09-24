package com.sgsistemas.apibiblioteca.Leitor;

import javax.persistence.*;

@Entity
public class Leitor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "leitor_id")
    private Long id;
    private String nome;
    private String cpf;

    public Leitor() {
    }

    public Leitor(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }
}
