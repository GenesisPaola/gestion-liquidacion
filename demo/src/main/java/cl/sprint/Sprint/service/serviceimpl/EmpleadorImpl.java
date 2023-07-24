package cl.sprint.Sprint.service.serviceimpl;

import cl.sprint.Sprint.controller.EmpleadorController;
import cl.sprint.Sprint.entity.Empleador;
import cl.sprint.Sprint.repository.IEmpleadorRepo;
import cl.sprint.Sprint.service.IEmpleadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service("empleadorImpl")
public class EmpleadorImpl implements IEmpleadorService {
    @Autowired
    IEmpleadorRepo objEmpleadorRepo;

    @Override
    public List<Empleador> listarEmpleadores() {
        return objEmpleadorRepo.findAll();
    }

    @Override
    public Empleador crearEmpleador(Empleador empleador) {
        return objEmpleadorRepo.save(empleador);
    }

    @Override
    public Empleador buscarEmpleadorPorId(int idEmpleador) {
        return objEmpleadorRepo.findById(idEmpleador).orElseThrow(()->new NoSuchElementException("Empleador no encontrado"));
    }

    @Override
    public Empleador actualizarEmpleador(Empleador empleadorActualizar, int idEmpleador) {
        Empleador empleador = objEmpleadorRepo.findById(idEmpleador).orElseThrow(()-> new NoSuchElementException("Empleador no encontrado"));
        empleador.setNombre(empleadorActualizar.getNombre());
        empleador.setApellido1(empleadorActualizar.getApellido1());
        empleador.setApellido2(empleadorActualizar.getApellido2());
        empleador.setDireccion(empleador.getDireccion());
        empleador.setEmail(empleadorActualizar.getEmail());
        empleador.setUsuario(empleadorActualizar.getUsuario());
        empleador.setTelefono(empleadorActualizar.getTelefono());
        empleador.setTrabajadores(empleadorActualizar.getTrabajadores());
        return objEmpleadorRepo.save(empleador);
    }

    @Override
    public void eliminarEmpleador(int idEmpleador) {
        objEmpleadorRepo.deleteById(idEmpleador);
    }
}
