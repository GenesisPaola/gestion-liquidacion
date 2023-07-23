package cl.sprint.Sprint.controller;

import cl.sprint.Sprint.entity.Empleador;
import cl.sprint.Sprint.entity.Usuario;
import cl.sprint.Sprint.service.IEmpleadorService;
import cl.sprint.Sprint.service.IUsuarioService;
import cl.sprint.Sprint.service.serviceimpl.EmpleadorImpl;
import jakarta.persistence.Column;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/empleador")
public class EmpleadorController {
    @Autowired
    IEmpleadorService objEmpleadorService;
    @Autowired
    IUsuarioService objUsuarioService;

    //para listar empl
    @GetMapping
    public String listarEmpleadores(Model moodel){
        List<Empleador> listarEmpleador = objEmpleadorService.listarEmpleadores();
        moodel.addAttribute("empleadores", listarEmpleador);
        return "listarEmpleadores";
    }

    //para crear emple
    @GetMapping ("/crearEmpleador")
    public String mostrarFormCrearEmpleador(Model model){
        List<Usuario> usuarios = objUsuarioService.listarUsuarios();
        model.addAttribute("usuarios", usuarios);
        model.addAttribute("empleador", new Empleador());
        return "formEmpleador";
    }
    @PostMapping("/crearEmpleador")
    public String crearEmpleador(@ModelAttribute Empleador empleador, @RequestParam("usuarioId") int usuarioId){
        Usuario usuario = objUsuarioService.buscarUsuarioPorId(usuarioId);
        empleador.setUsuario(usuario);
        objEmpleadorService.crearEmpleador(empleador);
        return "redirect:/empleador";
    }
    //act emple. met para mostrar el form para buscar un empleador x su id
    @GetMapping("/{idEmpleador}")
    public String buscarEmpleadorPorId(@PathVariable int idEmpleador,Model model){
        Empleador empleador = objEmpleadorService.buscarEmpleadorPorId(idEmpleador);
        model.addAttribute("empleador", empleador);
        return "redirect:/empleador";
    }

    //met para mostrar el form para editar de un empleador x su id
    @PostMapping("/editar/{idEmpleador}")
    public String mostrarFormEditarEmpleador(@PathVariable int idEmpleador, Model model){
        model.addAttribute("empleador", objEmpleadorService.buscarEmpleadorPorId(idEmpleador));
        List<Usuario> usuarios = objUsuarioService.listarUsuarios();
        model.addAttribute("usuarios",usuarios);
        return "editarEmpleador";
    }
    @PostMapping("/actualizar/{idEmpleador}")
    public String actualizarEmpleador(@ModelAttribute Empleador empleador,@PathVariable int idEmpleador, @RequestParam("usuarioId") int usuarioId){
        Usuario usuario = objUsuarioService.buscarUsuarioPorId(usuarioId);
        empleador.setUsuario(usuario);
        objEmpleadorService.actualizarEmpleador(empleador,idEmpleador);
        return "redirect:/empleador";
    }
    //eliminar empl
    @PostMapping("/eliminar/{idEmpleador}")
    public String eliminarEpleadorPorId(@PathVariable int idEmpleador){
        objEmpleadorService.eliminarEmpleador(idEmpleador);
        return "redirect:/empleador";
    }
}
