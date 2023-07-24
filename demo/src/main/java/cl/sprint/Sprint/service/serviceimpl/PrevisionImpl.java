package cl.sprint.Sprint.service.serviceimpl;

import cl.sprint.Sprint.entity.InstitucionPrevisional;
import cl.sprint.Sprint.repository.IPrevisionRepo;
import cl.sprint.Sprint.service.IPrevisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service("/previsionImpl")
public class PrevisionImpl implements IPrevisionService {
    @Autowired
    IPrevisionRepo objPrevisionRepo;
    @Override
    public List<InstitucionPrevisional> listarPrevision() {
        return objPrevisionRepo.findAll();
    }

    @Override
    public InstitucionPrevisional buscarPrevisionPorId(int idInstPrevision) {
        return objPrevisionRepo.findById(idInstPrevision).orElseThrow(()-> new NoSuchElementException("Institucion no encontrada"));
    }
}
