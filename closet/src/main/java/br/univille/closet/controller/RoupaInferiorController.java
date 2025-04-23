package br.univille.closet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.univille.closet.entity.RoupaInferior;
import br.univille.closet.service.RoupaInferiorService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/v1/roupasinferiores")
public class RoupaInferiorController {
    @Autowired
    private RoupaInferiorService service;
    @GetMapping
    public ResponseEntity<List<RoupaInferior>> getRoupaInferior () {
        var listaRoupaInferior = service.getAll();

        return new ResponseEntity<List<RoupaInferior>>(listaRoupaInferior, 
                    HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<RoupaInferior>
            postRoupaInferior(@RequestBody RoupaInferior roupaInferior){
        if(roupaInferior == null){
            return ResponseEntity.badRequest().build();
        }
        if (roupaInferior.getId() == 0) {
            service.save(roupaInferior);
            return new ResponseEntity<RoupaInferior>(roupaInferior, HttpStatus.OK);
        }
        return ResponseEntity.badRequest().build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<RoupaInferior>
        putRoupaInferior(@PathVariable long id,
                    @RequestBody RoupaInferior roupaInferior){
        if ((id <= 0 || roupaInferior == null)) {
            return ResponseEntity.badRequest().build();
        }
        var roupaInferiorAntigo = service.getById(id);
        if ((roupaInferiorAntigo == null)) {
            return ResponseEntity.notFound().build();
        }

        roupaInferiorAntigo.setTipo(roupaInferior.getTipo());
        roupaInferiorAntigo.setCor(roupaInferior.getCor());
        roupaInferiorAntigo.setTamanho(roupaInferior.getTamanho());
        roupaInferiorAntigo.setTecido(roupaInferior.getTecido());

        service.save(roupaInferiorAntigo);
        return new ResponseEntity<RoupaInferior>(roupaInferiorAntigo, HttpStatus.OK);
    }
    @DeleteMapping
    public ResponseEntity<RoupaInferior> deleteRoupaInferior(@PathVariable long id){
        if(id <= 0){
            return ResponseEntity.badRequest().build();
        }
        var roupaInferiorExcluir = service.getById(id);
        if(roupaInferiorExcluir == null){
            return ResponseEntity.notFound().build();
        }
        service.delete(id);
        return new ResponseEntity<RoupaInferior>(roupaInferiorExcluir, HttpStatus.OK);
    }
}
