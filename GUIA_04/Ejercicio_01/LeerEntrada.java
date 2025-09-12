package Ejercicio_01;


import java.io.IOException;
import java.io.InputStream;

class LeerEntrada {
    private java.io.Reader stream;

    public LeerEntrada(InputStream fuente) {
        stream = new java.io.InputStreamReader(fuente);
    }

    public char getChar() throws IOException {
        return (char) this.stream.read();
    }
}

class ExcepcionVocal extends Exception {
    public ExcepcionVocal(String mensaje) {
        super(mensaje);
    }
}

class ExcepcionNumero extends Exception {
    public ExcepcionNumero(String mensaje) {
        super(mensaje);
    }
}

class ExcepcionBlanco extends Exception {
    public ExcepcionBlanco(String mensaje) {
        super(mensaje);
    }
}

class ExcepcionSalida extends Exception {
    public ExcepcionSalida(String mensaje) {
        super(mensaje);
    }
}

