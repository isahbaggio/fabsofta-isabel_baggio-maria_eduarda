package br.univille.closet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.univille.closet.entity.Look;
import br.univille.closet.service.LookService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/v1/looks")
public class LookController {

    @Autowired
    private LookService service;

    @GetMapping
    public ResponseEntity<List<Look>> getAcessorios () {
        var listaLook = service.getAll();

        return new ResponseEntity<List<Look>>(listaLook, 
                    HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Look>
            postLook(@RequestBody Look look){
        if(look == null){
            return ResponseEntity.badRequest().build();
        }
        if (look.getId() == 0) {
            service.save(look);
            return new ResponseEntity<Look>(look, HttpStatus.OK);
        }
        return ResponseEntity.badRequest().build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<Look>
        putLook(@PathVariable long id,
                    @RequestBody Look look){
        if ((id <= 0 || look == null)) {
            return ResponseEntity.badRequest().build();
        }
        var lookAntigo = service.getById(id);
        if ((lookAntigo == null)) {
            return ResponseEntity.notFound().build();
        }

        lookAntigo.setRoupaInferior(look.getRoupaInferior());
        lookAntigo.setRoupaSuperior(look.getRoupaSuperior());
        lookAntigo.setAcessorio(look.getAcessorio());
        lookAntigo.setSapato(look.getSapato());

        service.save(lookAntigo);
        return new ResponseEntity<Look>(lookAntigo, HttpStatus.OK);
    }
    @DeleteMapping
    public ResponseEntity<Look> deleteLook(@PathVariable long id){
        if(id <= 0){
            return ResponseEntity.badRequest().build();
        }
        var lookExcluir = service.getById(id);
        if(lookExcluir == null){
            return ResponseEntity.notFound().build();
        }
        service.delete(id);
        return new ResponseEntity<Look>(lookExcluir, HttpStatus.OK);
    }
}
