package br.univille.closet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.univille.closet.entity.Acessorios;
import br.univille.closet.service.AcessoriosService;

@RestController
@RequestMapping("/api/acessorios")
public class AcessoriosController {
    
    @Autowired
    private AcessoriosService service;

    public ResponseEntity<List<Acessorios>> getAcessorios () {
        var listaAcessorios = service.getAll();

        return new ResponseEntity<List<Acessorios>>(listaAcessorios, HttpStatus.OK);
    }
}
