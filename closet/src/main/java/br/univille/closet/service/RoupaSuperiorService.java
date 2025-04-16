package br.univille.closet.service;

import java.util.List;

import br.univille.closet.entity.RoupaSuperior;

public interface RoupaSuperiorService {
    RoupaSuperior save(RoupaSuperior acessorios);
    List<RoupaSuperior> getAll();
    RoupaSuperior getById(long id);
    RoupaSuperior delete(long id);

}
