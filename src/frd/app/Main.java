	package frd.app;

import java.awt.FlowLayout;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Main {
	private static Scanner scanIn = new Scanner(System.in);

	public static void main(String[] args){
		System.out.println("*********** Iniciando ***********");
		System.out.println("q:salir, u:listar usuarios, u-add:agregar usuario, u-del:borrar usuario");
		//clase "app"
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		FlowLayout layout=new FlowLayout();
		
		frame.getContentPane().setLayout(layout);
		frame.setTitle("java business");
		frame.setLocation(100,200);
		frame.setSize(300,200);
		//ES OBLIGATORIO, con esto hago q cuando cierre la ventana tmb se pare el proceso
		JLabel title= new JLabel("Sistema de riesgos");
		JButton boton= new JButton("Benjamin Boton");
		frame.getContentPane().add(title);
		frame.getContentPane().add(boton);
		
		

		frame.show();
		
		String response = scanIn.nextLine();
		while( !"q".equalsIgnoreCase(response) ){

			if( "u".equalsIgnoreCase(response) ){
				UserUI.showAll();
			}
			
			if( "u-add".equalsIgnoreCase(response) ){
				UserUI.add( scanIn );
			}
			
			if( "u-del".equalsIgnoreCase(response) ){
				UserUI.del( scanIn );
			}
			
			System.out.println(">");
			response = scanIn.nextLine();
		}
		
        System.out.println("*********** Fin de app ***********");
	}
}
