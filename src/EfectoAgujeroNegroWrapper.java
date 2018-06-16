public class EfectoAgujeroNegroWrapper implements EfectoWrapper {
    public void activar(){
        EfectoSobreCampo efectoAgujeroNegro = new EfectoAgujeroNegro();

        TurnoSingleton turno = TurnoSingleton.getInstance();

        turno.aplicarEfectoSobreCampoDeTurno(efectoAgujeroNegro);
        turno.aplicarEfectoSobreCampoOponente(efectoAgujeroNegro);
    }
}