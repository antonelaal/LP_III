package guia_02;

public class Contador {
	static int acumulador = 0;
	private int valor;
	
	public static int acumulador() {
		return acumulador;
	}
	public Contador (int valor) {
		this.valor = valor;
		Contador.acumulador += valor;

	}
	public void inc() {
		this.valor++;
		acumulador++;
	}
	public int getValor(){
		return this.valor;
	}
}





public class ContadorTest {
    public static void main(String[] args) {
        Contador c1 = new Contador(); 
        Contador c2 = new Contador(5);
        
        System.out.println(c1.getValor()); // 1
        System.out.println(c2.getValor()); // 5
        System.out.println(Contador.acumulador()); // 6
    }
}


