import java.util.LinkedList;

class Botin {

    private int danioDeAtacado;
    private int danioDeAtacante;
    private LinkedList<MonstruoComun> muertos = new LinkedList<>();

    void agregarMuerto(MonstruoComun m ){

        this.muertos.add(m);

    }

    void setDanioAtacado(int d){

        this.danioDeAtacado = d;

    }

    void setDanioAtacante(int d){

        this.danioDeAtacante = d;

    }

    void infligirDanios(Jugador atacante, Jugador atacado) {

        atacado.recibirAtaque(this.danioDeAtacado);
        atacante.recibirAtaque(this.danioDeAtacante);

    }

    void ejecutar(Cementerio c){

        for (MonstruoComun m : this.muertos){

            c.enviar(m);

        }

    }
}
