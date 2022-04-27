package com.basis.sgc.service;

import com.basis.sgc.repository.SenioridadeRepository;
import com.basis.sgc.service.dto.DropdownDTO;
import com.basis.sgc.service.mapper.SenioridadeMapper;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.REQUIRED)
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class SenioridadeService {

    SenioridadeMapper senioridadeMapper;

    SenioridadeRepository senioridadeRepository;

    public List<DropdownDTO> buscar(){
        return senioridadeRepository.listar();
    }

}
