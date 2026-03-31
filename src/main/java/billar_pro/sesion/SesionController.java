package billar_pro.sesion;

import org.springframework.web.bind.annotation.*;
import billar_pro.sesion.SesionService;
import java.util.List;


@RestController
@RequestMapping("/api/sesiones")
public class SesionController {

    private final SesionService sesionService;

    public SesionController(SesionService sesionService){this.sesionService = sesionService;}

    @GetMapping
    public List<Sesion> obtenerTodos(){
        return sesionService.obtenerTodos();
    }


}
