import java.util.LinkedList;

import static java.lang.Math.abs;

class AreaDeCombate {

    private LinkedList <Monstruo> cartasADestruir;
    private int danioAtacante = 0;
    private int danioDefensor = 0;

    AreaDeCombate (){

        this.danioDefensor = 0;
        this.danioAtacante = 0;
        this.cartasADestruir = new LinkedList<Monstruo>();

    }

    void combatir(Jugador atacante, Monstruo monstruoAtacante, Jugador atacado, Monstruo monstruoAtacado){
        
        this.danioDefensor = monstruoAtacante.danioContra(monstruoAtacado);
        this.danioAtacante = monstruoAtacado.danioContra(monstruoAtacante);

        this.destruirSiElDanioEsCero(danioDefensor, monstruoAtacado);
        this.destruirSiElDanioEsCero(danioAtacante, monstruoAtacante);

    }

    private void destruirSiElDanioEsCero(int danio, Monstruo m){

        if (danio == 0) {

            this.cartasADestruir.add(m);

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
