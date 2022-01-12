package entendendoAlgoritmo;

import java.util.ArrayList;
import java.util.Arrays;

public class pesquisaBinaria {

//	Exemplo de Algoritmo de pesquisaBinaria
	public static int pesquisaBinaria(ArrayList<Integer> lista, int item) {
		int baixo = 0;
		int alto = lista.size() -1;
		int meio ;
		Integer chute;
		
		
		while(baixo <= alto) {
			meio = (baixo + alto)/2;
			chute = lista.get(meio);
			if (chute == item) {
				return meio;
			}
			if ( chute > item) {
				alto = meio -1;
			}else {
				baixo = meio + 1;
			}
			
		}
		return 0;
	}
	

	public static void main(String[] args) {
		

		ArrayList<Integer> minhaLista = new ArrayList<Integer>(Arrays.asList(new Integer[] {1, 3, 5, 7, 9})) ;
//		minhaLista.add(1);
//		minhaLista.add(3);
//		minhaLista.add(5);
//		minhaLista.add(7);
//		minhaLista.add(9);
		
		System.out.println("1 item =>" + pesquisaBinaria(minhaLista, 3));
		System.out.println("2 item =>" + pesquisaBinaria(minhaLista, -1));
		
	}
}
