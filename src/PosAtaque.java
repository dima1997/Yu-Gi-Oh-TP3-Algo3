public class PosAtaque implements PosicionStrategy {

    public int obtenerPuntos(int danio, int defensa){

        return danio;

    }

    public int danioDePersonaje(int resultadoDeBatalla){

        return Math.abs(resultadoDeBatalla);

    }

    public void matar(Monstruo enemigo, Botin b) {

        b.agregarMuerto(enemigo);

    }

    public Botin atacar(PosicionStrategy posicionAtacada, Monstruo atacante, Monstruo atacado) {

        Botin botin = new Botin();

        int dif = atacante.obtenerPuntos() - atacado.obtenerPuntos();

        if(dif >= 0){

            this.matar(atacado, botin);
            botin.setDanioAtacado(posicionAtacada.danioDePersonaje(dif));

        }
        if(dif <= 0){

            posicionAtacada.matar(atacante, botin);
            botin.setDanioAtacante(this.danioDePersonaje(dif));

        }

        return botin;
    }

}