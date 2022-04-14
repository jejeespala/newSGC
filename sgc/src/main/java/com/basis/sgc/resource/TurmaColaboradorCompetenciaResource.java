package com.basis.sgc.resource;

import com.basis.sgc.domain.TurmaColaboradorCompetencia;
import com.basis.sgc.service.ColaboradorCompetenciaService;
import com.basis.sgc.service.TurmaColaboradorCompetenciaService;
import com.basis.sgc.service.dto.ColaboradorCompetenciaDTO;
import com.basis.sgc.service.dto.TurmaColaboradorCompetenciaDTO;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/turmas_colaboradores_competencias")
@RequiredArgsConstructor
public class TurmaColaboradorCompetenciaResource {

    private final TurmaColaboradorCompetenciaService turmaColaboradorCompetenciaService;

    @GetMapping
    public ResponseEntity<List<TurmaColaboradorCompetenciaDTO>> listar(){
        List<TurmaColaboradorCompetenciaDTO> turmaColaboradorCompetenciaDTOS = turmaColaboradorCompetenciaService.buscar();
        return new ResponseEntity<>(turmaColaboradorCompetenciaDTOS, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<TurmaColaboradorCompetenciaDTO>> listar(@PathVariable Integer id){
        List<TurmaColaboradorCompetenciaDTO> turmaColaboradorCompetenciaDTOS = turmaColaboradorCompetenciaService.buscarId(id);
        return new ResponseEntity<>(turmaColaboradorCompetenciaDTOS, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> salvar(@Valid @RequestBody TurmaColaboradorCompetenciaDTO turmaColaboradorCompetenciaDTO){
        turmaColaboradorCompetenciaService.salvar(turmaColaboradorCompetenciaDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizar(@Valid @RequestBody TurmaColaboradorCompetenciaDTO turmaColaboradorCompetenciaDTO){
        turmaColaboradorCompetenciaService.salvar(turmaColaboradorCompetenciaDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
