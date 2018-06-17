import java.util.LinkedList;

 class EfectoDestruirMonstruo implements Efecto {

    Campo campo;

    public EfectoDestruirMonstruo(Campo campoOponente) {

        this.campo = campoOponente;

    }

    public void activar(){

        LinkedList monstruos = this.campo.obtenerMonstruos();
        MonstruoComun unMonstruo = (MonstruoComun) monstruos.peekFirst();
        this.campo.destruir(unMonstruo);

    }

    public void activarEn(MonstruoComun m){

        this.campo.destruir(m);

    }

}
