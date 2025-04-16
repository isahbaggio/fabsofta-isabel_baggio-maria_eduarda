package br.univille.closet.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.univille.closet.entity.Acessorios;
import br.univille.closet.repository.AcessoriosRepository;
import br.univille.closet.service.AcessoriosService;

@Service
public class AcessoriosServiceImpl implements AcessoriosService{

    @Autowired
    private AcessoriosRepository repository;

    @Override
    public Acessorios save(Acessorios acessorios){
        return repository.save(acessorios);
    }
        
    @Override
    public Acessorios delete(long id) {
        var acessorios = getById(id);
        if(acessorios != null)
            repository.deleteById(id);
        return acessorios;    
    }

    @Override
    public List<Acessorios> getAll() {
        return repository.findAll();
    }

    @Override
    public Acessorios getById(long id) {
        var retorno = repository.findById(id);
        if (retorno.isPresent()) {
                return retorno.get();
        }
        return null;

    }
}
