//conversor de moneda v2 INCLUYE IF Y EXCEPCIONES
//import java.awt.BorderLayout;  (never used)
//import java.awt.EventQueue;    (never used) 

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public  class Ventanav2nogit extends JFrame {
//definicion variables
	private JPanel contentPane;
	private JTextField cajatextoeuros;
	private JLabel valorEuros;
	private JLabel Etiquetadolares;
	private JTextField cajatextodolar;
	//int eurosantitxt=1;
	//variables para conversion de  moneda euros se prodria definir mas tarde
	//
	//  IMPORTANTISIMO!!!!  >>>>>>recordar que float lleva f tras el nº  <<<<<<<
	//
	
	float factorconversion=1.18f;

	float euros;
	private JLabel lblmensajecontrol;
	private JTextField cajacontrol;
// segun http://www.cambio-euro.es/
	
	public Ventanav2nogit() {
		

		//float euros;
		float factorconversion=1.18f;
		//Ventana , parámetros de este jframe concreto
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//coordenadas x e y de inicio y tamaño x e y
		setBounds(100, 100, 400, 380);
		//panel interno ventana (zona no cabecera+botones)
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//etiqueta presentación
		JLabel lblConversorDeEuro = new JLabel("CONVERSOR DE EURO A DOLAR V2.0");
		lblConversorDeEuro.setBounds(84, 11, 223, 14);
		contentPane.add(lblConversorDeEuro);
		
		//caja texto euros
		//la construyo
		cajatextoeuros = new JTextField();
		cajatextoeuros.setBounds(230, 59, 135, 33);
		//la pongo en el panel
		contentPane.add(cajatextoeuros);
		//¿Que es SET COLUMNS? , para que uso el numero de columnas?
		cajatextoeuros.setColumns(10);
		
		
		//Etiqueta euros
		valorEuros = new JLabel("INTRODUZCA VALOR \u20AC (0-500\u20AC)");
		valorEuros.setBounds(21, 59, 185, 33);
		contentPane.add(valorEuros);
		
		//etiqueta dolares
		Etiquetadolares = new JLabel("VALOR DOLARES RESULTANTE:");
		Etiquetadolares.setBounds(24, 176, 196, 14);
		contentPane.add(Etiquetadolares);
		
		//caja texto dolar
		cajatextodolar = new JTextField();
		cajatextodolar.setBounds(230, 167, 135, 33);
		contentPane.add(cajatextodolar);
		cajatextodolar.setColumns(10);
		
		//Boton
		JButton Botonconvertir = new JButton("CONVERTIR");
		
		Botonconvertir.setBounds(216, 113, 118, 33);
		contentPane.add(Botonconvertir);
		
		//Etiqueta mensaje control
		lblmensajecontrol = new JLabel("Mensaje de control");
		lblmensajecontrol.setBounds(129, 245, 140, 14);
		contentPane.add(lblmensajecontrol);
		
		//Caja mensaje control
		cajacontrol = new JTextField();
		cajacontrol.setText("Introduzca valor entre -500 y 500");
		cajacontrol.setBounds(84, 280, 250, 20);
		contentPane.add(cajacontrol);
		cajacontrol.setColumns(10);
		//CON LO QUE VIENE A CONTINUACION LO HAGO NO EDITABLE
		cajacontrol.setEditable(false);
		
		//Action listener lo consigo haciendo doble click en el boton
		//en modo design segun video Paco
		Botonconvertir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//lo que va hasta la llave de linea XX define acción al ejecutar click 
			
				
				try{
				euros=Float.parseFloat(cajatextoeuros.getText() );
				//A) Convierto el string de la cajadetextode Euros en float
				//B)Pongo en cajatextodolar el string que saco del resultado de
				//multiplicar euros por factorconversion
				cajatextodolar.setText(String.valueOf(euros*factorconversion));
				
				//CONDICIONALES
				//INNECESARIO String valornumcajatexto=ripeovalorcaja.valueOf(ripeovalorcaja);
				// numcajatexto=Integer.parseInt(ripeovalorcaja);
				
				//FLOAT A STRINT IF VICEVENSA DE  STACKOVERFLOW
				//float f = Float.parseFloat("25");
				//String s = Float.toString(25.0f);
				//float eurosintroducidos=Float.parseFloat(euros);
				if (euros<0){
					cajacontrol.setText("Valor € por debajo del rango");
					//Limpio la casilla resultado
					cajatextodolar.setText("");
				}
				else if (euros>500) {cajacontrol.setText("Valor € superior al rango");
				//Limpio la casilla resultado
				cajatextodolar.setText("");
				}
				
				else {
					cajacontrol.setText("Valor € Correcto");
					
				}
				}//A mi izda LA LLAVE DE FIN DEL TRY
				
				//Pero si no se cumple EL TIPO DE DATO=float tendremos excepcion:
				catch (Exception e) {
					//e.printStackTrace();
					//IMPORTANTE QUE NO SE INCLUYA EL CODIGO ANTERIOR
					//PARA NO INVOCAR CONSOLA
					cajacontrol.setText("Valor No es puramente numerico");
					//Si el else formase parte del try, 
					//sobreescribiria a "Valor No es puramente numerico"
					//con "Valor € Correcto"
					
					//Limpio la casilla resultado
					cajatextodolar.setText("");
				}
				
				
				
			}
		});
		
		
		
	}
}

