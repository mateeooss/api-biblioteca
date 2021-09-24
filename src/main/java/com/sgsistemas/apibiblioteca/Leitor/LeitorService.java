package com.sgsistemas.apibiblioteca.Leitor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeitorService {
    @Autowired
    LeitorRepository leitorRepository;

    public void save(Leitor leitor) {
        leitorRepository.save(leitor);
    }

    public List<Leitor> findAll(){
        return leitorRepository.findAll();
    }

    public Leitor findById(Long id){
       return  leitorRepository.getById(id);
    }
}
