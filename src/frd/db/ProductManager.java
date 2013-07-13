package frd.db;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import frd.model.Product;
import frd.model.User;

public class ProductManager extends JDBCManager {
	public static void createDbProductTable() throws SQLException {
		String createTableSQL = "CREATE TABLE DBPRODUCT("
				+ "PRODUCT_ID NUMERIC(5) NOT NULL, "
				+ "PRODUCTNAME VARCHAR(20) NOT NULL, "
				+ "DESCRIPTION VARCHAR(20) NOT NULL, "
				+ "PRIMARY KEY (PROD_ID) "
				+ ")";

		execute( createTableSQL );
	}

	public static void insertProduct(int productId, String productname, String description) throws SQLException{
		String insertTableSQL = "INSERT INTO DBUSER"
			+ "(USER_ID, USERNAME, CREATED_BY, CREATED_DATE) " + "VALUES"
			+ "("+productId+", '"+productname+"', '"+description+"')";
		
		executeUpdate( insertTableSQL );
	}	

	public static void updateProduct(int productId, String productname, String description) throws SQLException{
		String updateTableSQL = "UPDATE DBPRODUCT"
			+ " SET PRODUCTNAME = '"+productname+"' "
			+ " WHERE PRODUCT_ID = "+productId;
		
		execute( updateTableSQL );
 
	}

	public static void deleteProduct(int productId) throws SQLException{
		String deleteTableSQL = "DELETE FROM DBPRODUCT WHERE PRODUCT_ID = "+productId;
		
		execute( deleteTableSQL );
	}

	public static List<Product> getProduct() throws SQLException{
		List<Product> result = new ArrayList<Product>();
		
		String selectTableSQL = "SELECT * from DBPRODUCT";
		
		for( HashMap<String,Object> register : executeQuery( selectTableSQL ) ){
			//Creo el producto a partir de los datos obtenidos de la base
			Product prod = new Product();

			if( register.containsKey("product_id") )
				prod.setId( ((BigDecimal) register.get("product_id")).intValue() );
			
			if( register.containsKey("productname") )
				prod.setName((String) register.get("productname") );
			
			if( register.containsKey("description") )
				prod.setDescription((String) register.get("description") );

			result.add( prod );
		}
		
		return result;
	}	

}
