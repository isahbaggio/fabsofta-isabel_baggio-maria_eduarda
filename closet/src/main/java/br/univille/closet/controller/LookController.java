package br.univille.closet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.univille.closet.entity.Look;
import br.univille.closet.service.LookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/look")
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
}
