package Ejercicio_01;

public class pruebaPar {
    public static void main(String[] args) {
        Par<String, Integer> par1 = new Par<>("Edad", 20);
        System.out.println("Par 1: " + par1);
        System.out.println("Primero: " + par1.getPrimero());
        System.out.println("Segundo: " + par1.getSegundo());
        
        par1.setSegundo(30);
        System.out.println("Después de modificar: " + par1);
        System.out.println(); 
        
        Par<Integer, Double> par2 = new Par<>(100, 99.5);
        System.out.println("Par 2: " + par2);
        System.out.println(); 
        
        Par<String, String> par3 = new Par<>("Nombre", "Gustavo");
        System.out.println("Par 3: " + par3);
        System.out.println(); 

        Par<String, Boolean> par4 = new Par<>();
        par4.setPrimero("Activo");
        par4.setSegundo(true);
        System.out.println("Par 4: " + par4);
        
        System.out.println();
        
        Par<String, String> par5 = new Par<>("Apellido", null);
        System.out.println("Par 5: " + par5);
    }
}
