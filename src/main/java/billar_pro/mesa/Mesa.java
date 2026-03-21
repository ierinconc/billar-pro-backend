package billar_pro.mesa;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table (name="mesas")
public class Mesa {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer numero;

    @Column(nullable = false)
    private String estado;

    @Column(name="precio_por_hora", nullable = false)
    private Double precioPorHora;

    @Column(name= "hora_inicio")
    private LocalDateTime horaInicio;

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id; }

    public Integer getNumero() {return numero;}
    public void setNumero(Integer numero) {this.numero = numero; }

    public String getEstado() {return estado;}
    public void setEstado(String estado) {this.estado = estado; }

    public Double getPrecioPorHora(){return precioPorHora; }
    public void setPrecioPorHora(Double precioPorHora){this.precioPorHora = precioPorHora; }

    public LocalDateTime getHoraInicio(){return horaInicio;}
    public void setHoraInicio(LocalDateTime horaInicio){this.horaInicio = horaInicio; }

}


