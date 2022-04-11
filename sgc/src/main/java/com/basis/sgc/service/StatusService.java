package com.basis.sgc.service;

import com.basis.sgc.repository.StatusRepository;
import com.basis.sgc.service.dto.StatusDTO;
import com.basis.sgc.service.dto.StatusDropdownDTO;
import com.basis.sgc.service.mapper.StatusMapper;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class StatusService {

    private final StatusMapper statusMapper;

    private final StatusRepository statusRepository;

    public List<StatusDropdownDTO> buscar(){
        return statusRepository.listar();
    }


}
