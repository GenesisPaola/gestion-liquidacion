package cl.sprint.Sprint.repository;

import cl.sprint.Sprint.entity.InstitucionSalud;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISaludRepo extends JpaRepository<InstitucionSalud, Integer> {
}
