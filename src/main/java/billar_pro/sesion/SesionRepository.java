package billar_pro.sesion;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


@Repository
public interface SesionRepository extends JpaRepository<Sesion, Long>{
    List<Sesion> findByFecha(LocalDate fecha);

    List<Sesion> findByFechaBetween(LocalDate inicio, LocalDate fin);

    @Query("SELECT s FROM Sesion s WHERE MONTH(s.fecha) = :mes AND YEAR(s.fecha) = :anio")
    List<Sesion> findByMesYAnio(@Param("mes")int mes, @Param("anio") int anio);
}

