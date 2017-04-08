package it.polito.tdp.anagrammi.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import it.polito.tdp.anagrammi.DAO.ParolaDAO;


public class Model {
	
	private List<String> paroleGiuste = new ArrayList<String>();
	private List<String> paroleSbaliate = new ArrayList<String>();
	private List<String> Tot = new ArrayList<String>();
	private List<String> best = new ArrayList<String>();
	private String parziale="";
	private int lunghezza=1;
	private int size=0;
	private char[] array;

	
		
	public char[] CreaArray(String parola){
		
		char[] array= new char[parola.length()];
		array=parola.toCharArray();
		return array;
	}
	
	private void calcola(String parziale, int level, List<String> best) { //Algoritmo Ricorsivo
		
		if(parziale.length()==size){
			best.add(parziale);}
		//System.out.println("Stringa migliore "+best);}
		
		for(char c:array){
			
			if(!parziale.contains(""+c)){
					parziale=parziale+c;
					//e a delegare ricerca al livello successivo
					calcola(parziale, level+1,best);
					//poi rimetti le cose a posto, togliendo p!!!!!!
					parziale=parziale.substring(0, parziale.length()-1);
					//System.out.println(parziale);
		}
		}
		
	}
			
	public void risolvi(String parola){
		
		size=parola.length();
		array=this.CreaArray(parola);
		calcola(parziale,0,best);
		Tot.addAll(best);
		
		this.CercaParola();
	}

	public List<String> getParoleGiuste() {
		return paroleGiuste;
	}

	public List<String> getParoleSbaliate() {
		return paroleSbaliate;
	}

	public void CercaParola() {
		boolean trovato=false;
		ParolaDAO pr=new ParolaDAO();
		for(String s:Tot){
			trovato=pr.getParola(s);
			if(trovato==true)
				paroleGiuste.add(s);
			else 
				paroleSbaliate.add(s);
		}
				
	}
	
	

}
