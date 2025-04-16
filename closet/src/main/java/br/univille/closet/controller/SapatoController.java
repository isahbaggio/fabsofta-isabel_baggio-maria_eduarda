package br.univille.closet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.univille.closet.entity.Sapato;
import br.univille.closet.service.SapatoService;

@RestController
@RequestMapping("/api/sapato")
public class SapatoController {
    @Autowired
    private SapatoService service;

    public ResponseEntity<List<Sapato>> getSapato () {
        var listaSapato = service.getAll();

        return new ResponseEntity<List<Sapato>>(listaSapato, HttpStatus.OK);
    }
}
