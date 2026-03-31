package billar_pro.mesa;


public class CierreMesaDTO {

    private Double horasJugadas;
    private Double precioPorHora;
    private Double totalAPagar;
    private Double totalConsumos;
    private Double totalGeneral;

    public Double getHorasJugadas(){return horasJugadas;}
    public void setHorasJugadas(Double horasJugadas) {this.horasJugadas = horasJugadas;}

    public Double getPrecioPorHora(){return precioPorHora;}
    public void setPrecioPorHora(Double precioPorHora) {this.precioPorHora = precioPorHora;}

    public Double getTotalAPagar(){ return totalAPagar; }
    public void setTotalAPagar(Double totalAPagar) { this.totalAPagar = totalAPagar;}

    public Double getTotalConsumos(){return totalConsumos;}
    public void setTotalConsumos(Double totalConsumos) {this.totalConsumos = totalConsumos;}

    public Double getTotalGeneral(){return totalGeneral;}
    public  void setTotalGeneral(Double totalGeneral){this.totalGeneral = totalGeneral;}

}
