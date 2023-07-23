package cl.sprint.Sprint.service;

import cl.sprint.Sprint.entity.Empleador;

import java.util.List;

public interface IEmpleadorService {
    List<Empleador> listarEmpleadores();
    Empleador crearEmpleador(Empleador empleador);
    Empleador buscarEmpleadorPorId(int idUsuario);
    Empleador actualizarEmpleador(Empleador empleador, int idEmpleador);
    public void eliminarEmpleador(int idEmpleador);

}
