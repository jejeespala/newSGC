package com.basis.sgc.service;

import com.basis.sgc.domain.Colaborador;
import com.basis.sgc.domain.ColaboradorCompetencia;
import com.basis.sgc.repository.ColaboradorCompetenciaRepository;
import com.basis.sgc.repository.ColaboradorRepository;
import com.basis.sgc.repository.CompetenciaRepository;
import com.basis.sgc.service.dto.ColaboradorCompetenciaDTO;
import com.basis.sgc.service.dto.ColaboradorDTO;
import com.basis.sgc.service.mapper.ColaboradorCompetenciaMapper;
import com.basis.sgc.service.mapper.ColaboradorMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ColaboradorCompetenciaService {

    private final ColaboradorCompetenciaMapper colaboradorCompetenciaMapper;

    private final ColaboradorRepository colaboradorRepository;

    private final CompetenciaRepository competenciaRepository;

    private final ColaboradorCompetenciaRepository colaboradorCompetenciaRepository;

    public List<ColaboradorCompetenciaDTO> buscar(){

        return colaboradorCompetenciaMapper.toDto(colaboradorCompetenciaRepository.findAll()) ;
    }

    public ColaboradorCompetenciaDTO salvar(ColaboradorCompetenciaDTO colaboradorCompetenciaDTO){

        ColaboradorCompetencia colaboradorCompetencia = colaboradorCompetenciaMapper.toEntity(colaboradorCompetenciaDTO);
        return colaboradorCompetenciaMapper.toDto(colaboradorCompetenciaRepository.save(colaboradorCompetencia));

    }

//    public void deletar(Integer id){
//
//        colaboradorCompetenciaRepository.deleteById(id);
//
//    }

}
