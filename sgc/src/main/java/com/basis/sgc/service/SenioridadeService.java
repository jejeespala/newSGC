package com.basis.sgc.service;

import com.basis.sgc.repository.SenioridadeRepository;
import com.basis.sgc.service.dto.DropdownDTO;
import com.basis.sgc.service.dto.SenioridadeDTO;
import com.basis.sgc.service.mapper.SenioridadeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class SenioridadeService {

    private final SenioridadeMapper senioridadeMapper;

    private final SenioridadeRepository senioridadeRepository;

    public List<DropdownDTO> buscar(){
        return senioridadeRepository.listar();
    }

}
