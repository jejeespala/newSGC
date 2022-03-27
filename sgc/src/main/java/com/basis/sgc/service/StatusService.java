package com.basis.sgc.service;

import com.basis.sgc.repository.StatusRepository;
import com.basis.sgc.service.dto.StatusDTO;
import com.basis.sgc.service.mapper.StatusMapper;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StatusService {

    private final StatusMapper statusMapper;

    private final StatusRepository statusRepository;

    public List<StatusDTO> buscar(){

        return statusMapper.toDto(statusRepository.findAll());

    }


}
