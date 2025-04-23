package br.univille.closet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.univille.closet.entity.RoupaInferior;
import br.univille.closet.service.RoupaInferiorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/roupainferior")
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
}
