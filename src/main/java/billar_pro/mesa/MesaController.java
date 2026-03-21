package billar_pro.mesa;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/mesas")
public class MesaController {
    private final MesaService mesaService;

    public MesaController(MesaService mesaService) {
        this.mesaService = mesaService;
    }

    @GetMapping
    public List<Mesa> obtenerTodasLasMesas() {
        return mesaService.obtenerTodasLasMesas();
    }

    @PostMapping
    public Mesa crearMesa(@RequestBody Mesa mesa) {
        return mesaService.guardarMesa(mesa);
    }

    @GetMapping("{id}")
    public Mesa obtenerMesaPorId(@PathVariable Long id) {
        return mesaService.obtenerMesaPorId(id);
    }
}
