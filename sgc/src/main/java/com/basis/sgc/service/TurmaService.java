package com.basis.sgc.service;

import com.basis.sgc.domain.Turma;
import com.basis.sgc.domain.TurmaColaboradorCompetencia;
import com.basis.sgc.repository.TurmaColaboradorCompetenciaRepository;
import com.basis.sgc.repository.TurmaRepository;
import com.basis.sgc.service.dto.TurmaColaboradorCompetenciaDTO;
import com.basis.sgc.service.dto.TurmaDTO;
import com.basis.sgc.service.dto.TurmaListDTO;
import com.basis.sgc.service.mapper.TurmaColaboradorCompetenciaMapper;
import com.basis.sgc.service.mapper.TurmaMapper;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.REQUIRED)
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class TurmaService {

    TurmaMapper turmaMapper;

    TurmaRepository turmaRepository;

    TurmaColaboradorCompetenciaRepository turmaColaboradorCompetenciaRepository;

    TurmaColaboradorCompetenciaMapper turmaColaboradorCompetenciaMapper;

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

        List<TurmaColaboradorCompetencia> turmaColaboradorCompetencias = turmaDTO.getTurmas().stream().map(
                colaborador -> turmaColaboradorCompetenciaMapper.toEntity(new TurmaColaboradorCompetenciaDTO(turma.getId(), colaborador.getIdColaborador(), colaborador.getIdCompetencia())
        )).collect(Collectors.toList());

         turmaColaboradorCompetenciaRepository.saveAll(turmaColaboradorCompetencias);
    }

    public void deletar(Integer id){
        turmaRepository.deleteById(id);
    }
}
