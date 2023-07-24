package cl.sprint.Sprint.service.serviceimpl;

import cl.sprint.Sprint.entity.Trabajador;
import cl.sprint.Sprint.repository.ITrabajadorRepo;
import cl.sprint.Sprint.service.ITrabajadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service("trabajorImpl")
public class TrabajadorImpl implements ITrabajadorService {
    @Autowired
    ITrabajadorRepo objTrabajadorRepo;
    @Override
    public List<Trabajador> listarTrabajadores() {
        return objTrabajadorRepo.findAll();
    }
    @Override
    public Trabajador crearTrabajador(Trabajador trabajador) {
        trabajador.setListaEmpleadores(trabajador.getListaEmpleadores());
        return objTrabajadorRepo.save(trabajador);
    }

    @Override
    public Trabajador buscarTrabajadorId(int idTrabajador) {
        return objTrabajadorRepo.findById(idTrabajador).orElseThrow(()-> new NoSuchElementException("Trabajador no encontrado"));
    }

    @Override
    public Trabajador actualizarTrabajador(Trabajador trabajadorActualizar, int idTrabajador) {
        Trabajador trabajador = objTrabajadorRepo.findById(idTrabajador).orElseThrow(()-> new NoSuchElementException("Trabajador no encontrado"));
        trabajador.setNombre(trabajadorActualizar.getNombre());
        trabajador.setApellido1(trabajadorActualizar.getApellido1());
        trabajador.setEmail(trabajadorActualizar.getEmail());
        trabajador.setInstPrevision(trabajadorActualizar.getInstPrevision());
        trabajador.setInstSalud(trabajadorActualizar.getInstSalud());
        trabajador.setTelefono(trabajadorActualizar.getTelefono());

        return objTrabajadorRepo.save(trabajador);
    }

    @Override
    public void eliminarTrabajador(int idTrabajador) {
        objTrabajadorRepo.deleteById(idTrabajador);

    }
}
