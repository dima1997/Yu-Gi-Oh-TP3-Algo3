import java.util.LinkedList;

import static java.lang.Math.abs;

class AreaDeCombate {

    private LinkedList <Monstruo> cartasADestruir;
    private int danioAtacante;
    private int danioDefensor;

    void combatir(Jugador atacante, Monstruo monstruoAtacante, Jugador atacado, Monstruo monstruoAtacado){

        int puntosAtacante = monstruoAtacante.obtenerPuntos();
        int puntosAtacado = monstruoAtacado.obtenerPuntos();

        int diferenciaPuntos = puntosAtacante - puntosAtacado;

        if (diferenciaPuntos > 0) {
            this.danioDefensor = diferenciaPuntos;
            this.cartasADestruir.add(monstruoAtacado);
        }

        if (diferenciaPuntos < 0) {
            this.danioAtacante = abs(diferenciaPuntos);
            this.cartasADestruir.add(monstruoAtacante);
        }

        if (diferenciaPuntos == 0) {
            this.cartasADestruir.add(monstruoAtacado);
            this.cartasADestruir.add(monstruoAtacante);

        }

    }

    LinkedList cartasADestruir(){

        return (LinkedList) cartasADestruir.clone();

    }

    int danioAtacante(){

        return this.danioAtacante;

    }

    int danioDefensor(){

        return this.danioDefensor;
    }


}
