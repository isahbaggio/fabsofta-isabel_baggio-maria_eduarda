package br.univille.closet.service;

import java.util.List;
import br.univille.closet.entity.Look;

public interface LookService {
    Look save(Look acessorios);
    List<Look> getAll();
    Look getById(long id);
    Look delete(long id);
}
