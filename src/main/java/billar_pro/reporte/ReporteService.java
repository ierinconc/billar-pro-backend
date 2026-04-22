package billar_pro.reporte;
import billar_pro.sesion.SesionRepository;
import billar_pro.sesion.Sesion;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import billar_pro.consumo.ConsumoRepository;
import billar_pro.consumo.Consumo;
import java.time.LocalDateTime;

@Service
public class ReporteService {
    private final SesionRepository sesionRepository;

    private final ConsumoRepository consumoRepository;

    public ReporteService(SesionRepository sesionRepository, ConsumoRepository consumoRepository){
        this.sesionRepository = sesionRepository;
        this.consumoRepository = consumoRepository;
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
    public List<IngresoPorMesaDTO> ingresosPorMesaDiario(LocalDate fecha) {
        List<Sesion> sesiones = sesionRepository.findByFecha(fecha);
        return agruparPorMesa(sesiones);
    }

    public List<IngresoPorMesaDTO> ingresosPorMesaSemanal(LocalDate inicio, LocalDate fin) {
        List<Sesion> sesiones = sesionRepository.findByFechaBetween(inicio, fin);
        return agruparPorMesa(sesiones);
    }

    public List<IngresoPorMesaDTO> ingresosPorMesaMensual(int mes, int anio) {
        List<Sesion> sesiones = sesionRepository.findByMesYAnio(mes, anio);
        return agruparPorMesa(sesiones);
    }

    private List<IngresoPorMesaDTO> agruparPorMesa(List<Sesion> sesiones) {
        Map<Integer, IngresoPorMesaDTO> mapa = new HashMap<>();

        for (Sesion sesion : sesiones) {
            Integer numeroMesa = sesion.getMesa().getNumero();

            IngresoPorMesaDTO dto = mapa.get(numeroMesa);
            if (dto == null) {
                dto = new IngresoPorMesaDTO();
                dto.setNumero(numeroMesa);
                dto.setTotalRecaudado(0.0);
                dto.setNumeroSesiones(0);
                mapa.put(numeroMesa, dto);
            }

            dto.setTotalRecaudado(dto.getTotalRecaudado() + sesion.getTotalGeneral());
            dto.setNumeroSesiones(dto.getNumeroSesiones() + 1);
        }

        return new ArrayList<>(mapa.values());
    }

    public List<IngresoPorDiaDTO> ingresosPorDia(LocalDate inicio, LocalDate fin) {
        List<Sesion> sesiones = sesionRepository.findByFechaBetween(inicio, fin);

        Map<LocalDate, IngresoPorDiaDTO> mapa = new HashMap<>();

        for (Sesion sesion : sesiones) {
            LocalDate fecha = sesion.getFecha();

            IngresoPorDiaDTO dto = mapa.get(fecha);
            if (dto == null) {
                dto = new IngresoPorDiaDTO();
                dto.setFecha(fecha);
                dto.setTotalMesas(0.0);
                dto.setTotalConsumos(0.0);
                dto.setTotalGeneral(0.0);
                mapa.put(fecha, dto);
            }

            dto.setTotalMesas(dto.getTotalMesas() + sesion.getTotalMesa());
            dto.setTotalConsumos(dto.getTotalConsumos() + sesion.getTotalConsumos());
            dto.setTotalGeneral(dto.getTotalGeneral() + sesion.getTotalGeneral());
        }

        List<IngresoPorDiaDTO> resultado = new ArrayList<>(mapa.values());
        resultado.sort((a, b) -> a.getFecha().compareTo(b.getFecha()));
        return resultado;
    }

    public List<ProductoTopDTO> productosTopDiario(LocalDate fecha) {
        LocalDateTime inicio = fecha.atStartOfDay();
        LocalDateTime fin = fecha.atTime(23, 59, 59);
        List<Consumo> consumos = consumoRepository.findByFechaBetween(inicio, fin);
        return agruparPorProducto(consumos);
    }

    public List<ProductoTopDTO> productosTopSemanal(LocalDate inicio, LocalDate fin) {
        LocalDateTime inicioDT = inicio.atStartOfDay();
        LocalDateTime finDT = fin.atTime(23, 59, 59);
        List<Consumo> consumos = consumoRepository.findByFechaBetween(inicioDT, finDT);
        return agruparPorProducto(consumos);
    }

    public List<ProductoTopDTO> productosTopMensual(int mes, int anio) {
        LocalDate primerDia = LocalDate.of(anio, mes, 1);
        LocalDate ultimoDia = primerDia.withDayOfMonth(primerDia.lengthOfMonth());
        LocalDateTime inicioDT = primerDia.atStartOfDay();
        LocalDateTime finDT = ultimoDia.atTime(23, 59, 59);
        List<Consumo> consumos = consumoRepository.findByFechaBetween(inicioDT, finDT);
        return agruparPorProducto(consumos);
    }

    private List<ProductoTopDTO> agruparPorProducto(List<Consumo> consumos) {
        Map<String, ProductoTopDTO> mapa = new HashMap<>();

        for (Consumo consumo : consumos) {
            String nombre = consumo.getProducto().getNombre();

            ProductoTopDTO dto = mapa.get(nombre);
            if (dto == null) {
                dto = new ProductoTopDTO();
                dto.setNombre(nombre);
                dto.setCantidadVendida(0);
                dto.setTotalRecaudado(0.0);
                mapa.put(nombre, dto);
            }

            dto.setCantidadVendida(dto.getCantidadVendida() + consumo.getCantidad());
            dto.setTotalRecaudado(dto.getTotalRecaudado() + consumo.getSubtotal());
        }

        List<ProductoTopDTO> resultado = new ArrayList<>(mapa.values());
        resultado.sort((a, b) -> b.getCantidadVendida() - a.getCantidadVendida());

        if (resultado.size() > 10) {
            return resultado.subList(0, 10);
        }
        return resultado;
    }

}
