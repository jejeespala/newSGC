package com.basis.sgc.service;

import com.basis.sgc.domain.TurmaColaboradorCompetencia;
import com.basis.sgc.repository.TurmaColaboradorCompetenciaRepository;
import com.basis.sgc.service.dto.TurmaColaboradorCompetenciaDTO;
import com.basis.sgc.service.mapper.TurmaColaboradorCompetenciaMapper;
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
public class TurmaColaboradorCompetenciaService {

    TurmaColaboradorCompetenciaMapper turmaColaboradorCompetenciaMapper;

    TurmaColaboradorCompetenciaRepository turmaColaboradorCompetenciaRepository;

    public List<TurmaColaboradorCompetenciaDTO> buscar(){
        return turmaColaboradorCompetenciaMapper.toDto(turmaColaboradorCompetenciaRepository.findAll());
    }

    public List<TurmaColaboradorCompetenciaDTO> buscarId(Integer id){
        return turmaColaboradorCompetenciaRepository.buscar(id) ;
    }

    public TurmaColaboradorCompetenciaDTO salvar(TurmaColaboradorCompetenciaDTO turmaColaboradorCompetenciaDTO){
        TurmaColaboradorCompetencia turmaColaboradorCompetencia = turmaColaboradorCompetenciaMapper.toEntity(turmaColaboradorCompetenciaDTO);
        return turmaColaboradorCompetenciaMapper.toDto(turmaColaboradorCompetenciaRepository.save(turmaColaboradorCompetencia));
    }
}
