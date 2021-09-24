package com.sgsistemas.apibiblioteca.Emprestimo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "emprestimo")
public class EmprestimoController {
    @Autowired
    EmprestimoService emprestimoService;

    @PostMapping
    public void registrarEmprestimo(@RequestBody Emprestimo emprestimo) throws Exception {
        emprestimoService.save(emprestimo);
    }

    @GetMapping
    public List<Emprestimo> listarEmprestimos(){
     return emprestimoService.findAll();
    }

    @PutMapping("/devolucao/{idEmprestimo}")
    public void devolverEmprestimo(@PathVariable Long idEmprestimo) throws Exception {
        emprestimoService.delvolverEmprestimo(idEmprestimo);
    }
    @PutMapping("/{idEmprestimo}")
    public void realizarPagamento(@PathVariable Long idEmprestimo){
        emprestimoService.realizarPagemento(idEmprestimo);
    }
    @GetMapping("/pendencias/{idLeitor}")
    public List<Emprestimo> verificarPendencias(@PathVariable Long idLeitor){
       return emprestimoService.verificarEmprestimosAtrasados(idLeitor);
    }

    @GetMapping("/{idEmprestimo}")
    public Optional<Emprestimo> encontrarEmprestimoPeloId(@PathVariable Long idEmprestimo){
       return   emprestimoService.findById(idEmprestimo);
    }

//    @PutMapping
//    public void devolverEmprestimo(Long id){
//       Emprestimo emprestimo = emprestimoService.findById(id);
//
//    }
}
