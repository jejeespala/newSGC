package com.basis.sgc.resource;

import com.basis.sgc.service.ColaboradorService;
import com.basis.sgc.service.CompetenciaService;
import com.basis.sgc.service.dto.ColaboradorDTO;
import com.basis.sgc.service.dto.CompetenciaDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/colaborador")
@AllArgsConstructor
public class ColaboradorResource {

    private final ColaboradorService colaboradorService;

    @GetMapping
    public ResponseEntity<List<ColaboradorDTO>> listar(){

        return ResponseEntity.ok(colaboradorService.buscar());
    }

    @PostMapping
    public ResponseEntity<ColaboradorDTO> salvar(@RequestBody ColaboradorDTO colaboradorDTO){

        return ResponseEntity.status(HttpStatus.CREATED).body(colaboradorService.salvar(colaboradorDTO));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable("id") Integer id){

        colaboradorService.deletar(id);
        return ResponseEntity.status(HttpStatus.OK).build();

    }

    @PutMapping("/{id}")
    public ResponseEntity<ColaboradorDTO> atualizar(@RequestBody ColaboradorDTO colaboradorDTO){

        return ResponseEntity.status(HttpStatus.CREATED).body(colaboradorService.salvar(colaboradorDTO));

    }




}
