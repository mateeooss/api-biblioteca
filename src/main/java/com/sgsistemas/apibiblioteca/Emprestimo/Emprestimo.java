package com.sgsistemas.apibiblioteca.Emprestimo;

import com.sgsistemas.apibiblioteca.Leitor.Leitor;
import com.sgsistemas.apibiblioteca.LivroRevistaColletions.Impressos;
import org.apache.logging.log4j.spi.CleanableThreadContextMap;

import javax.persistence.*;
import java.util.Calendar;

@Entity
public class Emprestimo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "leitor_id")
    private Leitor leitor;
    @OneToOne
    @JoinColumn(name = "impressos_id")
    private Impressos impressos;
    private Calendar dataDoEmprestimo;
    private Calendar dataParaEntrega;
    private boolean emprestimoSituacao= false;
    private double multa;

    public Emprestimo() {

    }

    public double getMulta() {
        return multa;
    }

    public void setMulta(double multa) {
        this.multa = multa;
    }

    public Emprestimo(Leitor leitor, Impressos impressos, Calendar dataDoEmprestimo, Calendar dataParaEntrega) {
        this.leitor = leitor;
        this.impressos = impressos;
        this.dataDoEmprestimo = dataDoEmprestimo;
        this.dataParaEntrega = dataParaEntrega;
        this.emprestimoSituacao = emprestimoSituacao;
        this.multa = multa;
    }

    public Long getId() {
        return id;
    }

    public Leitor getLeitor() {
        return leitor;
    }

    public void setLeitor(Leitor leitor) {
        this.leitor = leitor;
    }

    public Impressos getImpressos() {
        return impressos;
    }

    public void setImpressos(Impressos impressos) {
        this.impressos = impressos;
    }

    public Calendar getDataDoEmprestimo() {
        return dataDoEmprestimo;
    }

    public void setDataDoEmprestimo(Calendar dataDoEmprestimo) {
        this.dataDoEmprestimo = dataDoEmprestimo;
    }

    public Calendar getDataParaEntrega() {
        return dataParaEntrega;
    }

    public void setDataParaEntrega(Calendar dataParaEntrega) {
        this.dataParaEntrega = dataParaEntrega;
    }

    public boolean isEmprestimoSituacao() {
        return emprestimoSituacao;
    }

    public void setEmprestimoSituacao(boolean emprestimoSituacao) {
        this.emprestimoSituacao = emprestimoSituacao;
    }
}
