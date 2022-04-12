package com.basis.sgc.service;

import com.basis.sgc.domain.Turma;
import com.basis.sgc.domain.TurmaColaboradorCompetencia;
import com.basis.sgc.repository.TurmaColaboradorCompetenciaRepository;
import com.basis.sgc.repository.TurmaRepository;
import com.basis.sgc.service.dto.TurmaDTO;
import com.basis.sgc.service.dto.TurmaListDTO;
import com.basis.sgc.service.mapper.TurmaColaboradorCompetenciaMapper;
import com.basis.sgc.service.mapper.TurmaMapper;
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

    private final TurmaColaboradorCompetenciaRepository turmaColaboradorCompetenciaRepository;

    private final TurmaColaboradorCompetenciaMapper turmaColaboradorCompetenciaMapper;

    public List<TurmaListDTO> buscar(){
        return turmaRepository.buscar();
    }

    public TurmaDTO buscarPorId(Integer id){
        Turma turma = turmaRepository.findById(id).orElseThrow(()->new RuntimeException("Turma não encontrada!"));
        return turmaMapper.toDto(turma);
    }

    public void salvar(TurmaDTO turmaDTO){

        Turma turma = turmaMapper.toEntity(turmaDTO);
        turmaRepository.save(turma);

        turmaDTO.getTurmas().stream().forEach(
                colaborador -> colaborador.setId_colaborador(turma.getId())
        );

        List<TurmaColaboradorCompetencia> turmaColaboradorCompetencias = turmaColaboradorCompetenciaMapper.toEntity(turmaDTO.getTurmas());

        turmaColaboradorCompetenciaRepository.saveAll(turmaColaboradorCompetencias);
    }

    public void deletar(Integer id){
        turmaRepository.deleteById(id);
    }
}
