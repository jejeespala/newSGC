package com.basis.sgc.resource;

import com.basis.sgc.service.CategoriaService;
import com.basis.sgc.service.CompetenciaService;
import com.basis.sgc.service.dto.CategoriaDTO;
import com.basis.sgc.service.dto.CompetenciaDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/competencia")
@AllArgsConstructor
public class CompetenciaResource {

    private final CompetenciaService competenciaService;

    @GetMapping
    public ResponseEntity<List<CompetenciaDTO>> listar(){

        return ResponseEntity.ok(competenciaService.buscar());
    }

    @PostMapping
    public ResponseEntity<CompetenciaDTO> salvar(@RequestBody CompetenciaDTO competenciaDTO){

        return ResponseEntity.status(HttpStatus.CREATED).body(competenciaService.salvar(competenciaDTO));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable("id") Integer id){

        competenciaService.deletar(id);
        return ResponseEntity.status(HttpStatus.OK).build();

    }




}
