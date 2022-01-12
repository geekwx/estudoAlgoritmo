package entendendoAlgoritmo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class quicksort {
	
//	funcao para somar itens de uma lista 
	public static int soma(List<Integer> listaNumero) {
		int numeroSomado = 0;
		int totalItens = listaNumero.size();
		
		for (int i = 0; i < listaNumero.size(); i++) {
			numeroSomado = numeroSomado + listaNumero.get(i);
		}
		
		return numeroSomado;
	}
//	 funcao para pegar o numero de itens, não é necessario em java, mas foi feito
	public static int numeroItens(List<Integer> listaNumero) {
		int numeroSomado = 0;
		int totalItens = listaNumero.size();
		
		for (int i = 0; i < listaNumero.size(); i++) {
			numeroSomado = numeroSomado + 1;
		}
		
		return numeroSomado;
	}
	
//	 funcao para trazer o numero maior
	public static int numeroMaior(List<Integer> listaNumero) {
		int numeroMaior = 0;
		int totalItens = listaNumero.size();
		
		for (int i = 0; i < listaNumero.size(); i++) {
			if(numeroMaior < listaNumero.get(i)) {
				numeroMaior = listaNumero.get(i);
			}
		}
		
		return numeroMaior;
	}
	
// a funcao principal a pesquisa rapida
	public static List<Integer> ordenacaoRapida(List<Integer> listaNumero){
		if(listaNumero.size() <2) {
			return listaNumero;
		}else
		{
			Integer pivo = listaNumero.get(0);
//			criando duas lista separadas pelo pivo, uma menor e igual ao pivo, e outra maior
			List<Integer> menor = listaNumero.stream().skip(1).filter(elemento -> elemento <= pivo).collect(Collectors.toList());
			List<Integer> maior = listaNumero.stream().skip(1).filter(elemento -> elemento > pivo).collect(Collectors.toList());
			
//			retornando a lista ordenada que faz a lista de menores + a o pivo  mais a lista de maior assim ordenando todos os itens
			return Stream.of(
					ordenacaoRapida(menor).stream(),Stream.of(pivo),ordenacaoRapida(maior).stream()).flatMap(Function.identity()).collect(Collectors.toList());
					
		}
		
	}
	
public static void main(String[] args) {
	List<Integer> minhaLista = new ArrayList<Integer>(Arrays.asList(6,2,4,20, 1, 7));
	System.out.println(ordenacaoRapida(minhaLista));
}
}
