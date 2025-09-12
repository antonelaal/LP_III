package Ejercicio_01;

import java.io.IOException;

public class ProcesadorEntrada {
    private LeerEntrada lector;

    public ProcesadorEntrada() {
        lector = new LeerEntrada(System.in);
    }

    public void procesar() throws IOException, 
                                  ExcepcionVocal, 
                                  ExcepcionNumero, 
                                  ExcepcionBlanco, 
                                  ExcepcionSalida {
        char c = lector.getChar();

        if ("aeiouAEIOU".indexOf(c) != -1) {
            throw new ExcepcionVocal("Se ingresó una vocal: " + c);
        } else if (Character.isDigit(c)) {
            throw new ExcepcionNumero("Se ingresó un número: " + c);
        } else if (Character.isWhitespace(c)) {
            throw new ExcepcionBlanco("Se ingresó un espacio en blanco.");
        } else if (c == 'q' || c == 'Q') { // ejemplo: 'q' para salir
            throw new ExcepcionSalida("Carácter de salida detectado: " + c);
        } else {
            System.out.println("Carácter normal: " + c);
        }
    }

    public static void main(String[] args) {
        ProcesadorEntrada proc = new ProcesadorEntrada();
        System.out.println("Ingrese caracteres (q para salir):");

        while (true) {
            try {
                proc.procesar();
            } catch (ExcepcionVocal e) {
                System.out.println("[Excepción vocal] " + e.getMessage());
            } catch (ExcepcionNumero e) {
                System.out.println("[Excepción número] " + e.getMessage());
            } catch (ExcepcionBlanco e) {
                System.out.println("[Excepción blanco] " + e.getMessage());
            } catch (ExcepcionSalida e) {
                System.out.println("[Excepción salida] " + e.getMessage());
                break;
            } catch (IOException e) {
                System.out.println("Error de entrada: " + e.getMessage());
                break;
            }
        }
    }
}