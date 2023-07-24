package cl.sprint.Sprint.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "institucion_salud")
public class InstitucionSalud {
        @Id
        @Column(nullable = false, name = "id_inst_salud")
        private int idInstSalud;

        @Column(nullable = false,length = 100)
        private String descripcion;

        @Column(nullable = false, name = "porc_dcto")
        private float porcDcto;

        @OneToMany(mappedBy = "instSalud")
        List<Trabajador> listaTrabajadores;

        @OneToMany(mappedBy = "idInstSalud")
        List<Liquidacion> liquidacionesSalud;
}
