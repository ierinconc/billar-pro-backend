package billar_pro.sesion;

import billar_pro.mesa.Mesa;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "sesiones")
public class Sesion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name ="mesa_id", nullable = false)
    private Mesa mesa;

    @Column(nullable = false)
    private LocalDateTime horaInicio;

    @Column(nullable = false)
    private LocalDateTime horaFin;

    @Column(nullable = false)
    private Double horasJugadas;

    @Column(nullable = false)
    private Double totalMesa;

    @Column (nullable = false)
    private Double totalConsumos;


    @Column(nullable = false)
    private Double totalGeneral;

    @Column (nullable = false)
    private LocalDate fecha;


    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}

    public Mesa getMesa() {return mesa;}
    public void setMesa(Mesa mesa) {this.mesa = mesa;}

    public LocalDateTime getHoraInicio() {return horaInicio;}
    public void setHoraInicio(LocalDateTime horaInicio) {this.horaInicio = horaInicio;}

    public LocalDateTime getHoraFin() {return horaFin;}
    public void setHoraFin(LocalDateTime horaFin) {this.horaFin = horaFin;}

    public Double getHorasJugadas() {return horasJugadas;}
    public void setHorasJugadas(Double horasJugadas) {this.horasJugadas = horasJugadas;}

    public Double getTotalMesa() {return totalMesa;}
    public void setTotalMesa(Double totalMesa) {this.totalMesa = totalMesa;}

    public Double getTotalConsumos() {return totalConsumos;}
    public void setTotalConsumos(Double totalConsumos) {this.totalConsumos = totalConsumos;}

    public Double getTotalGeneral() {return totalGeneral;}
    public void setTotalGeneral(Double totalGeneral) {this.totalGeneral = totalGeneral;}

    public LocalDate getFecha() {return fecha;}
    public void setFecha(LocalDate fecha) {this.fecha = fecha;}
}
