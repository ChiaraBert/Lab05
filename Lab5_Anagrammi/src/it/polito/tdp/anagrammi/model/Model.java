package it.polito.tdp.anagrammi.model;

import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.anagrammi.DAO.ParolaDAO;

public class Model {
	
	private List<String> paroleGiuste = new ArrayList<String>();
	private List<String> paroleSbaliate = new ArrayList<String>();

	public void calcola(String parola) {
		ParolaDAO pr = new ParolaDAO();
		boolean giusto=false;
		// Aggiungere algoritmo ricorsivo
	/*{
		giusto=pr.getParola(p); //DA fare per ogni parola p, ogni volta che l'algoritmo ne genera una
		if(giusto==true){
		paroleGiuste.add(p);
		else{
		paroleSbagliate.add(p);
	}*/
		
	}

	public List<String> getParoleGiuste() {
		return paroleGiuste;
	}

	public List<String> getParoleSbaliate() {
		return paroleSbaliate;
	}

	public boolean CercaParola(String parola) {
		boolean trovato=false;
		ParolaDAO pr=new ParolaDAO();
		trovato=pr.getParola(parola);
		return trovato;
	}
	
	

}
