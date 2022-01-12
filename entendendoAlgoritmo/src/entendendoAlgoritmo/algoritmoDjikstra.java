package entendendoAlgoritmo;

import java.util.*;

//analisar https://github.com/franzejr/Dijkstra-Algorithm-Java-GUI/blob/master/src/Dijkstra.java

public class algoritmoDjikstra {

//	o grafo que irar armazenar
	private static Map<String, Map<String, Double >> grafo = new HashMap<>();
	
	private static List<String> jaProcessado = new ArrayList<>();
	
	
	private static String buscaMenorcusto(Map<String,Double> custos) {
		Double custoBaixo = Double.POSITIVE_INFINITY;
		String noDeCustomaisBaixo = null;
		
//		Percorrer todos os vizinho do no 
		for (Map.Entry<String, Double> no : custos.entrySet()) {
			Double custo = no.getValue();
			
//			 se na o custo for mais baixo do qque o armazenado, executa
			if( custo < custoBaixo && !jaProcessado.contains(no.getKey())){
				custoBaixo = custo;
				noDeCustomaisBaixo = no.getKey();
				
			}
		}
		return noDeCustomaisBaixo;
	}
	
	
	
	
	public static void main(String[] args) {
//		dentro da primeira inserção aidiciona um segundo dicionario que irar armazena os pontos
		   grafo.put("start", new HashMap<>());
	        grafo.get("start").put("a", 6.0);
	        grafo.get("start").put("b", 2.0);

	        grafo.put("a", new HashMap<>());
	        grafo.get("a").put("fin", 1.0);

	        grafo.put("b", new HashMap<>());
	        grafo.get("b").put("a", 3.0);
	        grafo.get("b").put("fin", 5.0);

	        grafo.put("fin", new HashMap<>());

	        
//	         a tabela de custo
	        Map<String, Double> custos = new HashMap<>();
	        custos.put("a", 6.0);
	        custos.put("b", 2.0);
	        custos.put("fin", Double.POSITIVE_INFINITY);
	        
//	         tabela de pais
	        Map<String, String> pais = new HashMap<>();
	        pais.put("a", "start");
	        pais.put("b", "start");
	        pais.put("fin", null);
	    
//	        realiza a busca pelo no de menor custo
		String no =  buscaMenorcusto(custos);
		
		while(no != null) {
			Double custo = custos.get(no);
			
			Map<String, Double> vizinhos =  grafo.get(no);
			
			for (String vizinho : vizinhos.keySet()) {
				Double novoCusto = custo + vizinhos.get(vizinho);
				
				if(custos.get(vizinho) > novoCusto) {
					custos.put(vizinho, novoCusto);
					pais.put(vizinho, no);
				}
			}
			
			jaProcessado.add(no);
//			 adicionando o proximo no no processo
			no = buscaMenorcusto(custos);
			
		}
		System.out.println("o Caminho com o menor custo e");
		System.out.println(custos);
		
	}
}
