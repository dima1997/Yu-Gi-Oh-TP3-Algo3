import java.awt.*;
import java.util.ArrayList;

public class Jugador {

    private final Campo campo;
    private int vida;
    private String nombre;
    private ArrayList<EfectoSobreMonstruo> efectosDeCampo;

    public Jugador(String nombre, int vida) {
        this.vida = vida;
        this.nombre = nombre;
        this.campo = new Campo();
        this.efectosDeCampo = new ArrayList<EfectoSobreMonstruo>();
    }

    public Jugador(String nombre, int vida, Campo campoJugador){
        this.vida = vida;
        this.nombre = nombre;
        this.campo = campoJugador;
        this.efectosDeCampo = new ArrayList<EfectoSobreMonstruo>();
    }

    public void recibirAtaque(int puntosRestarAtacante) {

        this.vida = this.vida - puntosRestarAtacante;

    }

    public int verVida() {

        return this.vida;

    }

    public void colocarCarta(Monstruo unMonstruo) {
        unMonstruo.colocarEnCampo(this.campo);
    }

    public void aplicarEfectoSobreCampo(EfectoSobreCampo efectoSobreCampo) {
        efectoSobreCampo.activar(this.campo);
    }

    public void agregarEfectoDeCampo(EfectoSobreMonstruo efectoWastelandAtaque) {
        this.efectosDeCampo.add(efectoWastelandAtaque);
    }

    public void aplicarEfectosDeCampo(Monstruo unMonstruo) {
        for (int i=0; i< this.efectosDeCampo.size(); i++){
            EfectoSobreMonstruo efecto = this.efectosDeCampo.get(i);
            efecto.activar(unMonstruo);
        }
    }

    public void desaplicarEfectosDeCampo(Monstruo unMonstruo) {
        for (int i=0; i< this.efectosDeCampo.size(); i++){
            EfectoSobreMonstruo efecto = this.efectosDeCampo.get(i);
            efecto.desactivar(unMonstruo);
        }
    }
}
