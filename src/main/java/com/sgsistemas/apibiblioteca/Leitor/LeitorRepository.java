package com.sgsistemas.apibiblioteca.Leitor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LeitorRepository extends JpaRepository<Leitor, Long> {
}
