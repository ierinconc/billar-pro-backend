package billar_pro.producto;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductoService {

    private final ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository){
        this.productoRepository = productoRepository;
    }

    public List<Producto> obtenerTodos(){
        return productoRepository.findAll();
    }

    public Producto obtenerPorId(Long id) {
        return productoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
    }

    public Producto crear (Producto producto) {
        return productoRepository.save(producto);
    }

    public Producto actualizar(Long id, Producto productoNuevo){
        Producto productoExistente = obtenerPorId(id);
        productoExistente.setNombre(productoNuevo.getNombre());
        productoExistente.setCategoria(productoNuevo.getCategoria());
        productoExistente.setPrecio(productoNuevo.getPrecio());
        productoExistente.setDisponible(productoNuevo.isDisponible());
        return productoRepository.save(productoExistente);
    }

    public void eliminar (Long id){
        obtenerPorId(id);
        productoRepository.deleteById(id);
    }

}
