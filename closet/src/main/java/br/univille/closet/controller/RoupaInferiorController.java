package br.univille.closet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.univille.closet.entity.RoupaInferior;
import br.univille.closet.service.RoupaInferiorService;

@RestController
@RequestMapping("/api/roupainferior")
public class RoupaInferiorController {
    @Autowired
    private RoupaInferiorService service;

    public ResponseEntity<List<RoupaInferior>> getRoupaInferior () {
        var listaRoupaInferior = service.getAll();

        return new ResponseEntity<List<RoupaInferior>>(listaRoupaInferior, HttpStatus.OK);
    }
}
