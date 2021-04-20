//Nome: Renato Willyan Moratto Filho - RA.: 2266270

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Leitura{

	public String entDados(String rotulo){
		
		System.out.println(rotulo);

		InputStreamReader teclado = new InputStreamReader(System.in);
		BufferedReader buff = new BufferedReader(teclado);
		
		String a = "";

		try{	
			a = buff.readLine();
		} 
		catch(IOException e){
			System.out.println("\nErro de Sistema: RAM - TECLADO");
		}
		
		return a;
	}
}
