package arreglos.tienda.modelo;

public class AppStore {
    private static final int MAX = 4;
    private Juego[] juegos;
    private int indice;

    public AppStore() {
        juegos = new Juego[MAX];
        indice = -1;
        cargarDatos();
    }

    private void cargarDatos() {
        agregarJuego(new Juego("Fifa2026", "Deportes", 15, 45, 50));
        agregarJuego(new Juego("Roblox", "Acción", 23, 59, 80));
    }

    public Juego[] getJuegos() {
        return juegos;
    }

    public boolean estaLlena() {
        return indice == MAX - 1;
    }

    public boolean agregarJuego(Juego j) {
        if (j == null || estaLlena()) {
            return false;
        }
        if (j.getNombre() == null || j.getCategoria() == null || j.getTamanio() <= 0
                || !Double.isFinite(j.getPrecio()) || j.getPrecio() <= 0
                || j.getLicenciasDisponibles() < 0 || buscarJuego(j.getNombre()) != null) {
            return false;
        }
        juegos[++indice] = j;
        return true;
    }

    public Juego buscarJuego(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            return null;
        }
        for (int i = 0; i <= indice; i++) {
            if (juegos[i].getNombre().equalsIgnoreCase(nombre.trim())) {
                return juegos[i];
            }
        }
        return null;
    }

    public boolean comprar(String nombre, int cantidad) {
        if (cantidad <= 0) {
            return false;
        }
        Juego juego = buscarJuego(nombre);
        if (juego != null) {
            return juego.comprar(cantidad);
        }
        return false;
    }

    public double vender(String nombre, int cantidad) {
        Juego juego = buscarJuego(nombre);
        if (juego != null && juego.vender(cantidad)) {
            return cantidad * juego.getPrecio();
        }
        return 0;
    }

    public String sacarJuegos() {
        StringBuilder resultado = new StringBuilder();
        for (int i = 0; i <= indice; i++) {
            resultado.append(juegos[i]).append("\n");
        }
        if (resultado.length() == 0) {
            return "No hay juegos a mostrar";
        }
        return resultado.toString();
    }

    public String juegoMasVendido() {
        if (indice < 0) {
            return "No hay juegos registrados";
        }
        Juego masVendido = juegos[0];
        for (int i = 1; i <= indice; i++) {
            if (juegos[i].getLicenciasVendidas() > masVendido.getLicenciasVendidas()) {
                masVendido = juegos[i];
            }
        }
        return masVendido.getNombre();
    }
}
