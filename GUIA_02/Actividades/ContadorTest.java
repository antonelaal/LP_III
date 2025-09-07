package guia_02;


public class ContadorTest {
    public static void main(String[] args) {
        Contador c1 = new Contador(); 
        Contador c2 = new Contador(5);
        
        System.out.println(c1.getValor()); // 1
        System.out.println(c2.getValor()); // 5
        System.out.println(Contador.acumulador()); // 6
    }
}
