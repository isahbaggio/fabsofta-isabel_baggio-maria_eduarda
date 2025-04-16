package br.univille.closet.service;

import java.util.List;

import br.univille.closet.entity.Sapato;

public interface SapatoService {
    Sapato save(Sapato acessorios);
    List<Sapato> getAll();
    Sapato getById(long id);
    Sapato delete(long id);

}
