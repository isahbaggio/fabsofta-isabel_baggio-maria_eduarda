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
    public Acessorios save(Acessorios acessorios) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public List<Acessorios> getAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

    @Override
    public Acessorios getById(long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }

    @Override
    public Acessorios delete(long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

}
