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

import javax.swing.JComboBox;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;


public  class VENTANACALCULADORAV3 extends JFrame {
//definicion variables
	private JPanel contentPane;
	private JTextField cajatextoeuros;
	private JLabel valorEuros;
	private JLabel Etiquetamoneda2;
	private JTextField cajatextomoneda2;;
	
	//  IMPORTANTISIMO!!!!  >>>>>>recordar que float lleva f tras el nº  <<<<<<<
	float factorconversionpasado2=1.18f;
	//factorconversionpasado2=1.18f;
	float euros;
	private JLabel lblmensajecontrol;
	private JTextField cajacontrol;
	private JComboBox comboBox;
// segun http://www.cambio-euro.es/
	
	
	public VENTANACALCULADORAV3() {
		
		
		//Ventana , parámetros de este jframe concreto
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//coordenadas x e y de inicio y tamaño x e y
		setBounds(100, 100, 400, 431);
		//panel interno ventana (zona no cabecera+botones)
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//etiqueta presentación
		JLabel lblConversorDeEuro = new JLabel("CONVERSOR DE MONEDA  V3.0");
		lblConversorDeEuro.setBounds(111, 11, 223, 14);
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
		
		//etiqueta moneda
		Etiquetamoneda2 = new JLabel("SELECCIONE MONEDA");
		Etiquetamoneda2.setBounds(21, 136, 148, 14);
		contentPane.add(Etiquetamoneda2);
		
		//caja texto dolar
		cajatextomoneda2 = new JTextField();
		cajatextomoneda2.setBounds(230, 167, 135, 33);
		contentPane.add(cajatextomoneda2);
		cajatextomoneda2.setColumns(10);
		
		//Boton
		JButton Botonconvertir = new JButton("CONVERTIR");
		
		Botonconvertir.setBounds(240, 113, 118, 33);
		contentPane.add(Botonconvertir);
		
		//Etiqueta mensaje control
		lblmensajecontrol = new JLabel("Mensaje de control");
		lblmensajecontrol.setBounds(167, 301, 140, 14);
		contentPane.add(lblmensajecontrol);
		
		//Caja mensaje control
		cajacontrol = new JTextField();
		cajacontrol.setText("Introduzca valor entre 0 y 500");
		cajacontrol.setBounds(84, 343, 250, 20);
		contentPane.add(cajacontrol);
		cajacontrol.setColumns(10);
		//CON LO QUE VIENE A CONTINUACION LO HAGO NO EDITABLE
		cajacontrol.setEditable(false);
		
		//STRINGS DE MONEDAS Y DE FACTOR DE CONVERSION:
		String monedas[]= new String [3];
	      monedas[0]="Dolares";
	      monedas[1]="Libras";
	      monedas[2]="Yenes";
	      
	      float factorconversion[]= new float [3];
	     factorconversion[0]= 1.18f;
	      factorconversion[1]= 0.89f;
	      factorconversion[2]= 141.50f;
	      
		//COMBO BOX
		comboBox = new JComboBox();
		comboBox.setBounds(6, 172, 200, 22);
		contentPane.add(comboBox);
		//Opciones de seleccion del comboBox
		comboBox.addItem(monedas[0]);
		comboBox.addItem(monedas[1]);
		comboBox.addItem(monedas[2]);
		
		//ESCUCHAR SELECCION DEL COMBO BOX
		//desig +comboBox propierties+ item state changed
		///comboBox.addItemListener(new ItemListener() {
		//	public void itemStateChanged(ItemEvent e) {
		//		comboBox.getSelectedItem();
		//	}
		//});
		
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				comboBox.getSelectedItem();
				switch((String)comboBox.getSelectedItem())
				{
				case "Dolares":
					cajacontrol.setText("Ha seleccionado Dolares");
					factorconversionpasado2=factorconversion[0];
					System.out.println (factorconversionpasado2);
					break;
				
				case "Libras":
				cajacontrol.setText("Ha seleccionado Libras");
				factorconversionpasado2=factorconversion[1];
				System.out.println (factorconversionpasado2);
				break;
				
				case "Yenes":
					cajacontrol.setText("Ha seleccionado Yenes");
					factorconversionpasado2=factorconversion[2];
					System.out.println (factorconversionpasado2);
				break;
				default:
					cajacontrol.setText("PONGO LO QUE QUIERA QUE NO LO SACA");
					factorconversionpasado2=1.18f;
					System.out.println (factorconversionpasado2);
						break;
						
					
				}
			}
		});
		
		
		//Action listener lo consigo haciendo doble click en el boton
		//en modo design segun video Paco
		Botonconvertir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//lo que va hasta la llave de linea XX define acción al ejecutar click 
			
				
				try{
				euros=Float.parseFloat(cajatextoeuros.getText() );
				
				
				
				if (euros<0){
					cajacontrol.setText("Valor € por debajo del rango");
					//Limpio la casilla resultado
					cajatextomoneda2.setText("");
				}
				else if (euros>500) {cajacontrol.setText("Valor € superior al rango");
				//Limpio la casilla resultado
				cajatextomoneda2.setText("");
				
		
				}
				
				
				else {
					//float factorconversionpasado =1;
					//!!!!!COMO PUEDO EVITAR INICIALIZARLO DE UNA MANERA TAN CHAPUZERA????
	
					
					cajacontrol.setText("Valor € Correcto");
					cajatextomoneda2.setText(String.valueOf(euros*factorconversionpasado2));
				}
				
				
				
				}//A mi izda LA LLAVE DE FIN DEL TRY
				
				//Pero si no se cumple EL TIPO DE DATO=float tendremos excepcion:
				catch (Exception e) {
					//e.printStackTrace();
					//IMPORTANTE QUE NO SE INCLUYA EL CODIGO ANTERIOR
					//PARA NO INVOCAR CONSOLA
					cajacontrol.setText("Tipo de valor incorrecto");
					//Si el else formase parte del try, 
					//sobreescribiria a "Valor No es puramente numerico"
					//con "Valor € Correcto"
					
					//Limpio la casilla resultado
					//cajatextomoneda2.setText("");
				}
				
				
				
			}
		});
		
		
		
	}
}
