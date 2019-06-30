public class Datos{
	public static void main (String[] args){
	
	System.out.println("Tu nombre es: " + args[0]);
	System.out.println("Tu numCuenta es: " +args[1]);
	System.out.println("Y tu Semestre es: "+args[2]);
	
	System.out.println("Se imprimiran tus datos en automatico");
	
	for (int i=0; i<3;i++){
		System.out.println(args[i]);
	}

	}

}
