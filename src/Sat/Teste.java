package Sat;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.function.Predicate;

public class Teste {

	public static void main(String[] args) {
		boolean result = false;
		ArrayList<Set<Integer>> clauses = new ArrayList<>();
		Resolution plResolution = new Resolution();
		
		ReaderClauses a = new ReaderClauses();
		
		File file = new File("exemplo");
		String arq = ""+file.getAbsolutePath().toString();
		
		ArrayList<String> b = a.readDocClauses(arq);
		
		clauses = a.formClauses(b);
		for (int i = 0; i < clauses.size(); i++) {
		//	System.out.println(clauses.get(i));
		}
		// RESOLVENDO 
		result = plResolution.resolution(clauses);
		
		if(!result){
			System.out.println("Satisfativel!");
		}else{
			System.out.println("Insatisfativel!");
		}
	}

}
