package br.univille.closet.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.univille.closet.entity.RoupaInferior;
import br.univille.closet.repository.RoupaInferiorRepository;
import br.univille.closet.service.RoupaInferiorService;

@Service
public class RoupaInferiorServiceImpl implements RoupaInferiorService{

    @Autowired
    private RoupaInferiorRepository repository;

    @Override
    public RoupaInferior save(RoupaInferior roupaInferior){
        return repository.save(roupaInferior);
    }
    
    @Override
    public RoupaInferior delete(long id) {
        var roupaInferior = getById(id);
        if(roupaInferior != null)
            repository.deleteById(id);
        return roupaInferior;    
    }

    @Override
    public List<RoupaInferior> getAll() {
        return repository.findAll();
    }

    @Override
    public RoupaInferior getById(long id) {
        var retorno = repository.findById(id);
        if (retorno.isPresent()) {
                return retorno.get();
        }
        return null;

    }
}
