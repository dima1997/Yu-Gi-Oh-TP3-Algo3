import java.util.ArrayList;
import java.util.LinkedList;

class Arena {
    private ArrayList<Carta> cartas;
    private ArrayList<Carta> cementerio;

    Arena(){
        this.cartas = new ArrayList<Carta>();
        this.cementerio = new ArrayList<Carta>();
    }

    void colocarCarta(Carta unaCarta) {

        this.cartas.add(unaCarta);

    }

    boolean contiene(Carta unaCarta) {

        return this.cartas.contains(unaCarta);

    }

    private void enviarAlCementario(Carta unaCarta) {

        this.cementerio.add(unaCarta);

    }

    boolean estaEnElCementerio(Carta unaCarta) {

        return this.cementerio.contains(unaCarta);

    }

    void hacerCombatir(Jugador jugadorAtacante, Monstruo monstruoAtacante, Jugador jugadorDefensor, Monstruo monstruoDefensor) {
        AreaDeCombate unCombate = new AreaDeCombate();

        unCombate.combatir(jugadorAtacante, monstruoAtacante, jugadorDefensor, monstruoDefensor);

        LinkedList<Carta> cartasADestruir = unCombate.cartasADestruir();

        for (int i = 0; i < cartasADestruir.size(); i++) {
        	Carta unaCarta = cartasADestruir.get(i);
        	this.cartas.remove(unaCarta);
        	this.enviarAlCementario(unaCarta);
        }

        int puntosRestarAtacante = unCombate.danioAtacante();
        int puntosRestarDefensor = unCombate.danioDefensor();

        jugadorAtacante.recibirAtaque(puntosRestarAtacante);
        jugadorDefensor.recibirAtaque(puntosRestarDefensor);
    }

}
