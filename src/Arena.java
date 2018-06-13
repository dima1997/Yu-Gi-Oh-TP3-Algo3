import java.util.ArrayList;

public class Arena {
    private ArrayList<Carta> cartas;
    private Cementario cementerio;

    Arena(){
        this.cartas = new ArrayList<Carta>();
        this.cementerio = new Cementario();
    }

    public void colocarCarta(Carta unaCarta) {
        this.cartas.add(unaCarta);
    }

    public boolean contiene(Carta unaCarta) {
        return this.cartas.contains(unaCarta);
    }


    public void hacerCombatir(Monstruo monstruoAtacante, Jugador jugadorAtacante, Monstruo monstruoDefensor, Jugador jugadorDefensor) {
        AreaDeCombate unCombate = new AreaDeCombate();
        unCombate.hacerCombatir(monstruoAtacante, jugadorAtacante, monstruoDefensor, jugadorDefensor);
        ArrayList<Carta> cartasADestruir = unCombate.cartasADestruir();
        for (int i = 0; i < cartasADestruir.size(); i++) {
        	Carta unaCarta = cartasADestruir.get(i);
        	this.cartas.remove(unaCarta);
        	this.cementerio.destruir(unaCarta);
        }
        int puntosRestarAtacante = unCombate.DañoAtacante();
        int puntosRestarDefensor = unCombate.DañoDefensor();
        jugadorAtacante.recibirAtaque(puntosRestarAtacante);
        jugadorDefensor.recibirAtaque(puntosRestarDefensor);
    }

    public boolean estaEnElCementerio(Monstruo unMonstruo) {
        return this.cementerio.estaDestruida(unMonstruo);
    }
}
