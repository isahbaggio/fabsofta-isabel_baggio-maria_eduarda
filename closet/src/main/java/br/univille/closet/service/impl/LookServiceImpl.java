package br.univille.closet.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.univille.closet.entity.Look;
import br.univille.closet.repository.LookRepository;
import br.univille.closet.service.LookService;

@Service
public class LookServiceImpl implements LookService{

    @Autowired
    private LookRepository repository;

    @Override
    public Look save(Look look){
        return repository.save(look);
    }
    
    @Override
    public Look delete(long id) {
        var look = getById(id);
        if(look != null)
            repository.deleteById(id);
        return look;    
    }

    @Override
    public List<Look> getAll() {
        return repository.findAll();
    }

    @Override
    public Look getById(long id) {
        var retorno = repository.findById(id);
        if (retorno.isPresent()) {
                return retorno.get();
        }
        return null;

}
}
