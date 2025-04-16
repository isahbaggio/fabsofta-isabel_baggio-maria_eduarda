package br.univille.closet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.univille.closet.entity.Look;
import br.univille.closet.service.LookService;

@RestController
@RequestMapping("/api/look")
public class LookController {
    @Autowired
    private LookService service;

    public ResponseEntity<List<Look>> getAcessorios () {
        var listaLook = service.getAll();

        return new ResponseEntity<List<Look>>(listaLook, HttpStatus.OK);
    }
}
