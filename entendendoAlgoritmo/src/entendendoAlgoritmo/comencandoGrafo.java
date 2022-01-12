package entendendoAlgoritmo;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.*;

public class comencandoGrafo {

	
	private static  Map<String, List<String>> grafo = new HashMap<>();
	
	
//	 funcao que retorna quanto encontrou o item, nessa ideia retorna quando encontrar o vendedor, caso nao seja a pessoa,
//	irar adicionar os contatos deles, ate ou correr a fila toda ou encontrar o vendedor
	static boolean busca(String nome) {
		Queue<String> filaProcura = new ArrayDeque<>(grafo.get(nome));
		
		List<String> jaVerificado = new ArrayList<>();
		
//		irar varrer a fila, enquanto nao encontrar, ou nao terminar vai seguindo pela fila
		while(!filaProcura.isEmpty()) {
			String pessoa = filaProcura.poll();
			
			if(!jaVerificado.contains(pessoa)) {
				if(ehVendedor(pessoa)) {
				System.out.println( pessoa +"=> Ele é um vendedor");
				return true;
				
			}else
			{
				filaProcura.addAll(grafo.get(pessoa));
				jaVerificado.add(pessoa);
			}
			}
		}
		return false;
	}
	
	private static boolean ehVendedor(String nome ) {
		return nome.endsWith("m");
	}
	
	public static void main(String[] args) {
		 grafo.put("vc", Arrays.asList("alice", "bob", "claire"));
	        grafo.put("bob", Arrays.asList("anuj", "peggy"));
	        grafo.put("alice", Arrays.asList("peggy"));
	        grafo.put("claire", Arrays.asList("thom", "jonny"));
	        grafo.put("anuj", Collections.emptyList());
	        grafo.put("peggy", Collections.emptyList());
	        grafo.put("thom", Collections.emptyList());
	        grafo.put("jonny", Collections.emptyList());
	        busca("vc");
	        
	       
	        
		
	}
}
