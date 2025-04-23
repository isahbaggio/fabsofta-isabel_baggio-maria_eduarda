package br.univille.closet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.univille.closet.entity.Usuario;

@Repository
public interface UsuarioRepository 
    extends JpaRepository<Usuario, Long> {
}
