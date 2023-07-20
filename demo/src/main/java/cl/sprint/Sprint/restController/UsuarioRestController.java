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

    @GetMapping("/{id_usuario}")//traer info
    public Usuario buscarUsuarioPorId(@PathVariable int id_usuario){
        return objUsuarioService.buscarUsuarioPorId(id_usuario);
    }
    @GetMapping
    public List<Usuario> listarUsuarios(){
        return objUsuarioService.listarUsuarios();
    }
    @PutMapping("/{id_usuario}")
    public Usuario actualizarUsuario(@RequestBody Usuario usuarioActualizar,@PathVariable int id_usuario){
        return objUsuarioService.actualizarUsuario(usuarioActualizar,id_usuario);
    }
    @DeleteMapping("/{id_usuario}")
    public void eliminarUsuario2(@PathVariable int id_Usuario){
        objUsuarioService.eliminarUsuario2(id_Usuario);
    }
}
