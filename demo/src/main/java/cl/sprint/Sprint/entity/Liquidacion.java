package cl.sprint.Sprint.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "liquidacion")
public class Liquidacion {
    @Id
    @Column(nullable = false, name = "id_liquidacion")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idLiquidacion;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_trabajador", nullable = false)
    private Trabajador trabajador;

    @Column(nullable = false)
    private LocalDate periodo;

    @Column(nullable = false, name = "sueldo_imponible")
    private int sueldoImponible;

    @Column(nullable = false, name = "sueldo_liquido")
    private int sueldoLiquido;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_inst_salud",nullable = false)
    private InstitucionSalud idInstSalud;

    @Column(nullable = false, name = "monto_inst_salud")
    private int montoInstSalud;


    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_inst_previsional",nullable = false)
    private InstitucionPrevisional idInstPrevisional;

    @Column(nullable = false,name = "monto_inst_previsional")
    private int montoInstPrevisional;

    @Column(nullable = false,name = "total_descuento")
    private int totalDescuento;

    @Column(nullable = false, name = "total_haberes")
    private int totalHaberes;

    @Column(nullable = false)
   private int anticipo;
}
