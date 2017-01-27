package Sat;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class ReaderClauses {
	
	public ArrayList<String> readDocClauses(String archiveName){
		ArrayList<String> docClauses = new ArrayList<>();
		String line;
		
		try {
			FileReader arch = new FileReader(archiveName);
			BufferedReader read = new BufferedReader(arch);
			
			line = read.readLine();
			line = read.readLine();
			line = read.readLine();
			while(line!=null){
				docClauses.add(line);
				line = read.readLine();
			}
		}catch (IOException e2) {
			return null;
		}		
		return docClauses;
	}
	
	public ArrayList<Set<Integer>> formClauses(ArrayList<String> docClauses){

		ArrayList<Set<Integer>> clauses = new ArrayList<>();
		for (int i = 0; i < docClauses.size(); i++) {

			Set<Integer> clause = new HashSet();
			String[] temp = docClauses.get(i).split(" ");
			
			for (int j = 0; j < temp.length; j++){
				if(!temp[j].equals("0")){
					clause.add(Integer.parseInt(temp[j]));
				}
			}
			clauses.add(clause);
		}
		
		
		
		return clauses;
	}

}
