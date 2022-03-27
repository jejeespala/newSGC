package com.basis.sgc.resource;

import com.basis.sgc.service.CategoriaService;
import com.basis.sgc.service.dto.CategoriaDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/categoria")
@AllArgsConstructor
public class CategoriaResource {

    private final CategoriaService categoriaService;

    @GetMapping
    private ResponseEntity<List<CategoriaDTO>> listar(){

        return ResponseEntity.ok(categoriaService.buscar());
    }
}
