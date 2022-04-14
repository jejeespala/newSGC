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
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class ColaboradorService {

    private final ColaboradorMapper colaboradorMapper;

    private final ColaboradorRepository colaboradorRepository;

    private final ColaboradorCompetenciaMapper colaboradorCompetenciaMapper;

    private final ColaboradorCompetenciaRepository colaboradorCompetenciaRepository;

    private final ColaboradorCompetenciaService colaboradorCompetenciaService;

    public List<ColaboradorListDTO> buscar(){
        return colaboradorRepository.listar();
    }

    public ColaboradorDTO buscarPorId(Integer id){
        Colaborador colaborador = colaboradorRepository.findById(id).orElseThrow(()->new RuntimeException("Competencia não encontrada!"));
        return colaboradorMapper.toDto(colaborador);
    }

    public List<DropdownDTO> buscarColaboradorNivelMaximo(Integer id){
        return colaboradorRepository.nivelMaximo(id);
    }

    public void salvar(ColaboradorDTO colaboradorDTO){
        Colaborador colaborador = colaboradorMapper.toEntity(colaboradorDTO);
        colaboradorRepository.save(colaborador);
        colaboradorCompetenciaService.salvar(colaboradorDTO, colaborador);
    }

    public void deletar(Integer id){
        colaboradorRepository.deleteById(id);
    }

}
