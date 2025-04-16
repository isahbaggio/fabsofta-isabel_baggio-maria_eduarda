package br.univille.closet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.univille.closet.entity.RoupaSuperior;
import br.univille.closet.service.RoupaSuperiorService;

@RestController
@RequestMapping ("/api/roupasuperior")
public class RoupaSuperiorController {
    @Autowired
    private RoupaSuperiorService service;

    public ResponseEntity<List<RoupaSuperior>> getRoupaSuperior () {
        var listaRoupaSuperior = service.getAll();

        return new ResponseEntity<List<RoupaSuperior>>(listaRoupaSuperior, HttpStatus.OK);
    }
}
