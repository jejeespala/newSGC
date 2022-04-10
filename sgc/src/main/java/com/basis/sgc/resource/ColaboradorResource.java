package com.basis.sgc.resource;

import com.basis.sgc.service.ColaboradorService;
import com.basis.sgc.service.CompetenciaService;
import com.basis.sgc.service.dto.*;
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
    public ResponseEntity<List<ColaboradorListDTO>> listar(){

        return ResponseEntity.ok(colaboradorService.buscar());
    }

    @GetMapping("/competencia/{id}")
    public ResponseEntity<List<ColaboradorDropdownDTO>> listarNivelMaximo(@PathVariable Integer id){

        return ResponseEntity.ok(colaboradorService.buscarColaboradorNivelMaximo(id));
    }



    @PostMapping
    public void salvar(@RequestBody ColaboradorDTO colaboradorDTO){

         colaboradorService.salvar(colaboradorDTO);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable("id") Integer id){

        colaboradorService.deletar(id);
        return ResponseEntity.status(HttpStatus.OK).build();

    }

    @PutMapping("/{id}")
    public void atualizar(@RequestBody ColaboradorDTO colaboradorDTO){

        colaboradorService.salvar(colaboradorDTO);

    }




}
