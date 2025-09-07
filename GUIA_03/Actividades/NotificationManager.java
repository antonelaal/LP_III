package guia_03; 

interface NotificationManager { 
	void send(String message); 
} 

class email implements NotificationManager{ 
	public void send(String message) { 
		System.out.println("Enviando correo: "+message); 
	} 
} 

class SMS implements NotificationManager{ 
	public void send(String message) {
		System.out.println("Enviando SMSo: "+message); 
	} 
} 