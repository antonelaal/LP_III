package Actividad_01;

class InvalidSubscriptException extends Exception {
    public InvalidSubscriptException(String mensaje) {
        super(mensaje);
    }
}

public class PruebaMetodoGenerico {
    public static <E> void imprimirArreglo(E[] arregloEntrada) {
        for (E elemento : arregloEntrada) {
            System.out.printf("%s ", elemento);
        }
        System.out.println();
    }

    public static <E> int imprimirArreglo(E[] arregloEntrada, int subindiceInferior, int subindiceSuperior) 
            throws InvalidSubscriptException {
        if (subindiceInferior < 0 || subindiceSuperior > arregloEntrada.length
                || subindiceInferior >= subindiceSuperior) {
            throw new InvalidSubscriptException("Índices inválidos: " 
                    + subindiceInferior + " - " + subindiceSuperior);
        }
        int cantidad = 0;
        for (int i = subindiceInferior; i < subindiceSuperior; i++) {
            System.out.printf("%s ", arregloEntrada[i]);
            cantidad++;
        }
        System.out.println();

        return cantidad; 
    }

public static void main(String[] args) {
        Integer[] arregloInteger = {1, 2, 3, 4, 5, 6};
        Double[] arregloDouble = {1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 7.7};
        Character[] arregloCharacter = {'H', 'O', 'L', 'A'};

        System.out.println("El arreglo arregloInteger contiene:");
        imprimirArreglo(arregloInteger);

        System.out.println("\nEl arreglo arregloDouble contiene:");
        imprimirArreglo(arregloDouble);

        System.out.println("\nEl arreglo arregloCharacter contiene:");
        imprimirArreglo(arregloCharacter);

        try {
            System.out.println("\nSubarreglo de Integer (índices 1 a 4):");
            int cantidad1 = imprimirArreglo(arregloInteger, 1, 4);
            System.out.println("Cantidad de elementos impresos: " + cantidad1);

            System.out.println("\nSubarreglo de Double (índices 0 a 3):");
            int cantidad2 = imprimirArreglo(arregloDouble, 0, 3);
            System.out.println("Cantidad de elementos impresos: " + cantidad2);

            System.out.println("\nSubarreglo de Character (índices 0 a 2):");
            int cantidad3 = imprimirArreglo(arregloCharacter, 0, 2);
            System.out.println("Cantidad de elementos impresos: " + cantidad3);

            System.out.println("\nIntentando índices inválidos...");
            imprimirArreglo(arregloInteger, -1, 3);

        } catch (InvalidSubscriptException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}