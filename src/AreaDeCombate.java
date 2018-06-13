import java.util.LinkedList;

import static java.lang.Math.abs;

class AreaDeCombate {

    private LinkedList <Monstruo> cartasADestruir;
    private Monstruo monstruoAtacado;
    private Monstruo monstruoAtacante;

    AreaDeCombate (Jugador atacante, Monstruo monstruoAtacante, Jugador atacado, Monstruo monstruoAtacado){

        this.monstruoAtacado = monstruoAtacado;
        this.monstruoAtacante = monstruoAtacante;
        this.cartasADestruir = new LinkedList<Monstruo>();

    }

    void combatir(){

        if (this.monstruoAtacado.esDestruidoPor(this.monstruoAtacante)){
            this.cartasADestruir.add(this.monstruoAtacado);
        }

        if (this.monstruoAtacante.esDestruidoPor(this.monstruoAtacado)){
            this.cartasADestruir.add(this.monstruoAtacante);
        }

    }


    LinkedList cartasADestruir(){

        return (LinkedList) cartasADestruir.clone();

    }

    int danioAtacante(){

        return this.monstruoAtacado.danioContra(this.monstruoAtacante);
    }

    int danioDefensor(){

        return this.monstruoAtacante.danioContra(this.monstruoAtacado);
    }


}
