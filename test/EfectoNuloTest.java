import junit.framework.TestCase;

public class EfectoNuloTest extends TestCase {

    public void testActivarEfectoNuloNoDestruyeMonstruos(){

        Cementerio unCementerio =  new Cementerio();

        Campo campoUno = new Campo(unCementerio);
        Campo campoDos = new Campo(unCementerio);
        Monstruo m1 = new Monstruo(10, 10, 1);
        Monstruo m2 = new Monstruo(1,1,1);
        Monstruo m3 = new Monstruo(2,2,2);
        campoUno.colocarMonstruo(m1);
        campoDos.colocarMonstruo(m2);
        campoDos.colocarMonstruo(m3);

        Efecto e = new EfectoNulo();

        e.activar();

        assertFalse(unCementerio.esta(m1));
        assertFalse(unCementerio.esta(m2));
        assertFalse(unCementerio.esta(m3));

    }

}