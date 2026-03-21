package billar_pro.mesa;

import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class MesaService {
    private final MesaRepository mesaRepository;

    public MesaService(MesaRepository mesaRepository){
        this.mesaRepository = mesaRepository;
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




}
