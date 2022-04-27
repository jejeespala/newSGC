package com.basis.sgc.service;

import com.basis.sgc.repository.CategoriaRepository;
import com.basis.sgc.service.dto.DropdownDTO;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.REQUIRED)
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class CategoriaService {

    CategoriaRepository categoriaRepository;

    public List<DropdownDTO> buscar(){
        return categoriaRepository.listar();
    }
}
