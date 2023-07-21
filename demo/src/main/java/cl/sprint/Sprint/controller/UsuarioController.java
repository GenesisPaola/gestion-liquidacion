package cl.sprint.Sprint.controller;

import cl.sprint.Sprint.entity.Usuario;
import cl.sprint.Sprint.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    IUsuarioService objUsuarioService;  //permite que el controlador utilice los métodos proporcionados por el servicio IUsuarioService.

    //listar usuarios
    @GetMapping
    public String listarUsuarios(Model model){
        List<Usuario> listaUsuarios = objUsuarioService.listarUsuarios();
        model.addAttribute("usuarios", listaUsuarios);
        return "listarUsuarios";
    }

    //crear usuarios
    @GetMapping("/crearUsuario")
    public String mostrarFormularioCrearUsuario(Model model){
        return "formUsuario";
    }
    @PostMapping("/crearUsuario")
    public String crearUsuario(@ModelAttribute Usuario usuario){
        usuario.setFechaCreacion(LocalDateTime.now());
        objUsuarioService.crearUsuario(usuario); //se llama al método crearUsuario() del servicio IUsuarioService, que ha sido inyectado en el controlador previamente. El objeto Usuario que recibimos en el método se pasa como argumento a este método del servicio para guardar el nuevo usuario en la base de datos.
        return "redirect:/usuario";
    }

    // registrar usuario sin inicio de sesion con el form de registro
    @GetMapping("/registrar")
    public String mostrarFormularioRegistro(Model model){
        return "registro";
    }
    @PostMapping("/registrar")
    public String registrarUsuario(@ModelAttribute Usuario usuario){
        usuario.setFechaCreacion((LocalDateTime.now()));
        objUsuarioService.registrarUsuario(usuario);
        return "redirect:/login";
    }
    //actualizar usuario
    //metodo para mostrar el form para buscar usuario x id
    @GetMapping("/{idUsuario}")
    public String buscarUsuarioPorId(@PathVariable int idUsuario, Model model) { //se utiliza para capturar el valor del ID del usuario desde la URL y asignarlo a la variable idUsuario.
        Usuario usuario = objUsuarioService.buscarUsuarioPorId(idUsuario); //Este método busca el usuario en la base de datos utilizando el ID proporcionado y devuelve un objeto Usuario
        model.addAttribute("usuario", usuario); //se agrega este objeto Usuario al modelo con el nombre "usuario" usando el método addAttribute() del objeto model
        return "redirect:/usuario";
    }
    // metodo para mostrar el form de editar un usuario x su id
    @PostMapping("/editar/{idUsuario}")
    public String mostrarFormularioEditarUsuario(@PathVariable int idUsuario, Model model){
        model.addAttribute("usuario",objUsuarioService.buscarUsuarioPorId(idUsuario)); //llamo al método buscarUsuarioPorId(idUsuario) del servicio IUsuarioService para obtener el objeto Usuario que se desea editar.
        return "editarUsuario";
    }

    //metodo para actualizar un usuario
    @PostMapping("/actualizar/{idUsuario}")
    public String actualizarUsuario(@ModelAttribute Usuario usuario, @PathVariable int idUsuario){  //@ModelAttribute Usuario usuario y @PathVariable int idUsuario se utilizan para capturar el objeto Usuario con los datos actualizados y el ID del usuario desde la URL, respectivamente.
       objUsuarioService.actualizarUsuario(usuario, idUsuario); //llamo al método actualizarUsuario(usuario, idUsuario) del servicio IUsuarioService, pasando el objeto Usuario actualizado y el ID del usuario para actualizar los datos en la base de datos.
       return "redirect:/usuario";
    }

    //eliminar usuario
    @PostMapping("/eliminar/{idUsuario}")
    public String eliminarUsuarioPorId(@PathVariable int idUsuario) {
        objUsuarioService.eliminarUsuario2(idUsuario);
        return "redirect:/usuario";
    }

}
