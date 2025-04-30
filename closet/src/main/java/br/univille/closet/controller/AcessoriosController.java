package br.univille.closet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.univille.closet.entity.Acessorios;
import br.univille.closet.service.AcessoriosService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/v1/acessorios")
public class AcessoriosController {
    @Autowired
    private AcessoriosService service;
    @GetMapping
    public ResponseEntity<List<Acessorios>> getAcessorios () {
        var listaAcessorios = service.getAll();

        return new ResponseEntity<List<Acessorios>>(listaAcessorios, 
                    HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Acessorios>
            postAcessorios(@RequestBody Acessorios acessorios){
        if(acessorios == null){
            return ResponseEntity.badRequest().build();
        }
        if (acessorios.getId() == 0) {
            service.save(acessorios);
            return new ResponseEntity<Acessorios>(acessorios, HttpStatus.OK);
        }
        return ResponseEntity.badRequest().build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<Acessorios>
        putAcessorios(@PathVariable long id,
                    @RequestBody Acessorios acessorios){
        if ((id <= 0 || acessorios == null)) {
            return ResponseEntity.badRequest().build();
        }
        var acessoriosAntigo = service.getById(id);
        if ((acessoriosAntigo == null)) {
            return ResponseEntity.notFound().build();
        }

        acessoriosAntigo.setTipo(acessorios.getTipo());
        acessoriosAntigo.setCor(acessorios.getCor());
        acessoriosAntigo.setMaterial(acessorios.getMaterial());

        service.save(acessoriosAntigo);
        return new ResponseEntity<Acessorios>(acessoriosAntigo, HttpStatus.OK);
    }  
    @DeleteMapping("/{id}")
    public ResponseEntity<Acessorios> deleteAcessorios(@PathVariable long id){
        if(id <= 0){
            return ResponseEntity.badRequest().build();
        }
        var acessoriosExcluir = service.getById(id);
        if(acessoriosExcluir == null){
            return ResponseEntity.notFound().build();
        }
        service.delete(id);
        return new ResponseEntity<Acessorios>(acessoriosExcluir, HttpStatus.OK);
    }
} 
