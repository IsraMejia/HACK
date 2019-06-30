import java.util.Scanner;

public class OperacionesMatematicas{

	public static void main ( String [] args){

		System.out.println("\n\tSe programara la chicharroneras");
		
		Scanner num = new Scanner(System.in);

		try{
			System.out.println("Ingrese sus numeros");
			System.out.println("Introduce el coeficiente a de ax^2");
			double a = num.nextDouble();

			System.out.println("Introduce el coeficiente b de bx");
			double b = num.nextDouble();

			System.out.println("Introduce a c");
			double c = num.nextDouble();

			boolean res = discriminante(a,b,c);

			if (res){
				operacion(a,b,c);
			}else{
				
				operacionImaginarios(a,b,c);
			}
		}catch(Exception e){
			System.err.println("No se ingreso un numero, vuelvalo a intentar");
		} 
	}

	public static boolean discriminante(double a, double b, double c){
		double cuadrado = Math.pow(b,2);
		double resultado = (cuadrado-(4*a*c));
		boolean res = (resultado >= 0) ? true : false;
		return res;
		/*Para ver si es posible realizar la operacion*/
	}

	public static void operacion(double a, double b, double c){
		double cuadrado = Math.pow(b,2);
		double r1 =( (-b)+Math.sqrt((cuadrado-(4*a*c))) )*(1/(2*a));
		double r2 =( (-b)-Math.sqrt((cuadrado-(4*a*c))) )*(1/(2*a));

		System.out.println("El primer valor de x es de : "+ r1);
		System.out.println("El sgundo valor de x es de : "+ r2);
		/*operaciones de la chicharronera*/

	}

	public static void operacionImaginarios(double a, double b, double c){
System.out.println("\nLos numeros ingresados no dan como resultado dos numeros reales, ");
System.out.println("pero puedo operarlos para darte un resultado ;)\n");
		double cuadrado = Math.pow(b,2);
		double real = ((-b)/(2*a));
		double imaginaria = (-1)*((cuadrado-(4*a*c)))*(1/(2*a)); 
		//Se covierte positiva la parte imaginaria
		imaginaria = (Math.sqrt(imaginaria));
		System.out.println("Parte Real:  "+ real);
		System.out.println("Parte imagnaria: +/- "+ imaginaria + "i");
		/*Se saca su parte real para poderla operar y la imaginaria se multiplica por -1 para operar*/
	}

}