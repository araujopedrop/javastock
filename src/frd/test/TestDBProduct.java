package frd.test;

import java.sql.SQLException;
import frd.model.Product;
import frd.db.ProductManager;

//FALTA TERMINAR
public class TestDBProduct {

	public static void main(String[] args){
		System.out.println("*********** Iniciando TEST DBPRODUCT ***********");
		try{
			//creo la tabla dbProduct
			ProductManager.createDbProductTable();
			System.out.println( "Tabla Product Creada!" );
			
			//cargo dos productos
			ProductManager.insertProduct(1, "Producto 1", "descr prod 1");
			ProductManager.insertProduct(2, "Producto 2", "descr prod 2");
			System.out.println( "Dos Productos creados!" );

			//obtengo los productos de la bd
			System.out.println( "Listando productos:" );
			for( Product prod : ProductManager.getProduct() ){
				System.out.println( prod );
			}

			//modificando producto
			ProductManager.updateProduct(2, "Producto 2 Modificado", "admin");
			System.out.println( "Producto 2 modificado!" );
			
			//obtengo los Productos de la bd
			System.out.println( "Listando productos:" );
			for( Product prod : ProductManager.getProduct() ){
				System.out.println( prod );
			}

			//borrar producto
			ProductManager.deleteProduct(1);
			System.out.println( "Producto 1 eliminado!" );
			
			//obtengo los productos de la bd
			System.out.println( "Listando productos:" );
			for( Product prod : ProductManager.getProduct() ){
				System.out.println( prod );
			}

		}catch(SQLException ex){
			System.err.println( "ERROR: " + ex.getLocalizedMessage() );
		}
		System.out.println("*********** Fin TEST DBPRODUCT ***********");
	}	
	
}
