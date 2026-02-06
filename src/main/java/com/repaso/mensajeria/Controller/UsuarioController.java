package com.repaso.mensajeria.Controller;

import com.repaso.mensajeria.Model.Usuario;
import com.repaso.mensajeria.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping(value = "/guardar")
    public ResponseEntity<String> guardarUsuario(@RequestBody Usuario usuario){
        try {
            usuarioService.guardarUsuario(usuario);
            return ResponseEntity.status(200).body("Usuario creado correctamente");
        }catch (Exception e){
            return ResponseEntity.status(500).body("Error al crear el usuario");
        }
    }

    @GetMapping(value = "/obtener")
    public ResponseEntity<List<Usuario>> obtenerUsuarios(){
        return ResponseEntity.ok(usuarioService.obtenerUsuarios());
    }

}
