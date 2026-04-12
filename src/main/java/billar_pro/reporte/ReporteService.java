package billar_pro.reporte;
import billar_pro.sesion.SesionRepository;
import billar_pro.sesion.Sesion;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class ReporteService {
    private final SesionRepository sesionRepository;

    public ReporteService(SesionRepository sesionRepository){
        this.sesionRepository = sesionRepository;
    }

    public ReporteDTO reporteDiario(LocalDate fecha){
        List<Sesion> sesiones = sesionRepository.findByFecha(fecha);

        double totalMesas = 0.0;
        double totalConsumos = 0.0;
        double totalGeneral = 0.0;

        for (Sesion sesion : sesiones) {
            totalMesas = totalMesas + sesion.getTotalMesa();
            totalConsumos = totalConsumos + sesion.getTotalConsumos();
            totalGeneral = totalGeneral + sesion.getTotalGeneral();
        }
        ReporteDTO reporte = new ReporteDTO();
        reporte.setTotalMesas(totalMesas);
        reporte.setTotalConsumos(totalConsumos);
        reporte.setTotalGeneral(totalGeneral);
        reporte.setNumeroSesiones(sesiones.size());
        return reporte;
    }

    public ReporteDTO reporteSemanal(LocalDate inicio,  LocalDate fin){
        List<Sesion> sesiones = sesionRepository.findByFechaBetween(inicio, fin);

        double totalMesas = 0.0;
        double totalConsumos = 0.0;
        double totalGeneral = 0.0;

        for (Sesion sesion : sesiones) {
            totalMesas = totalMesas + sesion.getTotalMesa();
            totalConsumos = totalConsumos + sesion.getTotalConsumos();
            totalGeneral = totalGeneral + sesion.getTotalGeneral();
        }
        ReporteDTO reporte = new ReporteDTO();
        reporte.setTotalMesas(totalMesas);
        reporte.setTotalConsumos(totalConsumos);
        reporte.setTotalGeneral(totalGeneral);
        reporte.setNumeroSesiones(sesiones.size());
        return reporte;
    }

    public ReporteDTO reporteMensual(int mes, int anio){
        List<Sesion> sesiones = sesionRepository.findByMesYAnio(mes, anio);

        double totalMesas = 0.0;
        double totalConsumos = 0.0;
        double totalGeneral = 0.0;

        for (Sesion sesion : sesiones) {
            totalMesas = totalMesas + sesion.getTotalMesa();
            totalConsumos = totalConsumos + sesion.getTotalConsumos();
            totalGeneral = totalGeneral + sesion.getTotalGeneral();
        }
        ReporteDTO reporte = new ReporteDTO();
        reporte.setTotalMesas(totalMesas);
        reporte.setTotalConsumos(totalConsumos);
        reporte.setTotalGeneral(totalGeneral);
        reporte.setNumeroSesiones(sesiones.size());
        return reporte;
    }
}
