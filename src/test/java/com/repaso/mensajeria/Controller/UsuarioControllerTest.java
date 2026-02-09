package com.repaso.mensajeria.Controller;

import com.repaso.mensajeria.Model.Usuario;
import com.repaso.mensajeria.Service.UsuarioService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

class UsuarioControllerTest {

    private static UsuarioController usuarioController;
    private static UsuarioService usuarioService;

    @BeforeEach
    void setUp() {
        usuarioService = Mockito.mock(UsuarioService.class);
        usuarioController = new UsuarioController(usuarioService);
    }

    @Test
    void guardarUsuarioConEmailDuplicado() {
        Mockito.doThrow(new RuntimeException("duplicado"))
                .when(usuarioService).guardarUsuario(Mockito.any(Usuario.class));

        ResponseEntity<String> response =
                usuarioController.guardarUsuario(new Usuario("Pedrito", "juancito@gmail.com"));

        Assertions.assertEquals(HttpStatus.CONFLICT, response.getStatusCode());
    }

    @Test
    void guardarUsuarioConNombreVacio() {
        ResponseEntity<String> response = usuarioController.guardarUsuario(new Usuario("", "vacio@gmail.com"));
        Assertions.assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

    @Test
    void guardarUsuarioConEmailVacio() {
        ResponseEntity<String> response = usuarioController.guardarUsuario(new Usuario("Vacio", ""));
        Assertions.assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

    @Test
    void obtenerUsuarios() {
        ResponseEntity<List<Usuario>> response = usuarioController.obtenerUsuarios();
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void buscarUsuarioPorEmail() {
        Mockito.when(usuarioService.buscarUsuarioPorEmail("juancito@gmail.com"))
                .thenReturn(Optional.of(new Usuario("Juan", "juancito@gmail.com")));

        ResponseEntity<Optional<Usuario>> response =
                usuarioController.buscarUsuarioPorEmail("juancito@gmail.com");

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
    }


}