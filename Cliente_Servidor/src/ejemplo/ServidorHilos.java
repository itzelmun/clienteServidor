package ejemplo;

import java.io.DataInputStream;
import java.io.DataOutputStream;

public class ServidorHilos extends Thread{
	
	private DataInputStream entrada;
	private DataOutputStream salida;
	

	private String usuarioCliente;


	public ServidorHilos(DataInputStream entrada, DataOutputStream salida, String usuarioCliente) {
		super();
		this.entrada = entrada;
		this.salida = salida;
		this.usuarioCliente = usuarioCliente;
	}
	
	@Override
	public void run() {
		
	}
	
}
