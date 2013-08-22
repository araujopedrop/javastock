package frd.test;

import java.sql.SQLException;
import java.util.Date;

import frd.db.LotManager;
import frd.model.Lot;

public class TestLot {
	@SuppressWarnings("deprecation")
	public static void main(String[] args){
		System.out.println("*********** Iniciando TEST DBLOT ***********");
		try{
			LotManager.createDbLotTable();
			System.out.println( "Tabla Lot Creada!" );
			
			LotManager.insertLot(1, new Date(), new Date());
			LotManager.insertLot(2, new Date(), new Date());
			System.out.println( "Dos lot creados!" );

			//obtengo los usuarios de la bd
			System.out.println( "Listando lotes:" );
			for( Lot lot : LotManager.getLots() ){
				System.out.println( lot );
		}
		
	

//			//modificando usuario
//			UserManager.updateUser(2, "Usuario 2 Modificado", "admin", new Date());
//			System.out.println( "Usuario 2 modificado!" );
//			
//			//obtengo los usuarios de la bd
//			System.out.println( "Listando usuarios:" );
//			for( User usr : UserManager.getUsers() ){
//				System.out.println( usr );
//			}
//
//			//borrar usuario
//			UserManager.deleteUser(1);
//			System.out.println( "Usuario 1 eliminado!" );
//			
//			//obtengo los usuarios de la bd
//			System.out.println( "Listando usuarios:" );
//			for( User usr : UserManager.getUsers() ){
//				System.out.println( usr );
//			}
//
		}catch(SQLException ex){
			System.err.println( "ERROR: " + ex.getLocalizedMessage() );
		}
		System.out.println("*********** Fin TEST DBLOT ***********");
	}
}
