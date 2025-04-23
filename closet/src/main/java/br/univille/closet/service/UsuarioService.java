package br.univille.closet.service;

import java.util.List;
import br.univille.closet.entity.Usuario;

public interface UsuarioService {
    Usuario save(Usuario usuario);
    List<Usuario> getAll();
    Usuario getById(long id);
    Usuario delete(long id);
}
