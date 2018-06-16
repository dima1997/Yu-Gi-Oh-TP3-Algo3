import java.util.LinkedList;

class Botin implements EfectoSobreCampo{

    private int danioDeAtacado;
    private int danioDeAtacante;
    private LinkedList<Monstruo> muertos = new LinkedList<>();

    void agregarMuerto(Monstruo m ){

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

    void ejecutar(Campo c){

        for (Monstruo m : this.muertos){

            c.destruir(m);

        }

    }

    public void activar(Campo c){
        this.ejecutar(c);
    }

    void quitarMuerto(Monstruo m) {

        this.muertos.remove(m);

    }
}
