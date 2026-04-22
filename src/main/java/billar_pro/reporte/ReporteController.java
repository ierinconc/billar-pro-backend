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

    @GetMapping("/ingresos-por-mesa/diario")
    public List<IngresoPorMesaDTO> ingresosPorMesaDiario(@RequestParam LocalDate fecha) {
        return reporteService.ingresosPorMesaDiario(fecha);
    }

    @GetMapping("/ingresos-por-mesa/semanal")
    public List<IngresoPorMesaDTO> ingresosPorMesaSemanal(@RequestParam LocalDate inicio, @RequestParam LocalDate fin) {
        return reporteService.ingresosPorMesaSemanal(inicio, fin);
    }

    @GetMapping("/ingresos-por-mesa/mensual")
    public List<IngresoPorMesaDTO> ingresosPorMesaMensual(@RequestParam int mes, @RequestParam int anio) {
        return reporteService.ingresosPorMesaMensual(mes, anio);
    }

    @GetMapping("/ingresos-por-dia")
    public List<IngresoPorDiaDTO> ingresosPorDia(@RequestParam LocalDate inicio, @RequestParam LocalDate fin) {
        return reporteService.ingresosPorDia(inicio, fin);
    }

    @GetMapping("/productos-top/diario")
    public List<ProductoTopDTO> productosTopDiario(@RequestParam LocalDate fecha) {
        return reporteService.productosTopDiario(fecha);
    }

    @GetMapping("/productos-top/semanal")
    public List<ProductoTopDTO> productosTopSemanal(@RequestParam LocalDate inicio, @RequestParam LocalDate fin) {
        return reporteService.productosTopSemanal(inicio, fin);
    }

    @GetMapping("/productos-top/mensual")
    public List<ProductoTopDTO> productosTopMensual(@RequestParam int mes, @RequestParam int anio) {
        return reporteService.productosTopMensual(mes, anio);
    }

}
