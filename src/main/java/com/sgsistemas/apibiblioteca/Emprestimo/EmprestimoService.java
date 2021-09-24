package com.sgsistemas.apibiblioteca.Emprestimo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmprestimoService {
    @Autowired
    EmprestimoRepository emprestimoRepository;

    public int verificarEmprestimosAtivos(Long id){
     return (int) emprestimoRepository.findAll().stream().filter(o -> o.getDataParaEntrega().after(Calendar.getInstance())
                                                                   && o.getLeitor().getId() == id).count();
    }




    public List<Emprestimo> verificarEmprestimosAtrasados(Long id){
        return emprestimoRepository.findAll().stream().filter(o -> o.getDataParaEntrega().before(Calendar.getInstance())
                                                                && o.getLeitor().getId() == id
                                                                && o.isEmprestimoSituacao() == false).collect(Collectors.toList());
    }

    public void delvolverEmprestimo(Long id) throws Exception {
        Emprestimo emprestimo = emprestimoRepository.getById(id);
        if(emprestimo.isEmprestimoSituacao() == true) throw new Exception("esse livro ja foi devolvido");
        if(emprestimo.getDataParaEntrega().before(Calendar.getInstance())) throw new Exception("pague as pendencias referente a esse emprestimo antes de realizar a devolução");

        emprestimo.setEmprestimoSituacao(true);
        emprestimo.getImpressos().setQuantidadeDisponivel(1);
        emprestimoRepository.save(emprestimo);
    }

    public void save(Emprestimo emprestimo) throws Exception {
        if(emprestimo.getImpressos().getQuantidadeDisponivel()==0) throw new Exception("não existe livros disponiveis");
        if(verificarEmprestimosAtivos(emprestimo.getLeitor().getId()) > 4) throw  new Exception("limite de emprestimos atingido");
        if((int) verificarEmprestimosAtrasados(emprestimo.getId()).stream().count() > 0)throw  new Exception("existe emprestimos pendentes");


        emprestimo.setDataDoEmprestimo(Calendar.getInstance());
        Calendar dataParaEntrega = Calendar.getInstance();
        dataParaEntrega.add(Calendar.DAY_OF_YEAR, 7);
        emprestimo.setDataParaEntrega(dataParaEntrega);

        emprestimoRepository.save(emprestimo);
    }
    public List<Emprestimo> findAll(){
        return emprestimoRepository.findAll();
    }
    public Optional<Emprestimo> findById(Long id){
        return emprestimoRepository.findById(id);
    }

    public void realizarPagemento(Long idEmprestimo) {
        //calculando os dias passados desda data de entrega ate a a data q ele realizou a entrega
        Emprestimo emprestimo = emprestimoRepository.getById(idEmprestimo);
        LocalDateTime localDateAtual = Calendar.getInstance().getTime().toInstant().atZone( ZoneId.systemDefault() ).toLocalDateTime();
        LocalDateTime localDateFim = emprestimo.getDataParaEntrega().getTime().toInstant().atZone( ZoneId.systemDefault() ).toLocalDateTime();
       //relizando a entrega do emprestimo, mesma coisa do .save
        long dias = localDateFim.until(localDateAtual, ChronoUnit.DAYS);
        emprestimo.setMulta((double) dias * 5);
        emprestimo.setEmprestimoSituacao(true);
        emprestimo.getImpressos().setQuantidadeDisponivel(1);
        emprestimoRepository.save(emprestimo);


    }
}
