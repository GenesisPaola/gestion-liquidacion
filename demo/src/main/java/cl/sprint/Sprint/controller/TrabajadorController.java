package cl.sprint.Sprint.controller;

import cl.sprint.Sprint.entity.Empleador;
import cl.sprint.Sprint.entity.InstitucionPrevisional;
import cl.sprint.Sprint.entity.InstitucionSalud;
import cl.sprint.Sprint.entity.Trabajador;
import cl.sprint.Sprint.service.IEmpleadorService;
import cl.sprint.Sprint.service.IPrevisionService;
import cl.sprint.Sprint.service.ISaludService;
import cl.sprint.Sprint.service.ITrabajadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/trabajador")
public class TrabajadorController {
    @Autowired
    ITrabajadorService objTrajadorService;
    @Autowired
    IPrevisionService objPrevisionService;
    @Autowired
    ISaludService objSaludService;
    @Autowired
    IEmpleadorService objEmpleadorService;

    @GetMapping
    public String listarTrabajadores(Model model){
        List<Trabajador> listaTrabajadores = objTrajadorService.listarTrabajadores();
        model.addAttribute("trabajadores",listaTrabajadores);
        return "listarTrabajadores";
    }

    //crear trabajador
    @GetMapping("/crearTrabajador")
    public String mostrarFormCrearTrabajador(Model model){
        List<InstitucionPrevisional> prevision = objPrevisionService.listarPrevision();
        List<InstitucionSalud> salud = objSaludService.listarSalud();
        List<Empleador> empleador = objEmpleadorService.listarEmpleadores();
        model.addAttribute("prevision",prevision);
        model.addAttribute("salud",salud);
        model.addAttribute("empleador",empleador);
        model.addAttribute("trabajador", new Trabajador());
        return "formTrabajador";
    }
    @PostMapping("/crearTrabajador")
    public String crearTrabajador(@ModelAttribute Trabajador trabajador,
                                  @RequestParam("previsionId") int previsionId,
                                  @RequestParam("saludId") int saludId,
                                  @RequestParam("empleadorId") int empleadorId){
        InstitucionPrevisional prevision = objPrevisionService.buscarPrevisionPorId(previsionId);
        InstitucionSalud salud = objSaludService.buscarSaludPorId(saludId);
        Empleador empleador = objEmpleadorService.buscarEmpleadorPorId(empleadorId);
        trabajador.setInstPrevision(prevision);
        trabajador.setInstSalud(salud);
        List<Empleador> listaEmpleadores = new ArrayList<>();
        listaEmpleadores.add(empleador);
        trabajador.setListaEmpleadores(listaEmpleadores);
        objTrajadorService.crearTrabajador(trabajador);
        return "redirect:/trabajador";
    }
    // act trabajador
    @GetMapping("/{idTrabajador}")
    public String buscarTrabajadorPorId(@PathVariable int idTrabajador, Model model){
        Trabajador trabajador = objTrajadorService.buscarTrabajadorId(idTrabajador);
        model.addAttribute("trabajador", trabajador);
        return "redirect:/trabajador";
    }
    @PostMapping("/editar/{idTrabajador}")
    public String mostrarFormTrabajador(@PathVariable int idTrabajador, Model model){
        model.addAttribute("trabajador",objTrajadorService.buscarTrabajadorId(idTrabajador));
        List<InstitucionPrevisional> prevision = objPrevisionService.listarPrevision();
        List<InstitucionSalud> salud = objSaludService.listarSalud();
        List<Empleador> empleador = objEmpleadorService.listarEmpleadores();
        model.addAttribute("prevision",prevision);
        model.addAttribute("salud",salud);
        model.addAttribute("empleador", empleador);
        return "editarTrabajador";
    }
    @PostMapping("/actualizar/{idTrabajador}")
    public String actualizarTrabajador (@ModelAttribute Trabajador trabajador, @PathVariable int idTrabajador,
                                        @RequestParam ("previsionId") int previsionId,
                                        @RequestParam ("saludId") int saludId,
                                        @RequestParam ("empleadorId") int empleadorId){
        InstitucionPrevisional prevision = objPrevisionService.buscarPrevisionPorId(previsionId);
        InstitucionSalud salud = objSaludService.buscarSaludPorId(saludId);
        Empleador empleador = objEmpleadorService.buscarEmpleadorPorId(empleadorId);
        trabajador.setInstPrevision(prevision);
        trabajador.setInstSalud(salud);
        List<Empleador> listaEmpleadores = new ArrayList<>(); //Se crea una nueva lista llamada "listaEmpleadores" que almacenará objetos de la clase "Empleador".
        listaEmpleadores.add(empleador); //se agrega el obj empleador a la lista empleadores
        trabajador.setListaEmpleadores(listaEmpleadores);
        objTrajadorService.actualizarTrabajador(trabajador,idTrabajador);
        return "redirect:/trabajador";
    }

    //eliminar trab
    @PostMapping("/eliminar/{idTrabajador}")
    public String eliminarTrabajadorPorId(@PathVariable int idTrabajador){
        objTrajadorService.eliminarTrabajador(idTrabajador);
        return "redirect:/trabajador";
    }





}
