package frd.test;

import java.sql.SQLException;
import java.util.Date;


import frd.model.Product;
import frd.model.User;
import frd.db.ProductManager;

//FALTA TERMINAR
public class TestDBProduct {

	public static void main(String[] args){
		System.out.println("*********** Iniciando TEST DBPRODUCT ***********");
		try{
			//creo la tabla dbProduct
			ProductManager.createDbProductTable();
			System.out.println( "Tabla Users Creada!" );
			
			//cargo dos usuarios
			ProductManager.insertProduct(1, "Producto 1", "descr prod 1");
			ProductManager.insertProduct(2, "Producto 2", "descr prod 2");
			System.out.println( "Dos usuarios creados!" );

			//obtengo los usuarios de la bd
			System.out.println( "Listando usuarios:" );
			for( Product usr : ProductManager.getProduct() ){
				System.out.println( prod );
			}

			//modificando usuario
			ProductManager.updateProduct(2, "Usuario 2 Modificado", "admin", new Date());
			System.out.println( "Usuario 2 modificado!" );
			
			//obtengo los usuarios de la bd
			System.out.println( "Listando usuarios:" );
			for( User usr : ProductManager.getUsers() ){
				System.out.println( usr );
			}

			//borrar usuario
			ProductManager.deleteUser(1);
			System.out.println( "Usuario 1 eliminado!" );
			
			//obtengo los usuarios de la bd
			System.out.println( "Listando usuarios:" );
			for( User usr : ProductManager.getUsers() ){
				System.out.println( usr );
			}

		}catch(SQLException ex){
			System.err.println( "ERROR: " + ex.getLocalizedMessage() );
		}
		System.out.println("*********** Fin TEST DBPRODUCT ***********");
	}	
	
}
