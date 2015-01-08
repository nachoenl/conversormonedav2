import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class MICLASECONVERSORNACHO extends JFrame {
//definicion variables
	private JPanel contentPane;
	private JTextField cajatextoeuros;
	private JLabel valorEuros;
	private JLabel Etiquetadolares;
	private JTextField cajatextodolar;
	
	//variables para conversion de  moneda euros se prodria definir mas tarde
	//
	//  IMPORTANTISIMO!!!!  >>>>>>recordar que float lleva f tras el nº  <<<<<<<
	//
	// float euros=0f;   ---->No sirve de nada definir aqui si se
	
	// usa luego dentro del botón solo
	float factorconversion=1.18f;
	// INVESTIGAR EL AMBITO DE VARIABLES!!!
	// DEFINO FACTOR CONVERSION EN AMBOS LADOS DE PUBLIC Y LE DA IGUAL
	float euros;
 // segun http://www.cambio-euro.es/ el cambio es 1.18 a 8 de enero 2015
	
	public MICLASECONVERSORNACHO() {
		
	//	ANTIGUO CODIGO DEL MAIN
	///**
	// * Launch the application.
	 //*/
	//
	//public static void main(String[] args) {
	//	EventQueue.invokeLater(new Runnable() {
	//		public void run() {
	//			try {
	//				MICLASECONVERSORNACHO frame = new MICLASECONVERSORNACHO();
	//				frame.setVisible(true);
	//			} catch (Exception e) {
	//				e.printStackTrace();
	//			}
	//		}
	//	});
	//}
	//MICLASECONVERSORNACHO frame = new MICLASECONVERSORNACHO();
	///**
	 //* Create the frame.
	// */
		//FIN ANTIGUO CODIGO DEL MAIN
		
		//investigar ambitos de estas dos variables , NO hay error de doble DEFINICION
		//que si se da en el codigo y lo que se define aqui dentro del
		//public MICLASECONVERSORNACHO() {
		//lo no encuentra dentro del BOTON
		//pero fuera de ello
		//y dentro del
		//public class MICLASECONVERSORNACHO extends JFrame {
		//si
		//float euros;
		float factorconversion=1.18f;
		//Ventana , parámetros de este jframe concreto
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//coordenadas x e y de inicio y tamaño x e y
		setBounds(100, 100, 400, 300);
		//panel interno ventana (zona no cabecera+botones)
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//etiqueta presentación
		JLabel lblConversorDeEuro = new JLabel("CONVERSOR DE EURO A DOLAR");
		lblConversorDeEuro.setBounds(84, 11, 184, 14);
		contentPane.add(lblConversorDeEuro);
		
		//caja texto euros
		//la construyo
		cajatextoeuros = new JTextField();
		cajatextoeuros.setBounds(216, 59, 166, 33);
		//la pongo en el panel
		contentPane.add(cajatextoeuros);
		//¿Que es SET COLUMNS? , para que uso el numero de columnas?
		cajatextoeuros.setColumns(10);
		
		
		//Etiqueta euros
		valorEuros = new JLabel("INTRODUZCA VALOR EUROS");
		valorEuros.setBounds(10, 68, 171, 14);
		contentPane.add(valorEuros);
		
		//etiqueta dolares
		Etiquetadolares = new JLabel("VALOR DOLARES RESULTANTE");
		Etiquetadolares.setBounds(10, 194, 196, 14);
		contentPane.add(Etiquetadolares);
		
		//caja texto dolar
		cajatextodolar = new JTextField();
		cajatextodolar.setBounds(216, 193, 166, 33);
		contentPane.add(cajatextodolar);
		cajatextodolar.setColumns(10);
		
		//Boton
		JButton Botonconvertir = new JButton("CONVERTIR");
		//Action listener lo consigo haciendo doble click en el boton
		//en modo design segun video Paco
		Botonconvertir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//lo que va hasta la llave de linea XX define acción al ejecutar click 
			
				//A) Convierto el string de la cajadetextode Euros en float
				euros=Float.parseFloat(cajatextoeuros.getText() );
				//Pongo en cajatextodolar el string que saco del resultado de
				//multiplicar euros por factorconversion
				cajatextodolar.setText(String.valueOf(euros*factorconversion));
			}
		});
		Botonconvertir.setBounds(126, 121, 118, 33);
		contentPane.add(Botonconvertir);
		
		
	}
}
