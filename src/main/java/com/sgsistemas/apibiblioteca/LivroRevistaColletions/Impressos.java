package com.sgsistemas.apibiblioteca.LivroRevistaColletions;

import javax.persistence.*;

@Entity
public class Impressos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "impressos_id")
    private Long id;
    private String nome;
    private String autor;
    private String isbn;
    private int quantidadeTotal;
    private int quantidadeDisponivel;
    private Tipo tipo;


    public Impressos() {
    }

    public Tipo getTipo() {
        return tipo;
    }

    public Impressos(String nome, String autor, String isbn, int quantidadeTotal, int quantidadeDisponivel, Tipo tipo) {
        this.nome = nome;
        this.autor = autor;
        this.isbn = isbn;
        this.quantidadeTotal = quantidadeTotal;
        this.quantidadeDisponivel = quantidadeDisponivel;
        this.tipo = tipo;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getQuantidadeTotal() {
        return quantidadeTotal;
    }

    public void setQuantidadeTotal(int quantidadeTotal) {
        this.quantidadeTotal =+ quantidadeTotal;
    }

    public int getQuantidadeDisponivel() {
        return quantidadeDisponivel;
    }

    public void setQuantidadeDisponivel(int quantidadeDisponivel) {
        this.quantidadeDisponivel =+ quantidadeDisponivel;
    }
}
