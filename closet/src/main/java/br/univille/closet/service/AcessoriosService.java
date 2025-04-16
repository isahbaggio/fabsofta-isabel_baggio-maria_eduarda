package br.univille.closet.service;

import java.util.List;
import br.univille.closet.entity.Acessorios;

public interface AcessoriosService {
    Acessorios save(Acessorios acessorios);
    List<Acessorios> getAll();
    Acessorios getById(long id);
    Acessorios delete(long id);
}
