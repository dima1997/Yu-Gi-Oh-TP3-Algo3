
import java.util.ArrayList;


public class Tablero {

    private ArrayList<CartaCampo> cartasDeCampo;

    Tablero(){

        cartasDeCampo = new ArrayList<CartaCampo>();

    }

    public void agregarCartaDeCampo(CartaCampo carta) {

        cartasDeCampo.add(carta);
        carta.activarEfecto();

    }

    public void colocarMonstruoEnPosAtaque(Jugador jugador, Monstruo monstruo) {

        jugador.colocarMosntruoEnPosAtaque(monstruo);
        for (CartaCampo carta: this.cartasDeCampo){
            carta.activarEfectoEnMonstruo(monstruo);
        }


    }

    public void colocarMonstruoEnPosDefensa(Jugador jugador, Monstruo monstruo) {

        jugador.colocarMosntruoEnPosDefensa(monstruo);
        for (CartaCampo carta: this.cartasDeCampo){
            carta.activarEfectoEnMonstruo(monstruo);
        }

    }
}
