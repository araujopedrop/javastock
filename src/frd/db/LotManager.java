package frd.db;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
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
			+ "(LOT_ID, LOT_DATE, DUE_DATE) " + "VALUES"
			+ "("+lot_Id+", '"+created_date+"', '"+due_date+"', " + "to_date('"
			+ dateFormat.format(creation.getTime()) + "', 'yyyy/mm/dd hh24:mi:ss'))";
		
		executeUpdate( insertTableSQL );
	}
 
	public static void updateLot(int lot_Id, Date created_date, Date due_date) throws SQLException{
		String updateTableSQL = "UPDATE DBLOT"
			+ " SET CREATED_DATE = '"+createdate+"' "
			+ " WHERE LOT_ID = "+userId;
		String updateTableSQL2 = "UPDATE DBLOT"
			+ " SET DUE_DATE = '"+due_date+"' "
			+ " WHERE LOT_ID = "+lot_Id;
		execute( updateTableSQL );
		execute( updateTableSQL2 );
		

	}
	
	
	public static void deleteLot(int userId) throws SQLException{
		String deleteTableSQL = "DELETE FROM DBLOT WHERE LOT_ID = "+lot_Id;
		
		execute( deleteTableSQL );
	}
	
	public static List<Lot> getLots() throws SQLException{
		List<Lot> result = new ArrayList<Lot>();
		
		String selectTableSQL = "SELECT * from DBLOT";
		
		for( HashMap<String,Object> register : executeQuery( selectTableSQL ) ){
			//Creo el usuario a partir de los datos obtenidos de la base
			Lot lot = new Lot();

			if( register.containsKey("lot_id") )
				lot.setId( ((BigDecimal) register.get("user_id")).intValue() );
			
			
			if( register.containsKey("created_by") )
				usr.setCreatedBy((String) register.get("created_by") );
			
			if( register.containsKey("create_date") )
				usr.setCreateDate((Date) register.get("create_date") );

			result.add( usr );
		}
		
		return result;
	}
}