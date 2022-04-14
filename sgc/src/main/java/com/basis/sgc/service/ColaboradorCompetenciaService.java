package com.basis.sgc.service;

import com.basis.sgc.domain.Colaborador;
import com.basis.sgc.domain.ColaboradorCompetencia;
import com.basis.sgc.repository.ColaboradorCompetenciaRepository;
import com.basis.sgc.service.dto.ColaboradorCompetenciaDTO;
import com.basis.sgc.service.dto.ColaboradorDTO;
import com.basis.sgc.service.mapper.ColaboradorCompetenciaMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

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

    public void salvar(ColaboradorDTO colaboradorDTO, Colaborador colaborador){

        List<ColaboradorCompetencia> colaboradorCompetencias = colaboradorDTO.getCompetencias().stream().map(
                competencia -> colaboradorCompetenciaMapper.toEntity(new ColaboradorCompetenciaDTO(colaborador.getId(), competencia.getIdCompetencia(), competencia.getNivel()))
        ).collect(Collectors.toList());

        colaboradorCompetenciaRepository.saveAll(colaboradorCompetencias);

    }

}
