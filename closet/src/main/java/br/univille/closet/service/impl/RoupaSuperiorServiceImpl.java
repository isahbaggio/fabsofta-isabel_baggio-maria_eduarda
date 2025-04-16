package br.univille.closet.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.closet.entity.RoupaSuperior;
import br.univille.closet.repository.RoupaSuperiorRepository;
import br.univille.closet.service.RoupaSuperiorService;

@Service
public class RoupaSuperiorServiceImpl implements RoupaSuperiorService{

    @Autowired
    private RoupaSuperiorRepository repository;

    @Override
    public RoupaSuperior save(RoupaSuperior roupaSuperior){
        return repository.save(roupaSuperior);
    }
    
    @Override
    public RoupaSuperior delete(long id) {
        var roupaSuperior = getById(id);
        if(roupaSuperior != null)
            repository.deleteById(id);
        return roupaSuperior;    
    }

    @Override
    public List<RoupaSuperior> getAll() {
        return repository.findAll();
    }

    @Override
    public RoupaSuperior getById(long id) {
        var retorno = repository.findById(id);
        if (retorno.isPresent()) {
                return retorno.get();
        }
        return null;
    }
}


