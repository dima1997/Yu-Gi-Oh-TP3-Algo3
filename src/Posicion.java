public interface Posicion {

    void atacar(Monstruo m);

    int obtenerAtaque();

    int obtenerDefensa();

    int recibirAtaque(Posicion suPosicion);
}
