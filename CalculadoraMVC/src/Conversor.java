import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;


public class Conversor extends JFrame {
    //variables
	private JPanel contentPane;
	private JTextField mensajecontrol;
	private JTextField cajatextoeuros;
	private JTextField cajatextoresultado;
    private float factorconversion2;
	private float euros;//no voy a utilizar variable para el resultado, lo sacaré por el textfield directamente
    private datos datosimportados;//sin el private tambien valdría
	private String importadormonedas[];
	private float importadorfactores[];
	
	/**
	 * Create the frame.
	 */
	//constructor
	public Conversor() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
    // comienzo a dibujar elementos graficos 
		
		//ventana
		setBounds(100, 100, 421, 444);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Combobox
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(139, 102, 174, 32);
		contentPane.add(comboBox);
		
		//BOTON
		JButton boton = new JButton("convertir");
		boton.setBounds(139, 176, 86, 32);
		contentPane.add(boton);
		//FIN BOTON
		
		//mensaje de control
		mensajecontrol = new JTextField();
		mensajecontrol.setBounds(90, 338, 263, 26);
		contentPane.add(mensajecontrol);
		mensajecontrol.setColumns(10);
		mensajecontrol.setEditable(false);//hago que sea inborrable el mensaje de control
		//
		
		//JLABELS
		JLabel lblNewLabel = new JLabel("Conversor V4 (arrays,for,mvc)");
		lblNewLabel.setBounds(76, 11, 229, 26);
		contentPane.add(lblNewLabel);
		
		JLabel lblSeleccionaMoneda = new JLabel("Selecciona moneda");
		lblSeleccionaMoneda.setBounds(10, 105, 119, 26);
		contentPane.add(lblSeleccionaMoneda);
		
		JLabel lblResultado = new JLabel("Resultado");
		lblResultado.setBounds(21, 250, 58, 29);
		contentPane.add(lblResultado);
		
		JLabel lblIntroduceValorEn = new JLabel(" Introduce valor en euros");
		lblIntroduceValorEn.setBounds(10, 57, 147, 14);
		contentPane.add(lblIntroduceValorEn);
		//FIN JLABELS
		
		//caja de texto para introducir euros a convertir
		cajatextoeuros = new JTextField();
		cajatextoeuros.setBounds(187, 48, 113, 32);
		contentPane.add(cajatextoeuros);
		cajatextoeuros.setColumns(10);
		
		
		//caja texto resultado operacion
		cajatextoresultado = new JTextField();
		cajatextoresultado.setBounds(187, 248, 113, 32);
		contentPane.add(cajatextoresultado);
		cajatextoresultado.setColumns(10);
		
		JLabel lblInfo = new JLabel("Info");
		lblInfo.setBounds(10, 344, 49, 14);
		contentPane.add(lblInfo);
		
	//FIN DE DIBUJAR ELEMENTOS
		
	// Bienvenida /Normas de uso de los valores a convertir (de 0 a 500€)
		mensajecontrol.setText("Bienvenido: valores a convertir de 0 a 500€");
		
	//IMPORTarDAToS DE LA CLASE DATOS
		datosimportados=new datos();//se ha definido en la liena 22 opcion B: datos datosimportados=new datos();
		importadormonedas=datosimportados.getnombresmonedas();
		importadorfactores=datosimportados.getfactoresconversion();
	//MUY IMPORTANTE:
		factorconversion2=importadorfactores[0];//Por si no se elije moneda se carga por defecto el valor de conversion de la primera moneda de la lista subida al comboBox
	
	//cargo datos importados del array de nombres de monedas "importadormonedas" en el combobox
		for (int a=0; a<importadormonedas.length;a=a+1)
		{
			comboBox.addItem(importadormonedas[a]);
		}
		
	
		
	//escuchar al comboBOx
	 //se consige con: design +comboBox propierties+ show events+item state changed
				//CODIGO "default":
		        ///comboBox.addItemListener(new ItemListener() {
				//	public void itemStateChanged(ItemEvent e) {
				//		comboBox.getSelectedItem();
				//	}
				//});      //Fin del codigo default
		//MUY importante cambiamos ItemEvent e por ItemEventArg 0;
		
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
			  mensajecontrol.setText("MONEDA DESTINO :"+comboBox.getSelectedItem());
				//La linea clave =>con esto igualo el indice de factor de conversion a su moneda
			  factorconversion2=importadorfactores[comboBox.getSelectedIndex()];
			
			//codigo alternativo sin usar variable factorconversion2
			//factorconversion2=datosimportados.getfactoresconversion()[comboBox.getSelectedIndex()];
			}
		});//Fin de escuchar al combobox
		
		
		//ESCUCHAR AL BOTON de convertir
		boton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		//

				try{
				euros=Float.parseFloat(cajatextoeuros.getText() );
				
				
				
				if (euros<0){
					mensajecontrol.setText("Valor € por debajo del rango");
					//Limpio la casilla resultado
					cajatextoresultado.setText("");
				}
				else if (euros>500) {
					mensajecontrol.setText("Valor € superior al rango");
				//Limpio la casilla resultado
					cajatextoresultado.setText("");
				
		
				}
				
				
				else {
					
					mensajecontrol.setText("Valor € Correcto");
					cajatextoresultado.setText(String.valueOf(euros*factorconversion2));
					//Como todo esta OK ahora caso el resultado=euros*factorconversion2
				}
				
				
				
				}//LLAVE DE FIN DEL TRY
				
				//Si no se cumple TIPO DE DATO=float tendremos excepcion:
				catch (Exception e) {
					//e.printStackTrace();
					//IMPORTANTE QUE NO SE INCLUYA EL CODIGO ANTERIOR
					//PARA NO INVOCAR CONSOLA
					mensajecontrol.setText("Tipo de valor incorrecto");
					
				}
				
	    //
			}//fin del metodo de accion pulsar boton actionPerformed(ActionEvent arg0)
		});
		// Fin de escuchar botón (action listener)
	}//Fin del constructor Conversor
}//Fin de la clase Conversor
