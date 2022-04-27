package com.basis.sgc.service;

import com.basis.sgc.domain.Colaborador;
import com.basis.sgc.repository.ColaboradorCompetenciaRepository;
import com.basis.sgc.repository.ColaboradorRepository;
import com.basis.sgc.service.dto.ColaboradorDTO;
import com.basis.sgc.service.dto.ColaboradorListDTO;
import com.basis.sgc.service.dto.DropdownDTO;
import com.basis.sgc.service.mapper.ColaboradorCompetenciaMapper;
import com.basis.sgc.service.mapper.ColaboradorMapper;
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
public class ColaboradorService {

    ColaboradorMapper colaboradorMapper;

    ColaboradorRepository colaboradorRepository;

    ColaboradorCompetenciaMapper colaboradorCompetenciaMapper;

    ColaboradorCompetenciaRepository colaboradorCompetenciaRepository;

    ColaboradorCompetenciaService colaboradorCompetenciaService;

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
