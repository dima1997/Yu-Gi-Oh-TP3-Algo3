abstract class EfectoDecorator implements Monstruo {

    Monstruo cartaTemp;

    EfectoDecorator(MonstruoComun carta){

        this.cartaTemp = carta;
    }

}
