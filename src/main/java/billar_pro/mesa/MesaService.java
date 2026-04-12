package billar_pro.mesa;

import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.time.Duration;
import billar_pro.exception.NegocioException;
import billar_pro.sesion.SesionService;
import billar_pro.sesion.Sesion;

@Service
public class MesaService {

    private final SesionService sesionService;
    private final MesaRepository mesaRepository;

        public MesaService(MesaRepository mesaRepository, SesionService sesionService){
            this.mesaRepository = mesaRepository;
            this.sesionService = sesionService;
        }

        public List<Mesa> obtenerTodasLasMesas(){
            return mesaRepository.findAll();
        }

        public Mesa guardarMesa(Mesa mesa){
            return mesaRepository.save(mesa);
        }

        public Mesa obtenerMesaPorId(Long id){
            return mesaRepository.findById(id)
                    .orElseThrow(()-> new RuntimeException("Mesa no encontrada"));
        }

        public Mesa ocuparMesa(Long id){
            Mesa mesa = obtenerMesaPorId(id);
            if (mesa.getEstado().equals("OCUPADA")){
                throw new NegocioException("La mesa ya está ocupada");
            }
            mesa.setEstado("OCUPADA");
            mesa.setHoraInicio(LocalDateTime.now());
            return mesaRepository.save(mesa);
        }

        public CierreMesaDTO cerrarMesa(Long id){
            Mesa mesa = obtenerMesaPorId(id);

            if (mesa.getEstado().equals("LIBRE")) {
                throw new NegocioException("La mesa ya está libre");
            }
            LocalDateTime ahora = LocalDateTime.now();
            double horas = Duration.between(mesa.getHoraInicio(), ahora).toMinutes() / 60.0;
            double total = horas * mesa.getPrecioPorHora();
            Sesion sesion = sesionService.guardarSesion(mesa, mesa.getHoraInicio(), ahora);

            CierreMesaDTO resultado = new CierreMesaDTO();
            resultado.setHorasJugadas(horas);
            resultado.setPrecioPorHora(mesa.getPrecioPorHora());
            resultado.setTotalAPagar(total);
            resultado.setTotalConsumos(sesion.getTotalConsumos());
            resultado.setTotalGeneral(sesion.getTotalGeneral());

            mesa.setEstado("LIBRE");
            mesa.setHoraInicio(null);
            mesaRepository.save(mesa);
            return resultado;
        }

}

