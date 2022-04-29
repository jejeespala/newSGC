package com.basis.sgc.service;

import com.basis.sgc.domain.*;
import com.basis.sgc.repository.ColaboradorRepository;
import com.basis.sgc.service.dto.*;
import com.basis.sgc.service.mapper.ColaboradorMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

class ColaboradorServiceTest {

    @InjectMocks
    private ColaboradorService colaboradorService;

    @Mock
    private ColaboradorRepository colaboradorRepository;

    @Mock
    private ColaboradorMapper colaboradorMapper;

    private Colaborador colaborador;
    private DropdownDTO categoriaDTO;
    private ColaboradorListDTO colaboradorListDTO;
    private ColaboradorDTO colaboradorDTO;
    private Senioridade senioridade;
    private ColaboradorCompetencia colaboradorCompetencia;
    private TurmaColaboradorCompetencia turmaColaboradorCompetencia;
    private Competencia competencia;
    private CompetenciaDTO competenciaDTO;
    private Categoria categoria;
    private Nivel nivel;
    private ColaboradorCompetenciaChave colaboradorCompetenciaChave;
    private List<ColaboradorCompetencia> colaboradorCompetencias;
    private List<ColaboradorCompetenciaDTO> colaboradorCompetenciaDTOS;


    @BeforeEach
    void setUp() {
        openMocks(this);
        iniciarColaborador();
    }



    @Test
    void QuandoBuscarPorIDColaboradorRetorneColaborador() {
        //doReturn(Optional.of(colaboradorDTO)).when(colaboradorService.buscarPorId(anyInt()));
        when(colaboradorService.buscarPorId(anyInt())).thenReturn(colaboradorDTO);

        System.out.println(colaboradorDTO.getEmail());

        ColaboradorDTO response = colaboradorService.buscarPorId(1);


    }

    @Test
    void salvar() {
    }

    @Test
    void deletar() {
    }

    @Test
    void QuandoBuscarPorTodosColaboradoresRetorneTodos() {
        when(colaboradorService.buscar()).thenReturn(List.of(colaboradorListDTO));

        List<ColaboradorListDTO> response = colaboradorService.buscar();

        assertNotNull(response);
        assertEquals(1, response.size());
        assertEquals(ColaboradorListDTO.class, response.get(0).getClass());
        assertEquals(1, response.get(0).getId());
        assertEquals("novo colaborador list", response.get(0).getNome());
        assertEquals("email colaborador", response.get(0).getEmail());
        assertEquals("Aquela Senioridade", response.get(0).getSenioridade());
    }

    private void iniciarColaborador(){
        categoria = new Categoria(1, "Nova categoria");
        categoriaDTO = new DropdownDTO("Nova categoria", 1);
        colaborador = new Colaborador(1, "vai", "vai2", "cpf", "email", "foto",
                LocalDate.of(2022,1,1), LocalDate.of(2020,1,1),
                senioridade);
        //turmaColaboradorCompetencia = new TurmaColaboradorCompetencia()
        colaboradorCompetenciaChave = new ColaboradorCompetenciaChave(1,1);
        colaboradorCompetencia = new ColaboradorCompetencia(colaboradorCompetenciaChave, colaborador, competencia, Nivel.CONHECE);
        colaboradorListDTO = new ColaboradorListDTO(1, "novo colaborador list", "email colaborador", "Aquela Senioridade");
        colaboradorCompetenciaDTOS = new ArrayList<>(){{
            add(new ColaboradorCompetenciaDTO(1,1,Nivel.SABE_APLICAR));
        }};
        colaboradorDTO = new ColaboradorDTO(1, "novo colaborador", "sobrenome colaboradar", "cpf colaborador", "emailcolaborador",
                "fotocolaborador", LocalDate.of(2022,1,1), LocalDate.of(2020,1,1), 1, colaboradorCompetenciaDTOS);
        nivel = Nivel.SABE_APLICAR;
        senioridade = new Senioridade(1, "Nova Senioridade");
//        dropdownDTO = new DropdownDTO(NOME, ID);
    }
}
