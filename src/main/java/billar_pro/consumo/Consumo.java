package billar_pro.consumo;

import billar_pro.mesa.Mesa;
import billar_pro.producto.Producto;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import billar_pro.sesion.Sesion;


@Entity
@Table(name = "consumos")
public class Consumo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "mesa_id", nullable = false)
    private Mesa mesa;

    @ManyToOne
    @JoinColumn(name = "producto_id" , nullable = false)
    private Producto producto;

    @ManyToOne
    @JoinColumn(name = "sesion_id")
    private Sesion sesion;

    @Column(nullable = false)
    private Integer cantidad;

    @Column(nullable = false)
    private Double subtotal;

    @Column(nullable = false)
    private LocalDateTime fecha;

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}

    public Mesa getMesa() {return mesa;}
    public void setMesa(Mesa mesa) {this.mesa = mesa;}


    public Producto getProducto() {return producto;}
    public void setProducto(Producto producto) {this.producto = producto;}


    public Integer getCantidad() {return cantidad;}
    public void setCantidad(Integer cantidad) {this.cantidad = cantidad;}


    public Double getSubtotal() {return  subtotal;}
    public void setSubtotal(Double subtotal) {this.subtotal = subtotal;}

    public LocalDateTime getFecha() {return  fecha;}
    public void setFecha (LocalDateTime fecha) {this.fecha = fecha;}

    public Sesion getSesion() { return sesion; }
    public void setSesion(Sesion sesion) { this.sesion = sesion; }

}
