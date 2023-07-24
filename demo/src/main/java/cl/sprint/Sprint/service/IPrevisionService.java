package cl.sprint.Sprint.service;

import cl.sprint.Sprint.entity.InstitucionPrevisional;

import java.util.List;

public interface IPrevisionService {
    List<InstitucionPrevisional> listarPrevision();
    InstitucionPrevisional buscarPrevisionPorId(int idInstPrevision);
}
