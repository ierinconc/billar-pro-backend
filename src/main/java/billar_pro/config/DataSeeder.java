package billar_pro.config;

import billar_pro.mesa.Mesa;
import billar_pro.mesa.MesaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataSeeder implements CommandLineRunner {
    private final MesaRepository  mesaRepository;

    public DataSeeder(MesaRepository mesaRepository){
        this.mesaRepository = mesaRepository;
    }

    @Override
    public void run(String... args) throws Exception{
        if(mesaRepository.count() == 0){
            crearMesa(1, 8000.0);
            crearMesa(2, 8000.0);
            crearMesa(3, 6000.0);
            crearMesa(4, 6000.0);
            crearMesa(5, 6000.0);
            crearMesa(6, 6000.0);
            System.out.println("Mesas creadas exitosamente");
        }
    }
    private void crearMesa(int numero, double precio ){
        Mesa mesa = new Mesa();
        mesa.setNumero(numero);
        mesa.setEstado("LIBRE");
        mesa.setPrecioPorHora(precio);
        mesa.setHoraInicio(null);
        mesaRepository.save(mesa);
    }
}



