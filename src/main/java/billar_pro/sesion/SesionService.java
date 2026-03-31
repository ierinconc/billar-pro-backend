package billar_pro.sesion;

import billar_pro.mesa.Mesa;
import billar_pro.consumo.Consumo;
import org.springframework.stereotype.Service;
import billar_pro.mesa.MesaRepository;
import billar_pro.consumo.ConsumoRepository;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


@Service
public class SesionService {
    private final ConsumoRepository consumoRepository;
    private final MesaRepository mesaRepository;
    private final SesionRepository sesionRepository;

    public SesionService(ConsumoRepository consumoRepository,
                         MesaRepository mesaRepository,
                         SesionRepository sesionRepository){
        this.consumoRepository = consumoRepository;
        this.sesionRepository = sesionRepository;
        this.mesaRepository = mesaRepository;
    }

    public List<Sesion> obtenerTodos() {return sesionRepository.findAll();}

    public Sesion guardarSesion(Mesa mesa, LocalDateTime horaInicio, LocalDateTime horaFin){
        List<Consumo> consumos = consumoRepository.findByMesa(mesa);

        double totalConsumos = 0.0;

        double horas = Duration.between(horaInicio, horaFin).toMinutes() / 60.0;
        double totalMesa = horas * mesa.getPrecioPorHora();
        for (Consumo consumo: consumos){
            totalConsumos = totalConsumos + consumo.getSubtotal();
        }

        Sesion sesion = new Sesion();
        sesion.setMesa(mesa);
        sesion.setHoraInicio(horaInicio);
        sesion.setHoraFin(horaFin);
        sesion.setHorasJugadas(horas);
        sesion.setTotalMesa(totalMesa);
        sesion.setTotalConsumos(totalConsumos);
        sesion.setTotalGeneral(totalMesa + totalConsumos);
        sesion.setFecha(LocalDate.now());
        consumoRepository.deleteAll(consumos);

        return sesionRepository.save(sesion);
    }

}
