package entendendoAlgoritmo;

import java.util.*;
import java.util.Map.Entry;

public class algoritmoGuloso {

	
	
	public static void main(String[] args) {
		
//		List<String> estacaoAbranger = new ArrayList(Arrays.asList("mt", "wa", "or", "id", "nv", "ut", "ca","az"));
//		 Criando o hash para armazena todos os estados
	   HashSet todosEstados = new HashSet<>(Arrays.asList("mt", "wa", "or", "id", "nv", "ut", "ca", "az"));
	   
//	    criando o hash para adicionar todas as estacoes e que cidade que elas acessam
		 LinkedHashMap<String, Set<String>> estacoes = new LinkedHashMap<String, Set<String>>();
		 
//		  adicionando todas as estacoes
		 estacoes.put("kone", new HashSet<>(Arrays.asList("id", "nv", "ut")));
		 estacoes.put("ktwo", new HashSet<>(Arrays.asList("wa", "id", "mt")));
		 estacoes.put("kthree", new HashSet<>(Arrays.asList("or", "nv", "ca")));
		 estacoes.put("kfour", new HashSet<>(Arrays.asList("nv", "ut")));
		 estacoes.put("kfive", new HashSet<>(Arrays.asList("ca", "az")));
		 
		
		  HashSet<String> estacaoFinal = new HashSet<String>();
		  
		  while(!todosEstados.isEmpty()) {
			  String melhorEstacao = null;
			   HashSet<String> estadoCobertos = new HashSet<String>();
			   
			   for(Entry<String, Set<String>> estacao : estacoes.entrySet()) {
				    HashSet coberto = new HashSet<>(todosEstados);
				    coberto.retainAll(estacao.getValue());
				    
				    if(coberto.size() > estadoCobertos.size()) {
				    	melhorEstacao =  estacao.getKey();
				    	estadoCobertos = coberto;
				    }
				    
				   
			   }
			   todosEstados.removeIf(estadoCobertos:: contains);
			   
			   if(melhorEstacao != null) {
				   estacaoFinal.add(melhorEstacao);
				   
			   }
		  }
		 System.out.println(estacaoFinal);
	}
}
