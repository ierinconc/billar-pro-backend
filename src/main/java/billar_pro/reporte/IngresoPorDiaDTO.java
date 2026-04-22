package billar_pro.reporte;

import java.time.LocalDate;

public class IngresoPorDiaDTO {
    private LocalDate fecha;
    private Double totalMesas;
    private Double totalConsumos;
    private Double totalGeneral;

    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }

    public Double getTotalMesas() { return totalMesas; }
    public void setTotalMesas(Double totalMesas) { this.totalMesas = totalMesas; }

    public Double getTotalConsumos() { return totalConsumos; }
    public void setTotalConsumos(Double totalConsumos) { this.totalConsumos = totalConsumos; }

    public Double getTotalGeneral() { return totalGeneral; }
    public void setTotalGeneral(Double totalGeneral) { this.totalGeneral = totalGeneral; }
}