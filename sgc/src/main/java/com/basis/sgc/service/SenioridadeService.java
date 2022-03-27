package com.basis.sgc.service;

import com.basis.sgc.repository.SenioridadeRepository;
import com.basis.sgc.repository.StatusRepository;
import com.basis.sgc.service.dto.SenioridadeDTO;
import com.basis.sgc.service.dto.StatusDTO;
import com.basis.sgc.service.mapper.SenioridadeMapper;
import com.basis.sgc.service.mapper.StatusMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SenioridadeService {

    private final SenioridadeMapper senioridadeMapper;

    private final SenioridadeRepository senioridadeRepository;

    public List<SenioridadeDTO> buscar(){

        return senioridadeMapper.toDto(senioridadeRepository.findAll());

    }


}
