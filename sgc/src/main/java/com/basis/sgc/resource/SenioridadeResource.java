package com.basis.sgc.resource;

import com.basis.sgc.service.SenioridadeService;
import com.basis.sgc.service.StatusService;
import com.basis.sgc.service.dto.DropdownDTO;
import com.basis.sgc.service.dto.SenioridadeDTO;
import com.basis.sgc.service.dto.StatusDTO;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/senioridades")
@RequiredArgsConstructor
public class SenioridadeResource {

    private final SenioridadeService senioridadeService;

    @GetMapping
    private ResponseEntity<List<DropdownDTO>> listar(){
        List<DropdownDTO> senioridadeDTOS = senioridadeService.buscar();
        return new ResponseEntity<>(senioridadeDTOS, HttpStatus.OK);
    }
}
