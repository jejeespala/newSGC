package com.basis.sgc.service;

import com.basis.sgc.domain.Competencia;
import com.basis.sgc.domain.Turma;
import com.basis.sgc.repository.TurmaRepository;
import com.basis.sgc.service.dto.CompetenciaDTO;
import com.basis.sgc.service.dto.TurmaDTO;
import com.basis.sgc.service.dto.TurmaListDTO;
import com.basis.sgc.service.mapper.TurmaMapper;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class TurmaService {

    private final TurmaMapper turmaMapper;

    private final TurmaRepository turmaRepository;

    public List<TurmaListDTO> buscar(){
        return turmaRepository.buscar();
    }

    public TurmaDTO buscarPorId(Integer id){
        Turma turma = turmaRepository.findById(id).orElseThrow(()->new RuntimeException("Turma não encontrada!"));
        return turmaMapper.toDto(turma);
    }

    public TurmaDTO salvar(TurmaDTO turmaDTO){
        Turma turma = turmaMapper.toEntity(turmaDTO);
        return turmaMapper.toDto(turmaRepository.save(turma));
    }

    public void deletar(Integer id){
        turmaRepository.deleteById(id);
    }
}
