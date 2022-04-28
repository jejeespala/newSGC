package com.basis.sgc.service;

import com.basis.sgc.domain.Categoria;
import com.basis.sgc.repository.CategoriaRepository;
import com.basis.sgc.service.dto.DropdownDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

class CategoriaServiceTest {

    public static final Integer ID = 1;
    public static final String NOME = "Categoria Nova";
    public static final Integer INDEX = 0;

    @InjectMocks
    private CategoriaService categoriaService;

    @Mock
    private CategoriaRepository categoriaRepository;


    private Categoria categoria;
    private DropdownDTO dropdownDTO;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        iniciarCategoria();
    }

    @Test
    void buscar() {
    }

    @Test
    void quandoBuscarPorTodosEntaoRetorneUmaCategoria() {
        when(categoriaService.buscar()).thenReturn(List.of(dropdownDTO));

        List<DropdownDTO> response = categoriaService.buscar();

        assertNotNull(response);
        assertEquals(1, response.size());
        assertEquals(DropdownDTO.class, response.get(INDEX).getClass());

        assertEquals(ID, response.get(INDEX).getValue());
        assertEquals(NOME, response.get(INDEX).getLabel());

    }

    private void iniciarCategoria(){
        categoria = new Categoria(ID, NOME);
        dropdownDTO = new DropdownDTO(NOME, ID);
    }
}
