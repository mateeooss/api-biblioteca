package com.sgsistemas.apibiblioteca.Leitor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/leitor")
public class LeitorController {
    @Autowired
    LeitorService leitorService;

   @PostMapping
    public void registrarLeitor(@RequestBody Leitor leitor){
       leitorService.save(leitor);
   }
   @GetMapping
    public List<Leitor> listarTodos(){
       return leitorService.findAll();
   }

   @GetMapping("/{id}")
    public Leitor encontrarPeloId(@PathVariable Long id){
       return leitorService.findById(id);
   }



}
