package guia_03; 

abstract class Vehiculo { 
	public void acelerar() { 
		System.out.println("Acelerando..."); 
	} 
} 
class Coche extends Vehiculo{ 
	@Override 
	public void acelerar() { 
		System.out.println("El coche acelera uswando el motor."); 
	} 
} 
class Bicicleta extends Vehiculo{ 
	@Override 
	public void acelerar() { 
		System.out.println("La bicicleta acelera pedalenado."); 
	} 
} 