package com.sgsistemas.apibiblioteca.LivroRevistaColletions;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImpressosRepository extends JpaRepository<Impressos, Long> {
   Impressos findByisbn(String isbn);

}
