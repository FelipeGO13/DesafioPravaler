package TesteLogica2;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class testeLogica2 {

	public static void main(String args[]) {
		Double massaMinima = 0.1;
		Scanner s = new Scanner(System.in);
		Double tempoTotal = 0.0;
		
		System.out.println("Insira a massa do material:");
		Double massa = s.nextDouble();
		
		while(massa >= massaMinima) {
			tempoTotal += 30;
			massa -= massa * 0.25;
		}
		System.out.println("Tempo total é de: " + tempoTotal + " segundos");
	}

  
}
