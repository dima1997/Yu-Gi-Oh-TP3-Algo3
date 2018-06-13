import java.util.ArrayList;
import java.util.LinkedList;

class ArenaSingleton {
    private static ArenaSingleton INSTANCE = null;

    private ArrayList<Monstruo> cartasMonstruo;
    private ArrayList<Carta> cartasTrampaMagica;
    private ArrayList<Carta> cementerio;

     private ArenaSingleton(){
        this.cartasMonstruo = new ArrayList<Monstruo>();
        this.cartasTrampaMagica = new ArrayList<Carta>();
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


    void colocarTrampaMagica(Carta unaCarta) {

        this.cartasTrampaMagica.add(unaCarta);

    }

    boolean contiene(Carta unaCarta) {

        return (this.cartasMonstruo.contains(unaCarta) || this.cartasTrampaMagica.contains(unaCarta));

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
        	this.cartasMonstruo.remove(unaCarta);
        	this.enviarAlCementerio(unaCarta);
        }

        int puntosRestarAtacante = unCombate.danioAtacante();
        int puntosRestarDefensor = unCombate.danioDefensor();

        jugadorAtacante.recibirAtaque(puntosRestarAtacante);
        jugadorDefensor.recibirAtaque(puntosRestarDefensor);
    }

    void destruirTodas() {
        for (Carta unaCarta: this.cartasMonstruo) {
            this.enviarAlCementerio(unaCarta);
        }
        for (Carta unaCarta: this.cartasTrampaMagica) {
            this.enviarAlCementerio(unaCarta);
        }
        this.cartasMonstruo.clear();
        this.cartasTrampaMagica.clear();
    }

    void sacrificar(int numeroDeSacrificios) {
         int i = numeroDeSacrificios;
         while (i>0) {
            Monstruo monstruoASacrificar = cartasMonstruo.remove(0);
            this.enviarAlCementerio(monstruoASacrificar);
            i--;
        }
    }

    void colocarMonstruo(Monstruo unMonstruo) {

         unMonstruo.sacrificar();
         this.cartasMonstruo.add(unMonstruo);

    }
}
