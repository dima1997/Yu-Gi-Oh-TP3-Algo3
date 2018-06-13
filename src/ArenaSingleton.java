import java.util.ArrayList;
import java.util.LinkedList;

class ArenaSingleton {
    private static ArenaSingleton INSTANCE = null;

    private ArrayList<Carta> cartas;
    private ArrayList<Carta> cementerio;

     private ArenaSingleton(){
        this.cartas = new ArrayList<Carta>();
        this.cementerio = new ArrayList<Carta>();
    }

    private synchronized static void createInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ArenaSingleton();
        }
    }

    public static ArenaSingleton getInstance() {
        if (INSTANCE == null) createInstance();
        return INSTANCE;
    }


    void colocarCarta(Carta unaCarta) {

        this.cartas.add(unaCarta);

    }

    boolean contiene(Carta unaCarta) {

        return this.cartas.contains(unaCarta);

    }

    void enviarAlCementerio(Carta unaCarta) {

        this.cementerio.add(unaCarta);

    }

    boolean estaEnElCementerio(Carta unaCarta) {

        return this.cementerio.contains(unaCarta);

    }

    void hacerCombatir(Jugador jugadorAtacante, Monstruo monstruoAtacante, Jugador jugadorDefensor, Monstruo monstruoDefensor) {
        AreaDeCombate unCombate = new AreaDeCombate(jugadorAtacante, monstruoAtacante, jugadorDefensor, monstruoDefensor);

        unCombate.combatir();

        LinkedList<Carta> cartasADestruir = unCombate.cartasADestruir();

        for (int i = 0; i < cartasADestruir.size(); i++) {
        	Carta unaCarta = cartasADestruir.get(i);
        	this.cartas.remove(unaCarta);
        	this.enviarAlCementerio(unaCarta);
        }

        int puntosRestarAtacante = unCombate.danioAtacante();
        int puntosRestarDefensor = unCombate.danioDefensor();

        jugadorAtacante.recibirAtaque(puntosRestarAtacante);
        jugadorDefensor.recibirAtaque(puntosRestarDefensor);
    }

    public void destruirTodas() {
        for (Carta unaCarta: this.cartas) {
            this.enviarAlCementerio(unaCarta);
        }
        this.cartas.clear();
    }
}
