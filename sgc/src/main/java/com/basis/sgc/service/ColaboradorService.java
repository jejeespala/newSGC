package com.basis.sgc.service;

import com.basis.sgc.domain.Colaborador;
import com.basis.sgc.domain.ColaboradorCompetencia;
import com.basis.sgc.repository.ColaboradorCompetenciaRepository;
import com.basis.sgc.repository.ColaboradorRepository;
import com.basis.sgc.service.dto.*;
import com.basis.sgc.service.mapper.ColaboradorCompetenciaMapper;
import com.basis.sgc.service.mapper.ColaboradorMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ColaboradorService {

    private final ColaboradorMapper colaboradorMapper;

    private final ColaboradorRepository colaboradorRepository;

    private final ColaboradorCompetenciaMapper colaboradorCompetenciaMapper;

    private final ColaboradorCompetenciaRepository colaboradorCompetenciaRepository;

    public List<ColaboradorListDTO> buscar(){
        return colaboradorRepository.listar();
    }

    public ColaboradorDTO buscarPorId(Integer id){
        Colaborador colaborador = colaboradorRepository.findById(id).orElseThrow(()->new RuntimeException("Competencia não encontrada!"));
        return colaboradorMapper.toDto(colaborador);
    }

    public List<ColaboradorDropdownDTO> buscarColaboradorNivelMaximo(Integer id){
        return colaboradorRepository.nivelMaximo(id);
    }

    public void salvar(ColaboradorDTO colaboradorDTO){
        Colaborador colaborador = colaboradorMapper.toEntity(colaboradorDTO);
        colaboradorRepository.save(colaborador);
        colaboradorDTO.getCompetencias().stream().forEach(
                competencia -> competencia.setId_colaborador(colaborador.getId())
        );
        List<ColaboradorCompetencia> colaboradorCompetencia = colaboradorCompetenciaMapper.toEntity(colaboradorDTO.getCompetencias());
        colaboradorCompetenciaRepository.saveAll(colaboradorCompetencia);
    }

    public void deletar(Integer id){
        colaboradorRepository.deleteById(id);
    }

}
