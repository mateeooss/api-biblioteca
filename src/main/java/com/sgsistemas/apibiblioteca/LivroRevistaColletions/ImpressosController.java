package com.sgsistemas.apibiblioteca.LivroRevistaColletions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("impressos")
public class ImpressosController {
    @Autowired
    ImpressosService impressosService;
    @GetMapping
    public List<Impressos> listarTodos(){
       return  impressosService.findAll();
    }

    @PostMapping("/{idImpresso}/{qtd}")
    public void adicionarUnidade(@PathVariable Long id,@PathVariable int qtd){
        impressosService.adicionaUnidades(id , qtd);
    }

    @PostMapping
    public void salvar(@RequestBody Impressos impressos) throws Exception {
        impressosService.salvar(impressos);
    }

    @GetMapping("/{id}")
    public Impressos encontrarPeloId(@PathVariable Long id){
        return impressosService.findById(id);
    }
}
