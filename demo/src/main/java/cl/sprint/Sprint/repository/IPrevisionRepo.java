package cl.sprint.Sprint.repository;

import cl.sprint.Sprint.entity.InstitucionPrevisional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPrevisionRepo extends JpaRepository<InstitucionPrevisional,Integer> {
}
