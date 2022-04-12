package com.basis.sgc.service;

import com.basis.sgc.domain.Competencia;
import com.basis.sgc.repository.CompetenciaRepository;
import com.basis.sgc.service.dto.CompetenciaDTO;
import com.basis.sgc.service.dto.CompetenciaListDTO;
import com.basis.sgc.service.dto.DropdownDTO;
import com.basis.sgc.service.mapper.CompetenciaMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CompetenciaService {

    private final CompetenciaMapper competenciaMapper;

    private final CompetenciaRepository competenciaRepository;

    public List<CompetenciaListDTO> buscar(){
        return competenciaRepository.listar();
    }

    public CompetenciaDTO buscarPorId(Integer id){
        Competencia competencia = competenciaRepository.findById(id).orElseThrow(()->new RuntimeException("Competencia não encontrada!"));
        return competenciaMapper.toDto(competencia);
    }

    public List<DropdownDTO> listarDrop(){
        return competenciaRepository.listarDrop();
    }

    public CompetenciaDTO salvar(CompetenciaDTO competenciaDTO){
        Competencia competencia = competenciaMapper.toEntity(competenciaDTO);
        return competenciaMapper.toDto(competenciaRepository.save(competencia));
    }

    public void deletar(Integer id){
        competenciaRepository.deleteById(id);
    }
}
