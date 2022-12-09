package ejemplo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Servidor {
	public static void main(String[] args) {
		
		try {
			ServerSocket servidor = new ServerSocket (1000);
			//socket que va a ser que el cliente se conecte
			Socket scc;
			System.out.println("Servidor Iniciado");
			//ciclo que indica que siempre va a estar escuchando peticiones
			while(true) {
				scc = servidor.accept();
				DataInputStream entrada= new DataInputStream(scc.getInputStream());
				DataOutputStream salida = new DataOutputStream(scc.getOutputStream());
				salida.writeUTF("Dame tu Usuario:");
				String usuarioCliente = entrada.readUTF();
				
				ServidorHilos hilo = new ServidorHilos(entrada, salida, usuarioCliente);
				hilo.start();
				
				System.out.println("Conexión exitosa \n"+ usuarioCliente);
						
						}
			
			
		} catch (IOException ex) {
			Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE,null,ex);
		}
		
	}
}
