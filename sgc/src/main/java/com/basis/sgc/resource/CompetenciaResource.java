package com.basis.sgc.resource;

import com.basis.sgc.domain.Categoria;
import com.basis.sgc.domain.Colaborador;
import com.basis.sgc.service.CategoriaService;
import com.basis.sgc.service.CompetenciaService;
import com.basis.sgc.service.dto.CategoriaDTO;
import com.basis.sgc.service.dto.CompetenciaDTO;
import com.basis.sgc.service.dto.CompetenciaDropdownDTO;
import com.basis.sgc.service.dto.CompetenciaListDTO;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/competencias")
@RequiredArgsConstructor
public class CompetenciaResource {

    private final CompetenciaService competenciaService;

    @GetMapping
    public ResponseEntity<List<CompetenciaListDTO>> listar(){
        List<CompetenciaListDTO> competenciaListDTOS = competenciaService.buscar();
        return new ResponseEntity<>(competenciaListDTOS, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompetenciaDTO> buscarPorId(@PathVariable Integer id){
        CompetenciaDTO competenciaDTO = competenciaService.buscarPorId(id);
        return new ResponseEntity<>(competenciaDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/colaborador")
    public ResponseEntity<List<CompetenciaDropdownDTO>> listarDrop(){
        List<CompetenciaDropdownDTO> competenciaDropdownDTOS = competenciaService.listarDrop();
        return new ResponseEntity<>(competenciaDropdownDTOS, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> salvar(@Valid @RequestBody CompetenciaDTO competenciaDTO){
        competenciaService.salvar(competenciaDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable("id") Integer id){
        competenciaService.deletar(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizar(@RequestBody CompetenciaDTO competenciaDTO){
        competenciaService.salvar(competenciaDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
