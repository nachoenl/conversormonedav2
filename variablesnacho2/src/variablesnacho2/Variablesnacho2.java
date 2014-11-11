package variablesnacho2;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class Variablesnacho2 extends JFrame {
//creamos la clase variablesnacho2 que utiliza (extends) JFrame
	private JPanel contentPane;
	private JTextField CajadetextonachotextField;
	JLabel lblNachoetiqueta = new JLabel("Nachoetiqueta");
	private JLabel lblEtiqueta;
	
	private JTextField cajatextoabajoizda;
	private JTextField cajadetextodrcha;
	private JTextField cajatextodowleft;
	private JTextField cajatextodownright;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			//ARRANQUE de la ventana
			public void run() {
				try {
					Variablesnacho2 marcoexframe = new Variablesnacho2();
					marcoexframe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			//fin arranque ventana
		});
	}

	/**
	 * Create the frame.
	 */
	

	
	public Variablesnacho2() {
		
		//zona de definicion de variables a continuacion
		
		// de momento se podria poner la asignacion de entero1 y de valorcajatxt antes de "public Variablesnacho2() {"
		int entero1 = 23;
		int entero2 = 22;
		//Si, soy consciente de que no utilizo por ahora la variable entero2
		String valorcajatxt="saludo";
		String valorcajaderecha="";
		String valorcajaabajoizda="";
		String valorcajaabajoderecha="";
		float valordecimal=45.85657f;
		// alternativa dada por quick fix al no poner la f detras del numero:
				//float valordecimal= (float) 45.85657;
		float valordecima2=73.5156f;
		//POR QUE DIANTRES OBTENGO LO SIGUIENTE???
		//Multiple markers at this line
		//- The value of the local variable valordecima2 is 
		// not used
		//- Duplicate local variable valordecimal
		boolean noyesqueno=false;
		boolean sayyeah=true;
		valorcajaderecha = Float.toString(valordecimal);
		valorcajaabajoizda = Boolean.toString(noyesqueno);
		valorcajaabajoderecha=Boolean.toString(sayyeah);
		
		// Prueba:Asigno a la variable cadenatextonacho de tipo string el valor "Blesa for resident" 
		String cadenatextonacho="Blesa for president";
		
		//FIN zona definiciones de variables
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(180, 140, 650, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// la variable cajadetextonachotestfield es un Jtext field para mostrar información
		//  definido en linea 15 con private JTextField CajadetextonachotextField; 
		
		//primera caja de texto
		CajadetextonachotextField = new JTextField();
		CajadetextonachotextField.setBounds(91, 48, 65, 46);
		contentPane.add(CajadetextonachotextField);
		CajadetextonachotextField.setColumns(10);
		
		CajadetextonachotextField.setText(cadenatextonacho);
		// Esto borra el valor anterior de la caja "Blesa for..."=> CajadetextonachotextField.setText("esto borra lo anterior ¿como merge?");
		
		//Etiquetas
		lblNachoetiqueta.setBounds(92, 23, 86, 14);
		contentPane.add(lblNachoetiqueta);
		
		lblEtiqueta = new JLabel("etiquetapruebas");
		lblEtiqueta.setBounds(217, 284, 109, 20);
		contentPane.add(lblEtiqueta);
		
		// Ej de procedimiento para Visualizar en un textfield valor NO variable  
		//CajadetextonachotextField.setText ("holita") ;
		
		//Metodo para CONVERTIR INTEGER EN STRING asignando el valor a la variable valorcajatxt 
		// definita anteriormente
		
		valorcajatxt=Integer.toString(entero1);
		CajadetextonachotextField.setText(valorcajatxt);
		
		//esta linea anterior es la que hace que en la caja de texto salga valorcajatxt en lugar 
		//de blesa for president
		
		cajatextoabajoizda = new JTextField();
		cajatextoabajoizda.setText("Blesa for president");
		cajatextoabajoizda.setColumns(10);
		cajatextoabajoizda.setBounds(192, 307, 109, 54);
		contentPane.add(cajatextoabajoizda);
		
		//etiqueta para arriba-derecha
		JLabel lblEtiquetaderecha = new JLabel("Etiquetaderecha");
		lblEtiquetaderecha.setBounds(280, 23, 93, 14);
		contentPane.add(lblEtiquetaderecha);
		
		//Contenido etc caja de texto arriba izda
		cajadetextodrcha = new JTextField();
		// pongo aqui algoritmo para mostrar valor decimal como texto
		
		cajadetextodrcha.setText(valorcajaderecha);
		cajadetextodrcha.setBounds(290, 48, 76, 37);
		contentPane.add(cajadetextodrcha);
		cajadetextodrcha.setColumns(10);
		
		//etiqueta para arriba derecha
		JLabel lblEtiquetadownleft = new JLabel("Etiquetabajoizda");
		lblEtiquetadownleft.setBounds(92, 163, 101, 14);
		contentPane.add(lblEtiquetadownleft);
		
		//Contenido y def caja abajo izda
		cajatextodowleft = new JTextField();
		cajatextodowleft.setText(valorcajaabajoizda);
		cajatextodowleft.setBounds(92, 188, 86, 46);
		contentPane.add(cajatextodowleft);
		cajatextodowleft.setColumns(10);
		
		cajatextodowleft.setText(valorcajaabajoizda);	
		
		
		//Contenido caja abajo-derecha y SU ETIQUETA 
		JLabel lblEtiquetabajodrcha = new JLabel("etiquetabajodrcha");
		lblEtiquetabajodrcha.setBounds(290, 163, 109, 14);
		contentPane.add(lblEtiquetabajodrcha);
		
		
		cajatextodownright = new JTextField();
		cajatextodownright.setBounds(290, 188, 86, 46);
		contentPane.add(cajatextodownright);
		cajatextodownright.setColumns(10);

		cajatextodownright.setText(valorcajaabajoderecha);
		// CajadetextonachotextField.setText(cadenatextonacho); => Esto haría que en la caja de texto se lea Blesa for president en lugar de valorcajatxt
		
	//imprimir valor de las variables entero1 etc en console
		System.out.println (cadenatextonacho);
		System.out.println (entero1);
		System.out.println (valordecimal);
		System.out.println (valordecima2);
		System.out.println (noyesqueno);
		System.out.println (sayyeah);
	}
}

