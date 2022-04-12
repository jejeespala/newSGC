package com.basis.sgc.resource;

import com.basis.sgc.service.StatusService;
import com.basis.sgc.service.dto.DropdownDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/status")
@RequiredArgsConstructor
public class StatusResource {

    private final StatusService statusService;

    @GetMapping
    private ResponseEntity<List<DropdownDTO>> listar(){
        List<DropdownDTO> statusDropdownDTOS = statusService.buscar();
        return new ResponseEntity<>(statusDropdownDTOS, HttpStatus.OK);
    }
}
