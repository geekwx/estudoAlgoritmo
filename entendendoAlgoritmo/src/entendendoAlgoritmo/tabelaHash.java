package entendendoAlgoritmo;

import java.util.HashMap;
import java.util.Map;

public class tabelaHash {
	private static Map<String, Boolean> listaVotos = new HashMap<>();
	
	public static void jaVotou(String nome) {
		if(listaVotos.containsKey(nome)) {
			System.out.println("Ja votou, pode ir embora");
		}else {
			listaVotos.put(nome, true);
			System.out.println("Pode votar");
		}
	}
	
	
	
	public static void main(String[] args) {
		Map<String, Double> livro = new HashMap<>();
		
		livro.put("maca", 0.67);
		livro.put("banana", 1.67);
		livro.put("laranja", 5.67);
		
		System.out.println(livro);
		
		jaVotou("Joao");
		jaVotou("Pedro");
		jaVotou("Pedro");
		
		
	}
	
}
