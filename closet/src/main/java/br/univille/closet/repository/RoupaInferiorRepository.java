package br.univille.closet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.univille.closet.entity.RoupaInferior;

@Repository
public interface RoupaInferiorRepository 
    extends JpaRepository<RoupaInferior, Long> {
}
