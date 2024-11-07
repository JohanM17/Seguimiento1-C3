package supermercadoMain;

import supermercadoDataBase.DataBase;
import supermercadoHilos.Caja;
import supermercadoHilos.Cliente;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {
    public static void main(String[] args) {
        BlockingQueue<Cliente> colaClientes = new LinkedBlockingQueue<>();
        Caja caja1 = new Caja(colaClientes, "Caja 1");
        Caja caja2 = new Caja(colaClientes, "Caja 2");

        caja1.start();
        caja2.start();

        for (int i = 0; i < 10; i++) {
            colaClientes.add(new Cliente());
        }

        DataBase.guardarVenta(caja1.getName(), caja1.getTotalVentas());
        DataBase.guardarVenta(caja2.getName(), caja2.getTotalVentas());
    }
}
