package arreglos.tienda.modelo;

public class Juego {
    private String nombre;
    private String categoria;
    private int tamanio;
    private double precio;
    private int licenciasDisponibles = -1;
    private int licenciasVendidas;

    public Juego(String nombre, String categoria, int tamanio, double precio, int licenciasDisponibles) {
        setNombre(nombre);
        setCategoria(categoria);
        setTamanio(tamanio);
        setPrecio(precio);
        setLicenciasDisponibles(licenciasDisponibles);
        this.licenciasVendidas = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public int getTamanio() {
        return tamanio;
    }

    public double getPrecio() {
        return precio;
    }

    public int getLicenciasDisponibles() {
        return licenciasDisponibles;
    }

    public int getLicenciasVendidas() {
        return licenciasVendidas;
    }

    public void setNombre(String nombre) {
        if (nombre != null && !nombre.trim().isEmpty()) {
            this.nombre = nombre.trim();
        }
    }

    public void setCategoria(String categoria) {
        if (categoria != null && !categoria.trim().isEmpty()) {
            this.categoria = categoria.trim();
        }
    }

    public void setTamanio(int tamanio) {
        if (tamanio > 0) {
            this.tamanio = tamanio;
        }
    }

    public void setPrecio(double precio) {
        if (Double.isFinite(precio) && precio > 0) {
            this.precio = precio;
        }
    }

    public void setLicenciasDisponibles(int licenciasDisponibles) {
        if (licenciasDisponibles >= 0) {
            this.licenciasDisponibles = licenciasDisponibles;
        }
    }

    public boolean comprar(int cantidad) {
        if (cantidad > 0 && cantidad <= Integer.MAX_VALUE - licenciasDisponibles) {
            licenciasDisponibles += cantidad;
            return true;
        }
        return false;
    }

    public boolean vender(int cantidad) {
        if (cantidad > 0 && cantidad <= licenciasDisponibles
                && cantidad <= Integer.MAX_VALUE - licenciasVendidas) {
            licenciasDisponibles -= cantidad;
            licenciasVendidas += cantidad;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Juego{" +
                "nombre='" + nombre + '\'' +
                ", categoria='" + categoria + '\'' +
                ", tamanio=" + tamanio +
                ", precio=" + precio +
                ", licenciasDisponibles=" + licenciasDisponibles +
                ", licenciasVendidas=" + licenciasVendidas +
                '}';
    }
}
