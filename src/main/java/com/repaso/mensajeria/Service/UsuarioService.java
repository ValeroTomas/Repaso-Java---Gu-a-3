package com.repaso.mensajeria.Service;

import com.repaso.mensajeria.Model.Usuario;
import com.repaso.mensajeria.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

import static org.springframework.util.StringUtils.capitalize;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public void guardarUsuario(Usuario usuario) {
            usuario.setNombre(capitalize(usuario.getNombre()));
            usuarioRepository.saveAndFlush(usuario);
    }

    public List<Usuario> obtenerUsuarios(){
        return usuarioRepository.findAll();
    }
}
