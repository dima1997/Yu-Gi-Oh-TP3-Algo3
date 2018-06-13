import junit.framework.TestCase;

public class AreaDeCombateTest extends TestCase {
	
	public void testHacerCombatirMonstruoEnPosAtaqueContraMonstruoConMenorAtaqueDestruyeElSegundo(){
		
		Jugador atacante = new Jugador(10);
		Jugador defensor = new Jugador(10);
		Monstruo agresivo = new Monstruo(20,20,1);
		Monstruo defensivo = new Monstruo(10,10,1);
		agresivo.colocarEnPosAtaque();
		defensivo.colocarEnPosAtaque();
		
		AreaDeCombate a = new AreaDeCombate();
		
		a.combatir(atacante, agresivo, defensor, defensivo);
		
		assertTrue(a.cartasADestruir().contains(defensivo));

	}
	
	public void testHacerCombatirMonstruoEnPosAtaqueContraMonstruoConMenorAtaqueDevuelveLosDañosCorrectos(){
		
		Jugador atacante = new Jugador(10);
		Jugador defensor = new Jugador(10);
		Monstruo agresivo = new Monstruo(20,20,1);
		Monstruo defensivo = new Monstruo(10,10,1);
		agresivo.colocarEnPosAtaque();
		defensivo.colocarEnPosAtaque();
		
		AreaDeCombate a = new AreaDeCombate();
		
		a.combatir(atacante, agresivo, defensor, defensivo);
		
		assertEquals(a.danioAtacante(), 0);
		assertEquals(a.danioDefensor(), 10);
		
	}

	public void testHacerCombatirMonstruoEnPosAtaqueContraMonstruoConMayorAtaqueDestruyeAlPrimero(){

		Jugador atacante = new Jugador(10);
		Jugador defensor = new Jugador(10);
		Monstruo agresivo = new Monstruo(10,20,1);
		Monstruo defensivo = new Monstruo(20,10,1);
		agresivo.colocarEnPosAtaque();
		defensivo.colocarEnPosAtaque();

		AreaDeCombate a = new AreaDeCombate();

		a.combatir(atacante, agresivo, defensor, defensivo);

		assertTrue(a.cartasADestruir().contains(agresivo));

	}

	public void testHacerCombatirMonstruoEnPosAtaqueContraMonstruoConMayorAtaqueDevuelveLosDaniosCorrectos(){

		Jugador atacante = new Jugador(10);
		Jugador defensor = new Jugador(10);
		Monstruo agresivo = new Monstruo(20,20,1);
		Monstruo defensivo = new Monstruo(10,10,1);
		agresivo.colocarEnPosAtaque();
		defensivo.colocarEnPosAtaque();

		AreaDeCombate a = new AreaDeCombate();

		a.combatir(atacante, agresivo, defensor, defensivo);

		assertEquals(a.danioAtacante(), 10);
		assertEquals(a.danioDefensor(), 0);

	}

	public void testHacerCombatirMonstruoEnPosAtaqueContraMonstruoConIgualAtaqueDestruyeAmbosMonstruos(){

		Jugador atacante = new Jugador(10);
		Jugador defensor = new Jugador(10);
		Monstruo agresivo = new Monstruo(10,20,1);
		Monstruo defensivo = new Monstruo(10,10,1);
		agresivo.colocarEnPosAtaque();
		defensivo.colocarEnPosAtaque();

		AreaDeCombate a = new AreaDeCombate();

		a.combatir(atacante, agresivo, defensor, defensivo);

		assertTrue(a.cartasADestruir().contains(agresivo));
		assertTrue(a.cartasADestruir().contains(defensor));

	}

	public void testHacerCombatirMonstruoEnPosAtaqueContraMonstruoConIgualAtaqueNoGeneraDanioAJugadores(){

		Jugador atacante = new Jugador(10);
		Jugador defensor = new Jugador(10);
		Monstruo agresivo = new Monstruo(10,20,1);
		Monstruo defensivo = new Monstruo(10,10,1);
		agresivo.colocarEnPosAtaque();
		defensivo.colocarEnPosAtaque();

		AreaDeCombate a = new AreaDeCombate();

		a.combatir(atacante, agresivo, defensor, defensivo);

		assertEquals(a.danioAtacante(), 0);
		assertEquals(a.danioDefensor(), 0);

	}



}
