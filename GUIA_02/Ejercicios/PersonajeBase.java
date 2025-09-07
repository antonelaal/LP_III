package guia_02;

interface IAtaqueFisico {
	void ataqueFisico(PersonajeBase enemigo);
}

interface IAtaqueMagico {
	void ataqueMagico(PersonajeBase enemigo);
}

abstract class PersonajeBase {
	protected String nombre;
	protected int nivel;
	protected int salud;

	public static int contador = 0; 
	public static final int MAX_NIVEL = 100; 
	public static final int MAX_SALUD = 100;

	public PersonajeBase(String nombre) {
		this.nombre = nombre;
		this.nivel = 1;
		this.salud = MAX_SALUD;
		contador++;
	}

	public abstract void atacar(PersonajeBase enemigo);
	public abstract void usarHabilidad();
}

class Guerrero extends PersonajeBase implements IAtaqueFisico {
	public Guerrero(String nombre) { 
		super(nombre); 
	}

	@Override
	public void atacar(PersonajeBase enemigo) {
		ataqueFisico(enemigo);
	}

	@Override
	public void ataqueFisico(PersonajeBase enemigo) {
		enemigo.salud -= 10;
		System.out.println(nombre + " golpea a " + enemigo.nombre);
	}

	@Override
	public void usarHabilidad() {
		System.out.println(nombre + " usa 'Furia'");
	}
}

class Mago extends PersonajeBase implements IAtaqueMagico {
	public Mago(String nombre) { 
		super(nombre); 
	}

	@Override
	public void atacar(PersonajeBase enemigo) {
		ataqueMagico(enemigo);
	}

	@Override
	public void ataqueMagico(PersonajeBase enemigo) {
		enemigo.salud -= 12;
		System.out.println(nombre + " lanza un hechizo a " + enemigo.nombre);
	}

	@Override
	public void usarHabilidad() {
		System.out.println(nombre + " usa 'Bola de Fuego'");
	}
}

class Habilidad {
	String nombre;

	public Habilidad(String nombre) { 
		this.nombre = nombre; 
	}
}

class Objeto {
	String nombre;

	public Objeto(String nombre) { 
		this.nombre = nombre; 
	}
}

class Inventario {
	Objeto objeto;

	public void agregarObjeto(Objeto o) { 
		this.objeto = o; 
	}
}

class Personaje {
	private String nombre;          
	int salud;                      
	protected int nivel;            
	public Inventario inventario;   

	public static int totalPersonajes = 0;
	public static final String MUNDO = "Eldoria";

	public Personaje(String nombre) {
		this.nombre = nombre;
		this.salud = 50;
		this.nivel = 1;
		this.inventario = new Inventario();
		totalPersonajes++;
	}

	public void mostrarInfo() {
		System.out.println(nombre + " Nivel: " + nivel + " Salud: " + salud);
	}

	private void curar() { 
		salud += 10; 
	}

	protected void subirNivel() { 
		nivel++; 
	}

	void daño(int d) { 
		salud -= d; 
	}

	public String getNombre() { 
		return nombre; 
	}

	public void setNombre(String n) { 
		this.nombre = n; 
	}
}

public class SistemaJuego {
	public static void main(String[] args) {
		PersonajeBase g = new Guerrero("Arthur");
		PersonajeBase m = new Mago("Merlin");

		g.atacar(m);
		m.usarHabilidad();

		Personaje p = new Personaje("Robin");
		p.inventario.agregarObjeto(new Objeto("Espada"));
		p.mostrarInfo();
	}
}
