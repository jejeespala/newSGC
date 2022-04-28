package com.basis.sgc.service;

import com.basis.sgc.domain.*;
import com.basis.sgc.repository.ColaboradorRepository;
import com.basis.sgc.service.dto.ColaboradorDTO;
import com.basis.sgc.service.dto.DropdownDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.time.LocalDate;

import static com.basis.sgc.service.CategoriaServiceTest.NOME;
import static org.junit.jupiter.api.Assertions.*;

class ColaboradorServiceTest {

    @InjectMocks
    private ColaboradorService colaboradorService;

    @Mock
    private ColaboradorRepository colaboradorRepository;

    private Colaborador colaborador;
    private ColaboradorDTO colaboradorDTO;
    private Senioridade senioridade;
    private ColaboradorCompetencia colaboradorCompetencia;
    private TurmaColaboradorCompetencia turmaColaboradorCompetencia;
    private Competencia competencia;
    private Categoria categoria;



    @BeforeEach
    void setUp() {
    }

    @Test
    void buscar() {
    }

    @Test
    void buscarPorId() {
    }

    @Test
    void salvar() {
    }

    @Test
    void deletar() {
    }

    private void iniciarColaborador(){
        categoria = new Categoria(1, "Nova categoria");
        competencia = new Competencia(1, "Nova competencia", "Desc New Comp", categoria )
        colaboradorCompetencia = new ColaboradorCompetencia(1, )
        senioridade = new Senioridade(1, "Nova Senioridade");
        colaborador = new Colaborador(1, "vai", "vai2", "cpf", "email", "foto",
                LocalDate.of(2022,1,1), LocalDate.of(2020,1,1),
                senioridade, );
//        dropdownDTO = new DropdownDTO(NOME, ID);
    }
}
