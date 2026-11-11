package arreglos.tienda.modelo;

public class AppStore {
    private static final int MAX = 4;
    private Juego juegos[];
    private int indice;

    public AppStore(){
        juegos = new Juego[MAX];
        indice = -1;
        //cargarDatos();
    }
    public void cargarDatos(){
        agregarJuego(new Juego("Fifa2026","Deportes",15,45,50));
        agregarJuego(new Juego("Roblox","Acción",23,59,80));
    }

    public Juego[] getJuegos() {
        return juegos;
    }

    public int getIndice() {
        return indice;
    }

    public boolean agregarJuego(Juego j){ //en vez del set()
        if(j != null && indice < MAX -1){
            juegos[++indice] = j;
            return true;
        }
        return false;
    }
    public Juego buscarJuego(String nombre){
        if(nombre != null && !nombre.trim().isEmpty()){
            for(int i = 0; i < indice; i++){
                if(juegos[i].getNombre().equalsIgnoreCase(nombre)){
                    return juegos[i];
                }
            }

        }
        return null;
    }
    public boolean comprar(String nombre, int cantidad){
        if(nombre != null && !nombre.trim().isEmpty() && cantidad > 0){
            Juego j1 = buscarJuego(nombre);
            if(j1 != null){
                return j1.comprar(cantidad);
            }
            return false;
        }else
            return false;

    }
    public double vender(String nombre, int cantidad){
        //no valido pq el buscar ya valida el nombre y el vender de juego la cantidad
        Juego j1 = buscarJuego(nombre);
        if(j1 != null){
            if(j1.vender(cantidad)){
                return cantidad * j1.getPrecio();
            }
        }
        return 0;
    }
    public String sacarJuegos(){
        String juegoS = "";
        for(int i = 0; i <= indice; i++){
            juegoS += juegos[i];
            juegoS += "\n";
        }
        return !juegoS.trim().isBlank()?juegoS:"No hay juegos a mostrar";
    }
    public String juegoMasVendido(){
        String nombre = "";
        int masVendido;
        if(indice >= 0){
            nombre = juegos[0].getNombre();
            masVendido = juegos[0].getLicenciasVendidas();
            for(Juego j : juegos){
                if(j != null){
                    if(j.getLicenciasVendidas() > masVendido){
                        nombre = j.getNombre();
                        masVendido = j.getLicenciasVendidas();
                    }
                }else{
                    return nombre;
                }
            }
        }
        return nombre;
    }

}
