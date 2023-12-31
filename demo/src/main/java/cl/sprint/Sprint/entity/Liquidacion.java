package cl.sprint.Sprint.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
@Entity
@Table(name = "liquidacion")
public class Liquidacion {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_liquidacion;

    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_trabajador", nullable = false)
    private Trabajador trabajador;

    @Column(nullable = false)
    private LocalDate periodo;

    @Column(nullable = false)
    private int sueldo_imponible;

    @Column(nullable = false)
    private int sueldo_liquido;

    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_inst_salud",nullable = false)
    private InstitucionSalud idInstSalud;

    @Column(nullable = false)
    private int monto_inst_salud;


    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_inst_previsional",nullable = false)
    private InstitucionPrevisional idInstPrevisional;

    @Column(nullable = false)
    private int monto_inst_previsional;

    @Column(nullable = false)
    private int total_descuento;

    @Column(nullable = false)
    private int total_haberes;

    @Column(nullable = false)
   private int anticipo;
}
