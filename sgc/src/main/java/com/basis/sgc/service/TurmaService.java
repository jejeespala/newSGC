package com.basis.sgc.service;

import com.basis.sgc.domain.Turma;
import com.basis.sgc.repository.TurmaRepository;
import com.basis.sgc.service.dto.TurmaDTO;
import com.basis.sgc.service.mapper.TurmaMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TurmaService {

    private final TurmaMapper turmaMapper;

    private final TurmaRepository turmaRepository;

    public List<TurmaDTO> buscar(){

        return turmaMapper.toDto(turmaRepository.findAll());
    }

    public TurmaDTO salvar(TurmaDTO turmaDTO){

        Turma turma = turmaMapper.toEntity(turmaDTO);

        return turmaMapper.toDto(turmaRepository.save(turma));

    }

    public void deletar(Integer id){

        turmaRepository.deleteById(id);

    }

}
