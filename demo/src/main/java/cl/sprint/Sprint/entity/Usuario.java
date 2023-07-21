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
    @Column(nullable = false, name = "id_usuario")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUsuario;

    @Column(unique = true, nullable = false)
    private int run;

    @Column(length = 200, nullable = false)
    private String clave;

    @Column(length = 100, nullable = false)
    private String nombre;

    @Column(length = 100, nullable = false, name = "apellido_1")
    private String apellido1;

    @Column(length = 100, name ="apellido_2")
    private String apellido2;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_perfil",nullable = false) //se utiliza para especificar la columna de la tabla de la base de datos que se utilizará para establecer la relación.
    private Perfil perfil;

    @Column(length = 100, nullable = false)
    private String email;

    @Column(nullable = false,name = "fecha_creacion")
    private LocalDateTime fechaCreacion;

    @Column
    private long telefono;

    @OneToMany(mappedBy = "usuario")
    private List<Empleador> empleadores;
}
