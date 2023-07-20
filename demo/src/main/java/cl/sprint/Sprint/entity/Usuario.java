package cl.sprint.Sprint.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_usuario;

    @Column(unique = true, nullable = false)
    private int run;

    @Column(length = 200, nullable = false)
    private String clave;

    @Column(length = 100, nullable = false)
    private String nombre;

    @Column(length = 100, nullable = false)
    private String apellido_1;

    @Column(length = 100)
    private String apellido_2;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_perfil",nullable = false) //se utiliza para especificar la columna de la tabla de la base de datos que se utilizará para establecer la relación.
    private Perfil perfil;

    @Column(length = 100, nullable = false)
    private String email;

    @Column(nullable = false)
    private LocalDateTime fecha_creacion;

    @Column
    private long telefono;

    @OneToMany(mappedBy = "usuario")
    private List<Empleador> empleadores;
}
