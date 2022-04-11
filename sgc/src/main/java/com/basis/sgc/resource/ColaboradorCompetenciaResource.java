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

import java.util.List;

@RestController
@RequestMapping("/api/colaborador_competencia")
@AllArgsConstructor
public class ColaboradorCompetenciaResource {

    private final ColaboradorCompetenciaService colaboradorCompetenciaService;

    @GetMapping
    public ResponseEntity<List<ColaboradorCompetenciaDTO>> listar(){

        return ResponseEntity.ok(colaboradorCompetenciaService.buscar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<ColaboradorCompetenciaDTO>> buscarPorId(@PathVariable Integer id){
        return ResponseEntity.ok(colaboradorCompetenciaService.buscarPorId(id));
    }


    @PostMapping
    public ResponseEntity<ColaboradorCompetenciaDTO> salvar(@RequestBody ColaboradorCompetenciaDTO colaboradorCompetenciaDTO){

        return ResponseEntity.status(HttpStatus.CREATED).body(colaboradorCompetenciaService.salvar(colaboradorCompetenciaDTO));

    }

//    @DeleteMapping("/{id}")
//    public ResponseEntity<?> deletar(@PathVariable("id") Integer id){
//
//        colaboradorCompetenciaService.deletar(id);
//        return ResponseEntity.status(HttpStatus.OK).build();
//
//    }

    @PutMapping("/{id}")
    public ResponseEntity<ColaboradorCompetenciaDTO> atualizar(@RequestBody ColaboradorCompetenciaDTO colaboradorCompetenciaDTO){

        return ResponseEntity.status(HttpStatus.CREATED).body(colaboradorCompetenciaService.salvar(colaboradorCompetenciaDTO));

    }




}
