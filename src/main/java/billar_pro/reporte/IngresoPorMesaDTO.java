package billar_pro.reporte;

public class IngresoPorMesaDTO {
    private Integer numero;
    private Double totalRecaudado;
    private Integer numeroSesiones;

    public Integer getNumero() { return numero; }
    public void setNumero(Integer numero) { this.numero = numero; }

    public Double getTotalRecaudado() { return totalRecaudado; }
    public void setTotalRecaudado(Double totalRecaudado) { this.totalRecaudado = totalRecaudado; }

    public Integer getNumeroSesiones() { return numeroSesiones; }
    public void setNumeroSesiones(Integer numeroSesiones) { this.numeroSesiones = numeroSesiones; }
}