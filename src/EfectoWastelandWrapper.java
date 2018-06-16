public class EfectoWastelandWrapper implements EfectoWrapper {
    public void activar(){
        EfectoSobreMonstruo efectoWastelandAtaque = new EfectoWastelandAtaque();
        EfectoSobreMonstruo efectoWastelandDefensa = new EfectoWastelandDefensa();

        TurnoSingleton turno = TurnoSingleton.getInstance();

        turno.agregarEfectoDeCampoEnJugadorDeTurno(efectoWastelandAtaque);
        turno.agregarEfectoDeCampoEnJugadorOponente(efectoWastelandDefensa);
    }
}
