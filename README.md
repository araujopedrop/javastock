Proyecto del taller de java de la UTN-FRD - 2013

[Modelo de datos](http://yuml.me/9461cdff)

jframe es la clase el paquete de swing 
awt es otro paquete grafico

swing es un compatible con awt

un jframe es la ventana principal q pone el icono y ciertas cosas de navegabilidad de la app


//creacion de un objeto q da la ventana principal d la app

JFrame frame= new JFrame();

//ES OBLIGATORIO, con esto hago q cuando cierre la ventana tmb se pare el proceso

frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

frame.show();


*/un layout es el lugAr dnd van a ir los elementos

FlowLayout layout=new FlowLayout()
frame.getContentPane().setLayout(layout)


La idea es crear uno general q tenga todo lo q sea comun en la app y dsps heredar

todos los elementos arrancan con una j por ejemplo JTable, JMenu, JMenuItem, JMenuBar

JMenuItem users = new JmenuItem("usuarios");

users.addActionListener(new ActionListener(){
	//por defecto es un click
	public void actionPerformed(ActionEvent arg0)
	{
		new UserWindow();
	}
});

public CancelButton(JDialog window){
	super ("Cancelar");
}//esto se hace para q el dialog tenga referencia al boton de cerrar, d otro modo no sabria de qien es hijo