public class Usuario {

	
	public static void main(String[] args) {
		
    //el main se limita a crear el objeto de la clase conversor , lo que sería la parte "controlador" pero
	//asi, tambien hace visible la interfaz grafica "vista" para el usuario que el la ventana jframe y atrapar
	//el error de excepcion en caso de producirse. Es código que originalmente pertenece a la 
	//clase conversor pero tiene mas sentido ponerlo aqui var seguir un esquema MVC	
		try {
			Conversor frame = new Conversor();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}


//codigo "default" de eclipse:
//
//public class Usuario {
//
//	public Usuario() {
//		// TODO Auto-generated constructor stub
//	}
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}
//
//}
