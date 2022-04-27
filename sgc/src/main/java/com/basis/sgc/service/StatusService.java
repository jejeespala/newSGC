package com.basis.sgc.service;

import com.basis.sgc.repository.StatusRepository;
import com.basis.sgc.service.dto.DropdownDTO;
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
public class StatusService {

    private final StatusRepository statusRepository;

    public List<DropdownDTO> buscar(){
        return statusRepository.listar();
    }

}
