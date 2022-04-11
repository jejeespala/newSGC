package com.basis.sgc.resource;

import com.basis.sgc.service.ColaboradorService;
import com.basis.sgc.service.CompetenciaService;
import com.basis.sgc.service.dto.*;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/colaboradores")
@RequiredArgsConstructor
public class ColaboradorResource {

    private final ColaboradorService colaboradorService;

    @GetMapping
    public ResponseEntity<List<ColaboradorListDTO>> listar(){
        List<ColaboradorListDTO> colaboradorListDTOS = colaboradorService.buscar();
        return new ResponseEntity<>(colaboradorListDTOS, HttpStatus.OK);
    }

    @GetMapping("/competencias/{id}")
    public ResponseEntity<List<ColaboradorDropdownDTO>> listarNivelMaximo(@PathVariable Integer id){
        List<ColaboradorDropdownDTO> colaboradorDTOS = colaboradorService.buscarColaboradorNivelMaximo(id);
        return new ResponseEntity<>(colaboradorDTOS, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ColaboradorDTO> buscarPorId(@PathVariable Integer id){
        ColaboradorDTO colaboradorDTO = colaboradorService.buscarPorId(id);
        return new ResponseEntity<>(colaboradorDTO, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> salvar(@Valid @RequestBody ColaboradorDTO colaboradorDTO){
        colaboradorService.salvar(colaboradorDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable("id") Integer id){
        colaboradorService.deletar(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizar(@RequestBody ColaboradorDTO colaboradorDTO){
        colaboradorService.salvar(colaboradorDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
