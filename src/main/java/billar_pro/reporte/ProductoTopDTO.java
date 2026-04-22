package billar_pro.reporte;

public class ProductoTopDTO {
    private String nombre;
    private Integer cantidadVendida;
    private Double totalRecaudado;

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public Integer getCantidadVendida() { return cantidadVendida; }
    public void setCantidadVendida(Integer cantidadVendida) { this.cantidadVendida = cantidadVendida; }

    public Double getTotalRecaudado() { return totalRecaudado; }
    public void setTotalRecaudado(Double totalRecaudado) { this.totalRecaudado = totalRecaudado; }
}