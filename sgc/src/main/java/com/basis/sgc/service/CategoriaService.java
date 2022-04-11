package com.basis.sgc.service;

import com.basis.sgc.repository.CategoriaRepository;
import com.basis.sgc.service.dto.CategoriaDTO;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public List<CategoriaDTO> buscar(){
        return categoriaRepository.listar();
    }
}
