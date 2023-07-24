package cl.sprint.Sprint.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "trabajador")
public class Trabajador {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTrabajador;

    @Column(nullable = false, unique = true)
    private int run;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String apellido1;

    @Column
    private String apellido2;

    @Column
    private String email;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_inst_prevision", nullable = false)
    private InstitucionPrevisional instPrevision;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_inst_salud", nullable = false)
    private InstitucionSalud instSalud;

    @Column(nullable = false)
    private long telefono;

    @OneToMany
    List<Liquidacion> listaTrabajadores;

    @ManyToMany
    @JoinTable(name = "empl_trab",
            joinColumns = @JoinColumn(name = "id_trabajador"),
            inverseJoinColumns = @JoinColumn(name = "id_empleador"))
    private List<Empleador> listaEmpleadores;
}
