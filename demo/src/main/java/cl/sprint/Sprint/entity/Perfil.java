package cl.sprint.Sprint.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "perfil")
public class Perfil {
    @Id
    @Column(nullable = false)
    private int id_perfil;

    @Column(length = 50, nullable = false)
    private String descripcion;

    @Column(nullable = false)
    private boolean estado;

    @OneToMany(mappedBy = "perfil")
    private List<Usuario> usuarios;
}
