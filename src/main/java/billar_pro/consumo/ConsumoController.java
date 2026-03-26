package billar_pro.consumo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/consumos")
public class ConsumoController {
    private final ConsumoService consumoService;

    public ConsumoController(ConsumoService consumoService){
        this.consumoService = consumoService;
    }

    @GetMapping
    public List<Consumo> obtenerTodos(){
        return consumoService.obtenerTodos();
    }

    @PostMapping
    public ResponseEntity<Consumo> registrar(@RequestBody ConsumoRequest request){
        Consumo consumo = consumoService.registrar(
                request.getMesaId(),
                request.getProductoId(),
                request.getCantidad()
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(consumo);
    }
    @GetMapping("/mesa/{mesaId}")
    public List<Consumo> obtenerPorMesa(@PathVariable Long mesaId) {
        return consumoService.obtenerPorMesa(mesaId);
    }
}
