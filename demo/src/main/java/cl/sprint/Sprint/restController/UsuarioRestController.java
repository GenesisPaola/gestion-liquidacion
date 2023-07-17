package cl.sprint.Sprint.restController;

import cl.sprint.Sprint.entity.Usuario;
import cl.sprint.Sprint.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioRestController {
    @Autowired
    IUsuarioService objUsuarioService;
    @PostMapping //tipo de request //enviar info
    public Usuario crearUsuario(@RequestBody Usuario usuario){
        return objUsuarioService.crearUsuario(usuario);
    }

    //registrar usuario
    @PostMapping("/registrar")
    public Usuario registrarUsuario(@RequestBody Usuario usuario){
        return objUsuarioService.registrarUsuario(usuario);
    }

    @GetMapping("/{idUsuario}")//traer info
    public Usuario buscarUsuarioPorId(@PathVariable int idUsuario){
        return objUsuarioService.buscarUsuarioPorId(idUsuario);
    }
    @GetMapping
    public List<Usuario> listarUsuarios(){
        return objUsuarioService.listarUsuarios();
    }
    @PutMapping("/{idUsuario}")
    public Usuario actualizarUsuario(@RequestBody Usuario usuarioActualizar,@PathVariable int idUsuario){
        return objUsuarioService.actualizarUsuario(usuarioActualizar,idUsuario);
    }
    @DeleteMapping //eliminar
    public void eliminarUsuario(@RequestBody Usuario usuario){
        objUsuarioService.eliminarUsuario(usuario);
    }
    @DeleteMapping("/{idUsuario}")
    public void eliminarUsuario2(@PathVariable int idUsuario){
        objUsuarioService.eliminarUsuario2(idUsuario);
    }
}
