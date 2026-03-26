package billar_pro.consumo;

import billar_pro.mesa.Mesa;
import billar_pro.mesa.MesaRepository;
import billar_pro.producto.Producto;
import billar_pro.producto.ProductoRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ConsumoService {
    private final ConsumoRepository consumoRepository;
    private final MesaRepository mesaRepository;
    private ProductoRepository productoRepository;

    public ConsumoService(ConsumoRepository consumoRepository,
                          MesaRepository mesaRepository,
                          ProductoRepository productoRepository) {
        this.consumoRepository = consumoRepository;
        this.mesaRepository = mesaRepository;
        this.productoRepository = productoRepository;
    }
    public List<Consumo> obtenerTodos(){
        return consumoRepository.findAll();
    }

    public Consumo registrar (Long mesaId, Long productoId, Integer cantidad){
        Mesa mesa = mesaRepository.findById(mesaId)
                .orElseThrow(()-> new RuntimeException("Mesa no encontrada"));

        Producto producto = productoRepository.findById(productoId)
                .orElseThrow(()-> new RuntimeException("Producto no encontrado"));

        if (!producto.isDisponible()){
            throw new RuntimeException("Producto no disponible");
        }

        Double subtotal = producto.getPrecio() * cantidad;

        Consumo consumo = new Consumo();
        consumo.setMesa(mesa);
        consumo.setProducto(producto);
        consumo.setCantidad(cantidad);
        consumo.setSubtotal(subtotal);
        consumo.setFecha(LocalDateTime.now());


        return consumoRepository.save(consumo);

    }

    public List<Consumo> obtenerPorMesa(Long mesaId){
        Mesa mesa = mesaRepository.findById(mesaId)
                .orElseThrow(()-> new RuntimeException("Mesa no encontrada"));
        return consumoRepository.findByMesa(mesa);
    }


}
