package br.univille.closet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.univille.closet.entity.RoupaSuperior;
import br.univille.closet.service.RoupaSuperiorService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping ("/api/v1/roupassuperiores")
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
    @PutMapping("/{id}")
    public ResponseEntity<RoupaSuperior>
        putRoupaSuperior(@PathVariable long id,
                    @RequestBody RoupaSuperior roupaSuperior){
        if ((id <= 0 || roupaSuperior == null)) {
            return ResponseEntity.badRequest().build();
        }
        var roupaSuperiorAntigo = service.getById(id);
        if ((roupaSuperiorAntigo == null)) {
            return ResponseEntity.notFound().build();
        }

        roupaSuperiorAntigo.setTipo(roupaSuperior.getTipo());
        roupaSuperiorAntigo.setCor(roupaSuperior.getCor());
        roupaSuperiorAntigo.setTamanho(roupaSuperior.getTamanho());
        roupaSuperiorAntigo.setTecido(roupaSuperior.getTecido());

        service.save(roupaSuperiorAntigo);
        return new ResponseEntity<RoupaSuperior>(roupaSuperiorAntigo, HttpStatus.OK);
    }
    @DeleteMapping
    public ResponseEntity<RoupaSuperior> deleteRoupaSuperior(@PathVariable long id){
        if(id <= 0){
            return ResponseEntity.badRequest().build();
        }
        var roupaSuperiorExcluir = service.getById(id);
        if(roupaSuperiorExcluir == null){
            return ResponseEntity.notFound().build();
        }
        service.delete(id);
        return new ResponseEntity<RoupaSuperior>(roupaSuperiorExcluir, HttpStatus.OK);
    }
}
