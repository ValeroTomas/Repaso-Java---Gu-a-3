package com.repaso.mensajeria.Controller;

import com.repaso.mensajeria.Model.Usuario;
import com.repaso.mensajeria.Service.UsuarioService;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping(value = "/guardar")
    public ResponseEntity<String> guardarUsuario(@RequestBody Usuario usuario){

        if (usuario.getNombre().isEmpty() || usuario.getEmail().isEmpty()) {
            return ResponseEntity.badRequest().body("El nombre y el email son obligatorios");
        }

        try {
            usuarioService.guardarUsuario(usuario);
            return ResponseEntity.status(HttpStatus.CREATED).body("Usuario creado correctamente");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Error al crear el usuario");
        }
    }

    @GetMapping(value = "/obtener")
    public ResponseEntity<List<Usuario>> obtenerUsuarios(){
        return ResponseEntity.ok(usuarioService.obtenerUsuarios());
    }

    @GetMapping(value = "/obtener/email")
    public ResponseEntity<Optional<Usuario>> buscarUsuarioPorEmail(@RequestParam String email){
        if (usuarioService.buscarUsuarioPorEmail(email).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        else {
            return ResponseEntity.ok(usuarioService.buscarUsuarioPorEmail(email));
        }
    }
}
