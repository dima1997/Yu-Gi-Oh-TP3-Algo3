import java.util.Comparator;

public class Monstruo implements Carta{

    private Posicion posicion;
    private int danio;
    private int defensa;
    private int estrellas;
    private Efecto efecto;

    Monstruo(int danio, int defensa, int estrellas){

        this.danio = danio;
        this.defensa = defensa;
        this.estrellas = estrellas;
        this.posicion = new PosDormido();
        this.efecto = new EfectoNulo();

    }

    Monstruo(int danio, int defensa, int estrellas, Efecto efecto){

        this.danio = danio;
        this.defensa = defensa;
        this.estrellas = estrellas;
        this.posicion = new PosDormido();
        this.efecto = efecto;

    }

    void colocarEnPosAtaque(){

        this.posicion = new PosAtaque();

    }

    void colocarEnPosDefensa(){

        this.posicion = new PosDefensa();

    }

    int obtenerPuntos() {

        return this.posicion.obtenerPuntos(this.danio, this.defensa);

    }
    
    int obtenerPuntosDeAtaque() {
    	
    	return this.danio;
    }

    void aumentarAtaque(int aumento) {

        this.danio += aumento;

    }

    public void reducirAtaque(int reduccion) {

        this.danio -= reduccion;

    }

    void aumentarDefensa(int aumento) {

        this.defensa += aumento;

    }

    public void reducirDefensa(int reduccion) {

        this.defensa -= reduccion;

    }

    Botin atacar(Monstruo enemigo) {

        this.posicion.atacar();
        Botin botin = new Botin();

        int dif = this.obtenerPuntos() - enemigo.obtenerPuntos();

        if(dif >= 0){

            this.matar(enemigo, botin);
            botin.setDanioAtacado(enemigo.posicion.danioDePersonaje(dif));

        }
        if(dif <= 0){

            enemigo.matar(this, botin);
            botin.setDanioAtacante(this.posicion.danioDePersonaje(dif));

        }

        return botin;

    }

    private void matar(Monstruo enemigo, Botin b) {

        this.posicion.matar(enemigo, b);

    }

    public void colocarEnCampo(Campo unCampo) {
        unCampo.colocarMonstruo(this);
    }

    //Comparador para ordenar los monstruos por puntos de ataque.
	public static Comparator<Monstruo> CompararPorAtaque = new Comparator<Monstruo>() {
		
		public int compare(Monstruo m1, Monstruo m2) {
			
			int ataqueM1 = m1.obtenerPuntosDeAtaque();
			int ataqueM2 = m2.obtenerPuntosDeAtaque();
			
			return ataqueM1-ataqueM2;
					
		}
	};



}
