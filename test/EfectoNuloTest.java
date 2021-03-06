import junit.framework.TestCase;

public class EfectoNuloTest extends TestCase {

    public void testActivarEfectoNuloNoDestruyeMonstruos(){

        ArenaSingleton arena = ArenaSingleton.getInstance();
        Monstruo uno = new Monstruo(10, 10, 1);
        Monstruo dos = new Monstruo(1,1,1);
        Monstruo tres = new Monstruo(2,2,2);
        arena.colocarMonstruo(uno);
        arena.colocarMonstruo(dos);
        arena.colocarMonstruo(tres);
        Efecto e = new EfectoNulo();

        e.activar();

        assertFalse(arena.estaEnElCementerio(uno));
        assertFalse(arena.estaEnElCementerio(dos));
        assertFalse(arena.estaEnElCementerio(tres));

    }

}