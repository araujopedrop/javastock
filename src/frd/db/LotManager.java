package frd.db;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import frd.model.Lot;

public class LotManager extends JDBCManager {
	public static void createDbLotTable() throws SQLException {
		String createTableSQL = "CREATE TABLE DBLOT("
				+ "LOT_ID NUMERIC(5) NOT NULL, "
				+ "CREATED_DATE DATE NOT NULL, "
				+ "DUE_DATE DATE NOT NULL. "
				+ ")";

		execute( createTableSQL );
	}
	
	public static void insertLot(int lot_id,Date created_date, Date due_date) throws SQLException{
		String insertTableSQL = "INSERT INTO DBLOT"
			+ "(LOT_ID, LOT_DATE, DUE_DATE) " + "VALUES" +
					"(" + lot_id + "," +
					" '" + created_date + "'," +
					" '" + due_date + "')";
		
		executeUpdate( insertTableSQL );
	}
 
	public static void updateLot(int lot_Id, Date created_date, Date due_date) throws SQLException{ //PUEDE LLEGAR A ESTAR MAL!!!!!
//MIRAR EN USERMANAGERJAVA PARA TRATAR DE ENTENDER Q ONDA ACA!!!
		String updateTableSQL = "UPDATE DBLOT"
			+ " SET CREATED_DATE = '"+created_date+"' "
			+ " WHERE LOT_ID = "+lot_Id;
		String updateTableSQL2 = "UPDATE DBLOT"
			+ " SET DUE_DATE = '"+due_date+"' "
			+ " WHERE LOT_ID = "+lot_Id;
		execute( updateTableSQL );
		execute( updateTableSQL2 );
		

	}
	
	
	public static void deleteLot(int lot_id) throws SQLException{
		String deleteTableSQL = "DELETE FROM DBLOT WHERE LOT_ID = "+lot_id;
		
		execute( deleteTableSQL );
	}
	
	public static List<Lot> getLots() throws SQLException{
		List<Lot> result = new ArrayList<Lot>();
		
		String selectTableSQL = "SELECT * from DBLOT";
		
		for( HashMap<String,Object> register : executeQuery( selectTableSQL ) ){
			//Creo el usuario a partir de los datos obtenidos de la base
			Lot lot = new Lot();

			if( register.containsKey("LOT_ID") ) // SETEA UN OBJETO TIPO "LOT" CON LOS ATRIBUTOS QUE SACA DE LA BASE DE DATOS
				lot.setId( ((BigDecimal) register.get("LOT_ID")).intValue() );
			
			
			if( register.containsKey("CREATED_DATE") )
				lot.setCreateDate((Date) register.get("CREATED_DATE") );
			
			if( register.containsKey("DUE_DATE") )
				lot.setCreateDate((Date) register.get("DUE_DATE") );

			result.add( lot );
		}
		
		return result;
	}
}
