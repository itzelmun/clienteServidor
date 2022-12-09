package ejemplo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cliente {

	public static void main(String[]args) {
		
		try {
		Scanner scan = new Scanner(System.in);
		scan.useDelimiter("\n");
		
		Socket soc = new Socket("127.0.0.1", 1000);
		
		DataInputStream entrada = new DataInputStream(soc.getInputStream());
		DataOutputStream salida = new DataOutputStream(soc.getOutputStream());
		//leo el servidor
		String mensaje= entrada.readUTF();		
		System.out.println(mensaje);
		
		String nombre = scan.next();
		salida.writeUTF(nombre);
		//
		ClienteHilos hilo = new ClienteHilos(entrada, salida);
		hilo.start();
		hilo.join();
		
		}catch(IOException | InterruptedException ex){
			Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);	
		}
	}
	
	
}
