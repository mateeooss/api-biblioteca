package com.sgsistemas.apibiblioteca.LivroRevistaColletions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImpressosService {
    @Autowired
    ImpressosRepository impressosRepository;

    public List<Impressos> findAll() {
        return impressosRepository.findAll();
    }

    public void salvar(Impressos impressos) throws Exception {
        impressos.setQuantidadeDisponivel(impressos.getQuantidadeTotal());
        impressosRepository.save(impressos);
    }

    public List<Impressos>  findByIsbn(String isbn){
        return (List<Impressos>) impressosRepository.findByisbn(isbn);
    }


    public void adicionaUnidades(Long id, int qtd) {
       Impressos impressos = impressosRepository.getById(id);
       impressos.setQuantidadeTotal(qtd);
       impressos.setQuantidadeDisponivel(qtd);
    }

    public Impressos findById(Long id) {
        return impressosRepository.getById(id);
    }
}
