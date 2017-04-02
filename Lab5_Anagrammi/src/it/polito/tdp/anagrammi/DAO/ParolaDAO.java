package it.polito.tdp.anagrammi.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class ParolaDAO {
	
	
	public boolean getParola(String codice) { 		
		
		final String sql = "SELECT parola.nome "+
							"FROM parola "+
							"WHERE nome=?";

		boolean trovato=false;

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			
			st.setString(1, codice);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				if(!rs.wasNull())
					trovato=true;
				}
				
		} catch (SQLException e) {
			e.printStackTrace();
			//throw new RuntimeException("Errore Db");
		}
		return trovato;	
		// TODO
	}


}

