package com.basis.sgc.service;

import com.basis.sgc.domain.Colaborador;
import com.basis.sgc.domain.Competencia;
import com.basis.sgc.repository.ColaboradorRepository;
import com.basis.sgc.repository.CompetenciaRepository;
import com.basis.sgc.service.dto.ColaboradorDTO;
import com.basis.sgc.service.dto.CompetenciaDTO;
import com.basis.sgc.service.mapper.ColaboradorMapper;
import com.basis.sgc.service.mapper.CompetenciaMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ColaboradorService {

    private final ColaboradorMapper colaboradorMapper;

    private final ColaboradorRepository colaboradorRepository;

    public List<ColaboradorDTO> buscar(){

        return colaboradorMapper.toDto(colaboradorRepository.findAll());
    }

    public ColaboradorDTO salvar(ColaboradorDTO colaboradorDTO){

        Colaborador colaborador = colaboradorMapper.toEntity(colaboradorDTO);

        return colaboradorMapper.toDto(colaboradorRepository.save(colaborador));

    }

    public void deletar(Integer id){

        colaboradorRepository.deleteById(id);

    }

}
