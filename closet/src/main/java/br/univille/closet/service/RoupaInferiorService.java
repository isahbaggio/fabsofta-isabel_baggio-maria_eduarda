package br.univille.closet.service;

import java.util.List;
import br.univille.closet.entity.RoupaInferior;

public interface RoupaInferiorService {
    RoupaInferior save(RoupaInferior acessorios);
    List<RoupaInferior> getAll();
    RoupaInferior getById(long id);
    RoupaInferior delete(long id);
}
