package ejemplo;

import java.io.DataInputStream;
import java.io.DataOutputStream;

public class ClienteHilos extends Thread{

	private DataInputStream entrada;
	private DataOutputStream salida;
	
	public ClienteHilos(DataInputStream entrada, DataOutputStream salida) {
		super();
		this.entrada = entrada;
		this.salida = salida;
	}
	
	@Override
	public void run(){
	
	}
	
}
