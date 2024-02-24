package ar.edu.fie.undef.soporteCOM.interfaces;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ar.edu.fie.undef.soporteCOM.domain.entities.Usuario;
import ar.edu.fie.undef.soporteCOM.infrastructure.UsuarioRepository;

@RestController
public class UsuarioController {

    private final UsuarioRepository usuarioRepository;

    public UsuarioController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @PostMapping("/crearUsuario")
    public ResponseEntity<String> crearUsuario(@RequestBody Usuario usuario) {
        try {
            Usuario savedUsuario = usuarioRepository.save(usuario);
            return new ResponseEntity<>("Usuario creado con éxito con ID: " + savedUsuario.getId(), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al crear el usuario: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Usuario usuario) {
        Usuario foundUsuario = usuarioRepository.findByUsername(usuario.getUsername());
        if (foundUsuario != null && foundUsuario.getPassword().equals(usuario.getPassword())) {
            return new ResponseEntity<>("Login exitoso", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("El usuario no existe o las credenciales son incorrectas", HttpStatus.UNAUTHORIZED);
        }
    }
}