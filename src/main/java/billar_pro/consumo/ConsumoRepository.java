package billar_pro.consumo;

import billar_pro.mesa.Mesa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.time.LocalDateTime;

@Repository
public interface ConsumoRepository extends JpaRepository<Consumo, Long>{
    List<Consumo> findByMesa(Mesa mesa);
    List<Consumo> findByFechaBetween(LocalDateTime inicio, LocalDateTime fin);
}


