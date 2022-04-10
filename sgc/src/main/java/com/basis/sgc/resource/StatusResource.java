package com.basis.sgc.resource;

import com.basis.sgc.service.StatusService;
import com.basis.sgc.service.dto.StatusDTO;
import com.basis.sgc.service.dto.StatusDropdownDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/status")
@AllArgsConstructor
public class StatusResource {

    private final StatusService statusService;

    @GetMapping
    private ResponseEntity<List<StatusDropdownDTO>> listar(){

        return ResponseEntity.ok(statusService.buscar());

    }
}
