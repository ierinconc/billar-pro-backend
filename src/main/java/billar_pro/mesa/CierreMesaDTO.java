package billar_pro.mesa;

public class CierreMesaDTO {

    private Double horasJugadas;
    private Double precioPorHora;
    private Double totalAPagar;

    public Double getHorasJugadas(){return horasJugadas;}
    public void setHorasJugadas(Double horasJugadas) {this.horasJugadas = horasJugadas;}

    public Double getPrecioPorHora(){return precioPorHora;}
    public void setPrecioPorHora(Double precioPorHora) {this.precioPorHora = precioPorHora;}

    public Double getTotalAPagar(){ return totalAPagar; }
    public void setTotalAPagar(Double totalAPagar) { this.totalAPagar = totalAPagar;}

}
