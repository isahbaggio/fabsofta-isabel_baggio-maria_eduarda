package br.univille.closet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.univille.closet.entity.Acessorios;

@Repository
public interface AcessoriosRepository 
    extends JpaRepository<Acessorios, Long> {
}
