package cl.sprint.Sprint.repository;

import cl.sprint.Sprint.entity.Empleador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmpleadorRepo extends JpaRepository<Empleador, Integer> {
}
