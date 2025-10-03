package Ejercicio_02;

public class pruebaPar {
    public static void main(String[] args) {        
        Par<String, Integer> par1 = new Par<>("Edad", 25);
        Par<String, Integer> par2 = new Par<>("Edad", 25);
        System.out.println("Par1: " + par1);
        System.out.println("Par2: " + par2);
        System.out.println("¿Par1 es igual a Par2? " + par1.esIgual(par2));
        System.out.println();
        
        Par<String, Integer> par3 = new Par<>("Nombre", 30);
        Par<String, Integer> par4 = new Par<>("Edad", 30);
        System.out.println("Par3: " + par3);
        System.out.println("Par4: " + par4);
        System.out.println("¿Par3 es igual a Par4? " + par3.esIgual(par4));
        System.out.println();
        
        Par<String, Integer> par5 = new Par<>("Edad", 25);
        Par<String, Integer> par6 = new Par<>("Edad", 30);
        System.out.println("Par5: " + par5);
        System.out.println("Par6: " + par6);
        System.out.println("¿Par5 es igual a Par6? " + par5.esIgual(par6));
        System.out.println();
        
        Par<String, String> par7 = new Par<>("Apellido", null);
        Par<String, String> par8 = new Par<>("Apellido", null);
        Par<String, String> par9 = new Par<>("Apellido", "Pérez");
        System.out.println("Par7: " + par7);
        System.out.println("Par8: " + par8);
        System.out.println("Par9: " + par9);
        System.out.println("¿Par7 es igual a Par8? " + par7.esIgual(par8));
        System.out.println("¿Par7 es igual a Par9? " + par7.esIgual(par9));
        System.out.println();
        
        System.out.println("¿Par1 es igual a sí mismo? " + par1.esIgual(par1));
        System.out.println();
        
        System.out.println("¿Par1 es igual a null? " + par1.esIgual(null));
        System.out.println();
        
        Par<Integer, Double> par10 = new Par<>(10, 5.5);
        Par<Integer, Double> par11 = new Par<>(10, 5.5);
        Par<Integer, Double> par12 = new Par<>(10, 6.5);
        System.out.println("Par10: " + par10);
        System.out.println("Par11: " + par11);
        System.out.println("Par12: " + par12);
        System.out.println("¿Par10 es igual a Par11? " + par10.esIgual(par11));
        System.out.println("¿Par10 es igual a Par12? " + par10.esIgual(par12));
        System.out.println();
        
        Par<String, Boolean> par13 = new Par<>("Activo", true);
        Par<String, Boolean> par14 = new Par<>("Activo", true);
        Par<String, Boolean> par15 = new Par<>("Activo", false);
        System.out.println("Par13: " + par13);
        System.out.println("Par14: " + par14);
        System.out.println("Par15: " + par15);
        System.out.println("¿Par13 es igual a Par14? " + par13.esIgual(par14));
        System.out.println("¿Par13 es igual a Par15? " + par13.esIgual(par15));
    }
}
