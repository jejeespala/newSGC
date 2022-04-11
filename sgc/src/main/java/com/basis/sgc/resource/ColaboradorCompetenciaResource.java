package com.basis.sgc.resource;

import com.basis.sgc.service.ColaboradorCompetenciaService;
import com.basis.sgc.service.ColaboradorService;
import com.basis.sgc.service.dto.ColaboradorCompetenciaDTO;
import com.basis.sgc.service.dto.ColaboradorDTO;
import com.basis.sgc.service.dto.CompetenciaDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/colaboradores_competencias")
@AllArgsConstructor
public class ColaboradorCompetenciaResource {

    private final ColaboradorCompetenciaService colaboradorCompetenciaService;

    @GetMapping
    public ResponseEntity<List<ColaboradorCompetenciaDTO>> listar(){
        List<ColaboradorCompetenciaDTO> colaboradorCompetenciaDTOS = colaboradorCompetenciaService.buscar();
        return new ResponseEntity<>(colaboradorCompetenciaDTOS, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<ColaboradorCompetenciaDTO>> buscarPorId(@PathVariable Integer id){
        List<ColaboradorCompetenciaDTO> colaboradorCompetenciaDTOS = colaboradorCompetenciaService.buscarPorId(id);
        return new ResponseEntity<>(colaboradorCompetenciaDTOS, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> salvar(@Valid @RequestBody ColaboradorCompetenciaDTO colaboradorCompetenciaDTO){
        colaboradorCompetenciaService.salvar(colaboradorCompetenciaDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizar(@RequestBody ColaboradorCompetenciaDTO colaboradorCompetenciaDTO){
        colaboradorCompetenciaService.salvar(colaboradorCompetenciaDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }




}
