package com.basis.sgc.service;

import com.basis.sgc.domain.ColaboradorCompetencia;
import com.basis.sgc.repository.ColaboradorCompetenciaRepository;
import com.basis.sgc.service.dto.ColaboradorCompetenciaDTO;
import com.basis.sgc.service.mapper.ColaboradorCompetenciaMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ColaboradorCompetenciaService {

    private final ColaboradorCompetenciaMapper colaboradorCompetenciaMapper;

    private final ColaboradorCompetenciaRepository colaboradorCompetenciaRepository;

    public List<ColaboradorCompetenciaDTO> buscar(){
        List<ColaboradorCompetencia> colaboradorCompetencias = colaboradorCompetenciaRepository.findAll();
        return colaboradorCompetenciaMapper.toDto(colaboradorCompetencias);
    }

    public List<ColaboradorCompetenciaDTO> buscarPorId(Integer id){
       return colaboradorCompetenciaRepository.listar(id);
    }

    public ColaboradorCompetenciaDTO salvar(ColaboradorCompetenciaDTO colaboradorCompetenciaDTO){
        ColaboradorCompetencia colaboradorCompetencia = colaboradorCompetenciaMapper.toEntity(colaboradorCompetenciaDTO);
        return colaboradorCompetenciaMapper.toDto(colaboradorCompetenciaRepository.save(colaboradorCompetencia));
    }

}
