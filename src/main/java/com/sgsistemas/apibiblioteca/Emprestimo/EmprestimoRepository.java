package com.sgsistemas.apibiblioteca.Emprestimo;

import com.sgsistemas.apibiblioteca.Leitor.Leitor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.lang.annotation.Native;
import java.util.Date;
import java.util.List;

@Repository
public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long> {
   // Leitor findleitorById(Long id);


//   @Modifying
//   @Query(nativeQuery = true,value = "update EMPRESTIMO set EMPRESTIMO_SITUACAO = true " +
//           "                          WHERE LEITOR_ID =  :id AND DATA_PARA_ENTREGA < :data" +
//           "                                                 AND EMPRESTIMO_SITUACAO = ")
//    void setEmprestimosAtrasados(@Param("id") Long id,@Param("data") Date data);
}
