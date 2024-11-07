package supermercadoEnumeraciones;

public enum Articulo {
    PAN(2.0),
    LECHE(1.5),
    CARNE(5.0),
    VERDURAS(3.0);

    private final double precio;

    Articulo(double precio) {
        this.precio = precio;
    }

    public double getPrecio() {
        return precio;
    }
}
