public class HolaMundoTry{
	
	public static void main (String  [] args){
		try{
			System.out.println("Hola tu nomnbre es: "+ args[0]);
		} catch(ArrayIndexOutOfBoundsException aioobe){
			System.out.println("No se recibio la entrada");
		}

	}

}