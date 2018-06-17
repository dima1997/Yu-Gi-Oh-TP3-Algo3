public class PosCilindroMagico implements PosicionStrategy {

    public int obtenerPuntos(int danio, int defensa){
        return danio;
    }

    public int danioDePersonaje(int dif){
        return dif;
    }

    public void matar(Monstruo enemigo, Botin b){
        return;
    }

    public Botin atacar(PosicionStrategy posicionAtacada, Monstruo atacante, Monstruo atacado){
        Botin unBotin = new Botin();
        int danio = atacante.obtenerPuntos();
        unBotin.setDanioAtacante(danio);
        unBotin.setDanioAtacado(0);
        return unBotin;
    }
}
