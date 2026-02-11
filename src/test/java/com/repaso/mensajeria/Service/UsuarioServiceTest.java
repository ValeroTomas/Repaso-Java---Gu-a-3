package com.repaso.mensajeria.Service;

import com.repaso.mensajeria.Model.Usuario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UsuarioServiceTest {


    @Autowired
    private UsuarioService usuarioService;

    @Test
    void usuarioCapitalized(){
        Usuario u = new Usuario("juan", "juancito@gmail.com");
        usuarioService.guardarUsuario(u);
        Assertions.assertEquals("Juan", u.getNombre());
    }

    @Test
    void usuarioVacio(){
        Usuario u = new Usuario("", "juancito@gmail.com");
        Assertions.assertThrows(Exception.class, () -> usuarioService.guardarUsuario(u));
    }

    @Test
    void usuarioEmailVacio(){
        Usuario u = new Usuario("juan", "");
        Assertions.assertThrows(Exception.class, () -> usuarioService.guardarUsuario(u));
    }

    @Test
    void usuarioEmailInvalido(){
        Usuario u = new Usuario("juan", "juancito");
        Assertions.assertThrows(Exception.class, () -> usuarioService.guardarUsuario(u));
    }

}
