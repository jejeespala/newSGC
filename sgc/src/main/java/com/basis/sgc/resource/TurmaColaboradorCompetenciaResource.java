package com.basis.sgc.resource;

import com.basis.sgc.domain.TurmaColaboradorCompetencia;
import com.basis.sgc.service.ColaboradorCompetenciaService;
import com.basis.sgc.service.TurmaColaboradorCompetenciaService;
import com.basis.sgc.service.dto.ColaboradorCompetenciaDTO;
import com.basis.sgc.service.dto.TurmaColaboradorCompetenciaDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/turma_colaborador_competencia")
@AllArgsConstructor
public class TurmaColaboradorCompetenciaResource {

    private final TurmaColaboradorCompetenciaService turmaColaboradorCompetenciaService;

    @GetMapping
    public ResponseEntity<List<TurmaColaboradorCompetenciaDTO>> listar(){

        return ResponseEntity.ok(turmaColaboradorCompetenciaService.buscar());
    }

    @PostMapping
    public ResponseEntity<TurmaColaboradorCompetenciaDTO> salvar(@RequestBody TurmaColaboradorCompetenciaDTO turmaColaboradorCompetenciaDTO){

        return ResponseEntity.status(HttpStatus.CREATED).body(turmaColaboradorCompetenciaService.salvar(turmaColaboradorCompetenciaDTO));

    }

//    @DeleteMapping("/{id}")
//    public ResponseEntity<?> deletar(@PathVariable("id") Integer id){
//
//        colaboradorCompetenciaService.deletar(id);
//        return ResponseEntity.status(HttpStatus.OK).build();
//
//    }

    @PutMapping("/{id}")
    public ResponseEntity<TurmaColaboradorCompetenciaDTO> atualizar(@RequestBody TurmaColaboradorCompetenciaDTO turmaColaboradorCompetenciaDTO){

        return ResponseEntity.status(HttpStatus.CREATED).body(turmaColaboradorCompetenciaService.salvar(turmaColaboradorCompetenciaDTO));

    }




}
