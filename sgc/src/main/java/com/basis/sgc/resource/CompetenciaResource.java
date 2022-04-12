package com.basis.sgc.resource;

import com.basis.sgc.service.CompetenciaService;
import com.basis.sgc.service.dto.CompetenciaDTO;
import com.basis.sgc.service.dto.CompetenciaListDTO;
import com.basis.sgc.service.dto.DropdownDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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

    @GetMapping(value = "/dropdown")
    public ResponseEntity<List<DropdownDTO>> listarDrop(){
        List<DropdownDTO> competenciaDropdownDTOS = competenciaService.listarDrop();
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
