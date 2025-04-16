package br.univille.closet.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.closet.entity.Sapato;
import br.univille.closet.repository.SapatoRepository;
import br.univille.closet.service.SapatoService;

@Service
public class SapatoServiceImpl implements SapatoService{

    @Autowired
    private SapatoRepository repository;

    @Override
    public Sapato save(Sapato sapato){
        return repository.save(sapato);
    }
    
    @Override
    public Sapato delete(long id) {
        var sapato = getById(id);
        if(sapato != null)
            repository.deleteById(id);
        return sapato;    
    }

    @Override
    public List<Sapato> getAll() {
        return repository.findAll();
    }

    @Override
    public Sapato getById(long id) {
        var retorno = repository.findById(id);
        if (retorno.isPresent()) {
                return retorno.get();
        }
        return null;
    }

}
