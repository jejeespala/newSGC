package com.basis.sgc.resource;

import com.basis.sgc.service.TurmaService;
import com.basis.sgc.service.dto.TurmaDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/turma")
@AllArgsConstructor
public class TurmaResource {

    private final TurmaService turmaService;

    @GetMapping
    public ResponseEntity<List<TurmaDTO>> listar(){

        return ResponseEntity.ok(turmaService.buscar());
    }

    @PostMapping
    public ResponseEntity<TurmaDTO> salvar(@RequestBody TurmaDTO turmaDTO){

        return ResponseEntity.status(HttpStatus.CREATED).body(turmaService.salvar(turmaDTO));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable("id") Integer id){

        turmaService.deletar(id);
        return ResponseEntity.status(HttpStatus.OK).build();

    }

    @PutMapping("/{id}")
    public ResponseEntity<TurmaDTO> atualizar(@RequestBody TurmaDTO turmaDTO){

        return ResponseEntity.status(HttpStatus.CREATED).body(turmaService.salvar(turmaDTO));

    }




}
