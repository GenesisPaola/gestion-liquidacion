package cl.sprint.Sprint.service.serviceimpl;

import cl.sprint.Sprint.entity.InstitucionSalud;
import cl.sprint.Sprint.repository.ISaludRepo;
import cl.sprint.Sprint.service.ISaludService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service("saludImpl")
public class SaludImpl implements ISaludService {
    @Autowired
    ISaludRepo objSaludRepo;
    @Override
    public List<InstitucionSalud> listarSalud() {
        return objSaludRepo.findAll();
    }

    @Override
    public InstitucionSalud buscarSaludPorId(int idInstSalud) {
        return objSaludRepo.findById(idInstSalud).orElseThrow(()-> new NoSuchElementException("Institucion no encontrada"));
    }
}
