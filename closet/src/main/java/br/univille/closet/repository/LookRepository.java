package br.univille.closet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.univille.closet.entity.Look;

@Repository
public interface LookRepository 
    extends JpaRepository<Look, Long> {
}
