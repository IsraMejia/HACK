import java.util.Scanner;

public class OperacionesMatematicas{

	public static void main ( String [] args){

		System.out.println("\n\tEste programa te resuelve cualquier");
		System.out.println("ejercicio relacionado a la regla general 'chicharronera' ");
		
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

			//(res)? operacion(a,b,c) : System.err.println("Fuera de los reales :o ");
			if (res == true ){
				operacion(a,b,c);
			}else{
				System.out.println("Los resultados estan fuera de los numeros reales :o ");
			}
		}catch(Exception e){
			System.err.println("No se ingreso un numero");
		}


	}

	public static boolean discriminante(double a, double b, double c){
		boolean res = false;
		double cuadrado = Math.pow(b,2);
		double resultado =(cuadrado-(4*a*c));
		res = (resultado >= 0) ? true : false;
		return res;
	}

	public static void operacion(double a, double b, double c){
		double cuadrado = Math.pow(b,2);
		double r1 =( (-b)+Math.sqrt((cuadrado-(4*a*c))) )*(1/(2*a));
		double r2 =( (-b)-Math.sqrt((cuadrado-(4*a*c))) )*(1/(2*a));

		System.out.println("El primer valor de x es de : "+ r1);
		System.out.println("El sgundo valor de x es de : "+ r2);

	}

}