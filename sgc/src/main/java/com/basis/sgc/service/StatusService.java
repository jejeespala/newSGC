package com.basis.sgc.service;

import com.basis.sgc.repository.StatusRepository;
import com.basis.sgc.service.dto.DropdownDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class StatusService {

    private final StatusRepository statusRepository;

    public List<DropdownDTO> buscar(){
        return statusRepository.listar();
    }

}
