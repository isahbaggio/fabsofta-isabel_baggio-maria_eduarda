package br.univille.closet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.univille.closet.entity.RoupaSuperior;
import br.univille.closet.service.RoupaSuperiorService;

@RestController
@RequestMapping ("/api/roupasuperior")
public class RoupaSuperiorController {
    @Autowired
    private RoupaSuperiorService service;
    @GetMapping
    public ResponseEntity<List<RoupaSuperior>> getRoupaSuperior () {
        var listaRoupaSuperior = service.getAll();

        return new ResponseEntity<List<RoupaSuperior>>(listaRoupaSuperior, 
                    HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<RoupaSuperior>
            postRoupaSuperior(@RequestBody RoupaSuperior roupaSuperior){
        if(roupaSuperior == null){
            return ResponseEntity.badRequest().build();
        }
        if (roupaSuperior.getId() == 0) {
            service.save(roupaSuperior);
            return new ResponseEntity<RoupaSuperior>(roupaSuperior, HttpStatus.OK);
        }
        return ResponseEntity.badRequest().build();
    }
}
