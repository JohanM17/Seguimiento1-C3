package supermercadoHilos;

import supermercadoEnumeraciones.Articulo;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Cliente {
    private final List<Articulo> cesta;

    public Cliente() {
        cesta = new ArrayList<>();
        generarCestaAleatoria();
    }

    private void generarCestaAleatoria() {
        Random random = new Random();
        Articulo[] articulos = Articulo.values();
        int cantidad = random.nextInt(5) + 1;

        for (int i = 0; i < cantidad; i++) {
            cesta.add(articulos[random.nextInt(articulos.length)]);
        }
    }

    public List<Articulo> getCesta() {
        return cesta;
    }

    public double calcularTotal() {
        return cesta.stream().mapToDouble(Articulo::getPrecio).sum();
    }
}
