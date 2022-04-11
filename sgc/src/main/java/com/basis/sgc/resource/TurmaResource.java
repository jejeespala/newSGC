package com.basis.sgc.resource;

import com.basis.sgc.service.TurmaService;
import com.basis.sgc.service.dto.ColaboradorDTO;
import com.basis.sgc.service.dto.TurmaDTO;
import com.basis.sgc.service.dto.TurmaListDTO;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/turmas")
@RequiredArgsConstructor
public class TurmaResource {

    private final TurmaService turmaService;

    @GetMapping
    public ResponseEntity<List<TurmaListDTO>> listar(){
        List<TurmaListDTO> turmaListDTOS = turmaService.buscar();
        return new ResponseEntity<>(turmaListDTOS, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TurmaDTO> buscarPorId(@PathVariable Integer id){
        TurmaDTO turmaDTO = turmaService.buscarPorId(id);
        return new ResponseEntity<>(turmaDTO, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> salvar(@Valid @RequestBody TurmaDTO turmaDTO){
        turmaService.salvar(turmaDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable("id") Integer id){
        turmaService.deletar(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TurmaDTO> atualizar(@Valid @RequestBody TurmaDTO turmaDTO){
        turmaService.salvar(turmaDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
