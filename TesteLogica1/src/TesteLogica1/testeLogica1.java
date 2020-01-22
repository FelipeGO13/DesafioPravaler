package TesteLogica1;

import java.util.Scanner;

public class testeLogica1 {

	public static void main(String[] args) {
	
		Scanner s = new Scanner(System.in);
		
		System.out.println("Insira a descrição do produto");
		String nome = s.nextLine();
		
		System.out.println("Insira a quantidade");
		Integer quantidade = s.nextInt();
		
		System.out.println("Insira o preço");
		Double preco = s.nextDouble();
		
		Double total = quantidade * preco;
		
		if(quantidade <= 5) {
			total -= (total * .02);
		} else if(quantidade > 5 && quantidade <=10) {
			total -= (total * .03);
		} else {
			total -= (total * .05);
		}
		
		System.out.println("O valor total é "+ total);
	}

}


