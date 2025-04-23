package br.univille.closet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.univille.closet.entity.Sapato;
import br.univille.closet.service.SapatoService;

@RestController
@RequestMapping("/api/v1/sapatos")
public class SapatoController {
    @Autowired
    private SapatoService service;
    @GetMapping
    public ResponseEntity<List<Sapato>> getSapato () {
        var listaSapato = service.getAll();

        return new ResponseEntity<List<Sapato>>(listaSapato, 
                    HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Sapato>
            postSapato(@RequestBody Sapato sapato){
        if(sapato == null){
            return ResponseEntity.badRequest().build();
        }
        if (sapato.getId() == 0) {
            service.save(sapato);
            return new ResponseEntity<Sapato>(sapato, HttpStatus.OK);
        }
        return ResponseEntity.badRequest().build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<Sapato>
        putSapato(@PathVariable long id,
                    @RequestBody Sapato sapato){
        if ((id <= 0 || sapato == null)) {
            return ResponseEntity.badRequest().build();
        }
        var sapatoAntigo = service.getById(id);
        if ((sapatoAntigo == null)) {
            return ResponseEntity.notFound().build();
        }

        sapatoAntigo.setTipo(sapato.getTipo());
        sapatoAntigo.setCor(sapato.getCor());
        sapatoAntigo.setTamanho(sapato.getTamanho());
        sapatoAntigo.setMarca(sapato.getMarca());

        service.save(sapatoAntigo);
        return new ResponseEntity<Sapato>(sapatoAntigo, HttpStatus.OK);
    }
    @DeleteMapping
    public ResponseEntity<Sapato> deleteSapato(@PathVariable long id){
        if(id <= 0){
            return ResponseEntity.badRequest().build();
        }
        var sapatoExcluir = service.getById(id);
        if(sapatoExcluir == null){
            return ResponseEntity.notFound().build();
        }
        service.delete(id);
        return new ResponseEntity<Sapato>(sapatoExcluir, HttpStatus.OK);
    }
}