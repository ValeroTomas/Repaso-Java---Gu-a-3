package com.repaso.mensajeria.Controller;

import com.repaso.mensajeria.Model.Usuario;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import tools.jackson.databind.ObjectMapper;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class UsuarioControllerTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    @Test
    @Transactional
    void guardarUsuario() throws Exception {
        Usuario u = new Usuario("Juan", "juan@gmail.com");

        mockMvc.perform(MockMvcRequestBuilders.post("/api/usuarios/guardar")
                        .content(objectMapper.writeValueAsString(u))
                        .contentType(MediaType.APPLICATION_JSON))
                        .andExpectAll(status().isCreated());
    }

    @Test
    void obtenerUsuariosVacío() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/usuarios/obtener"))
                .andExpectAll(status().isNotFound());
    }

    @Test
    void obtenerUsuarioInexistente() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/usuarios/obtener/email?email=juancito@gmail.com"))
                .andExpectAll(status().isNotFound());
    }

    @Test
    @Transactional
    void obtenerUsuarioExistente() throws Exception {
        Usuario u = new Usuario("Juan", "juan@gmail.com");
        mockMvc.perform(MockMvcRequestBuilders.post("/api/usuarios/guardar")
                .content(objectMapper.writeValueAsString(u)).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
        mockMvc.perform(MockMvcRequestBuilders.get("/api/usuarios/obtener/email?email=juan@gmail.com"))
                .andExpect(status().isOk());
    }
}