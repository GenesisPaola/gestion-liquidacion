package cl.sprint.Sprint.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "empleador")
public class Empleador {
    @Id
    @Column(nullable = false, name = "id_empleador")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEmpleador;

    @Column(nullable = false, unique = true)
    private int run;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = false, name = "apellido_1", length = 100)
    private String apellido1;

    @Column(name = "apellido_2", length = 100)
    private String apellido2;

    @Column(length = 500)
    private String direccion;

    @Column(length = 100)
    private String email;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    @Column
    private long telefono;

    //relacion muchos a muchos table intermedia

    @ManyToMany(mappedBy = "listaEmpleadores")
    private List<Trabajador> trabajadores;
}
