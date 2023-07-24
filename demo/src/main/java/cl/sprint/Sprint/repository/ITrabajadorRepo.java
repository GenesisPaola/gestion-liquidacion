package cl.sprint.Sprint.repository;

import cl.sprint.Sprint.entity.Trabajador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITrabajadorRepo extends JpaRepository <Trabajador, Integer> {
}
