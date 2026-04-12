package billar_pro.reporte;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.time.LocalDate;
import java.util.List;
import billar_pro.reporte.ReporteService;


@RestController
@RequestMapping("/api/reportes")
public class ReporteController {
    private final ReporteService reporteService;
    public ReporteController(ReporteService reporteService) {this.reporteService = reporteService;}

    @GetMapping("/diario")
    public ReporteDTO reporteDiario (@RequestParam LocalDate fecha){
        return reporteService.reporteDiario(fecha);}

    @GetMapping("/semanal")
    public ReporteDTO reporteSemanal (@RequestParam LocalDate inicio, @RequestParam LocalDate fin){
        return reporteService.reporteSemanal(inicio, fin);
    }

    @GetMapping("/mensual")
    public ReporteDTO reporteMensual (@RequestParam int mes, @RequestParam int anio){
        return reporteService.reporteMensual(mes, anio);
    }

}
