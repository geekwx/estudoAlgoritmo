package entendendoAlgoritmo;

import java.util.List;

// Capitulo 3 do livro 
public class recursivo {

	
	
//	 Exercicio de funcao recursiva ela chama ela mesmas.
	public static void contagemRegressiva(int numero) {
		System.out.println(numero);
		if (numero <= 1){
			
		}
		else {
			contagemRegressiva(numero - 1);
		}
		
	}
	
//	Exercicio recursivo de fatorial 
	public static int fatorial(int numero) {
		System.out.println(numero);
		if (numero == 1) {
			return 1;
			
		}
		else {
			return numero * fatorial(numero -1);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		contagemRegressiva(10);
//		fatorial(5);
		System.out.println(fatorial(5));
	}

}
