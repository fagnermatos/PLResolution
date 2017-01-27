package Sat;

import java.lang.invoke.LambdaConversionException;
import java.lang.invoke.LambdaMetafactory;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Resolution {

	public boolean resolution(ArrayList<Set<Integer>> clauses){
		
		ArrayList<Set<Integer>> newClauses = new ArrayList<>();
		boolean laco = true;

		while(laco){
			
			for (int i = 0; i < clauses.size(); i++) {			
				for (int j = 0; j < clauses.size(); j++){
						
					Set<Integer> resolvents = resolve(clauses.get(i), clauses.get(j));	
				//	System.out.println(resolvents);
					if (resolvents.isEmpty()) return true;					
					newClauses.add(resolvents);
					//Elimina clausas repetidas
					newClauses = (ArrayList<Set<Integer>>) newClauses.stream().distinct().collect(Collectors.toList());
				}
			}
				
			if (clauses.containsAll(newClauses)) return false;
			clauses.addAll(newClauses);
			//Elimina clausas repetidas
			clauses = (ArrayList<Set<Integer>>) clauses.stream().distinct().collect(Collectors.toList());
			
		}	
		return false;	
	}

	public static Set<Integer> resolve(Set<Integer> setC1, Set<Integer> setC2) {
		Set<Integer> newClause = new HashSet();
		Set<Integer> set1 = new HashSet();
		Set<Integer> set2 = new HashSet();
		set1.addAll(setC1);
		set2.addAll(setC2);
		
		Iterator<Integer> itr = set1.iterator(); 
		while(itr.hasNext()){
			int i = itr.next();
			if(set2.contains(i*-1)){
				set2.remove(i*-1);
				set1.remove(i);
				break;
			}
		}	
		newClause.addAll(set1);
		newClause.addAll(set2);
		return newClause;
	}
}
