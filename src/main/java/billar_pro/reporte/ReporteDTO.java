package billar_pro.reporte;

public class ReporteDTO {
    private Double totalMesas;
    private Double totalConsumos;
    private Double totalGeneral;
    private Integer numeroSesiones;

    public Double getTotalMesas() {return totalMesas;}
    public void setTotalMesas (Double totalMesas){this.totalMesas = totalMesas;}

    public Double getTotalConsumos() {return totalConsumos;}
    public void setTotalConsumos(Double totalConsumos) {this.totalConsumos = totalConsumos;}

    public Double getTotalGeneral() {return totalGeneral;}
    public void setTotalGeneral(Double totalGeneral) {this.totalGeneral = totalGeneral;}

    public Integer getNumeroSesiones(){return numeroSesiones;}
    public void setNumeroSesiones(Integer numeroSesiones){this.numeroSesiones = numeroSesiones;}

}
