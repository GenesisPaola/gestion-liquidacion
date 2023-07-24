package cl.sprint.Sprint.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "institucion_prevision")
public class InstitucionPrevisional {
    @Id
    @Column(nullable = false, name = "id_inst_prevision")
    private int idInstPrevision;

    @Column(nullable = false,length = 50)
    private String descripcion;

    @Column(nullable = false,name = "porc_dcto")
    private float porcDcto;

    @OneToMany(mappedBy = "instPrevision")
    List<Trabajador> listaTrabajadores;

    @OneToMany(mappedBy = "idInstPrevisional")
    List<Liquidacion> liquidacionesPrev;
}
