package supermercadoHilos;
import java.util.concurrent.BlockingQueue;

public class Caja extends Thread {

    private final BlockingQueue<Cliente> clientes;
    private double totalVentas;
    private int clientesAtendidos;

    public Caja(BlockingQueue<Cliente> clientes, String nombre) {
        super(nombre);
        this.clientes = clientes;
        this.totalVentas = 0;
        this.clientesAtendidos = 0;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Cliente cliente = clientes.take();
                double totalCliente = cliente.calcularTotal();
                totalVentas += totalCliente;
                clientesAtendidos++;
                System.out.println(getName() + " atendió a un cliente. Total del cliente: $" + totalCliente);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println(getName() + " ha finalizado.");
        }
    }

    public double getTotalVentas() {
        return totalVentas;
    }

    public int getClientesAtendidos() {
        return clientesAtendidos;
    }
}
