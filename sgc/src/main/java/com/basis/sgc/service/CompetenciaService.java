package com.basis.sgc.service;

import com.basis.sgc.domain.Competencia;
import com.basis.sgc.repository.CategoriaRepository;
import com.basis.sgc.repository.CompetenciaRepository;
import com.basis.sgc.service.dto.CategoriaDTO;
import com.basis.sgc.service.dto.CompetenciaDTO;
import com.basis.sgc.service.dto.CompetenciaListDTO;
import com.basis.sgc.service.mapper.CategoriaMapper;
import com.basis.sgc.service.mapper.CompetenciaMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CompetenciaService {

    private final CompetenciaMapper competenciaMapper;

    private final CompetenciaRepository competenciaRepository;

    public List<CompetenciaListDTO> buscar(){

        return competenciaRepository.listar();
    }

    public CompetenciaDTO salvar(CompetenciaDTO competenciaDTO){

        Competencia competencia = competenciaMapper.toEntity(competenciaDTO);

        return competenciaMapper.toDto(competenciaRepository.save(competencia));

    }

    public void deletar(Integer id){

        competenciaRepository.deleteById(id);

    }

}
