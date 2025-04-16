package br.univille.closet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.univille.closet.entity.Sapato;

@Repository
public interface SapatoRepository 
    extends JpaRepository<Sapato, Long> {
}
