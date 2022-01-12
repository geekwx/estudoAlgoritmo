package entendendoAlgoritmo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ordenacao {
	
	//Exemplo para reotnar o menor valor 
		public static int buscaMenorindice(List<Integer> lista) {
			int menor = lista.get(0);
			int menor_indice = 0;
			for (int i =0; i< lista.size(); i++) {
				if (lista.get(i) < menor) {
				menor = lista.get(i);
				menor_indice = i;
			}}
			
			return menor_indice;
		}
		
		public static List<Integer> ordenacaoporSelecao(List<Integer> lista){
			List<Integer> novaLista = new ArrayList<Integer>(lista.size());
			int tamanhoLista = lista.size();
			for (int i = 0; i < tamanhoLista ; i++) {
				int menor = buscaMenorindice(lista);
				novaLista.add(lista.get(menor));
				lista.remove(menor);
			}
			return novaLista;
		}
		
	
	
public static void main(String[] args) {
	List<Integer> minhaLista = new ArrayList<Integer>(Arrays.asList(5, 3, 6, 2, 10)) ;
	System.out.println(minhaLista);
	System.out.println(ordenacaoporSelecao(minhaLista));
}
}
