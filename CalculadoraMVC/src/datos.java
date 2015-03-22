
public class datos {

	private String monedasarray[]={"dolares","libras","yenes"};
	private float factorconversion[]={1.10f,0.8f,150f};
	public datos() {
			
	}

	public String[] getnombresmonedas(){
		return monedasarray;
	}

	public float[] getfactoresconversion(){
		return factorconversion;
	}

}
// a mi entender esto, sería la parte "modelo" en el esquema MVC