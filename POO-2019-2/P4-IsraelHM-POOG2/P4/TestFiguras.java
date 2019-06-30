/*
1.-Multiplicacion de matrices 3x3 con hilos
2.- ejercicio de intefaces y clase abstractas

Hasta el domingo 11:59pm
*/ 

 abstract class FiguraGeometrica{
	int base = 2;

	public abstract void calcularArea();

	public void perimetro(int lados){
		int perimetro=0;
		for(int i = 0; i<lados; i++){
			perimetro +=2;
		}
		System.out.println("El perimetro de la figura es " +perimetro);
	}

}//FiguraGeometrica

class TrianguloEquilatero extends FiguraGeometrica{
	int lados;

	public TrianguloEquilatero(int lados ){
		this.lados = lados;
	}

	public void calcularArea(){
		double altura = Math.sqrt((Math.pow(base,2)-(Math.pow(base*(1/2),2))));
		double area = (base*(1/2))*altura;//se suma el area de los dos tringulos internos
		System.out.println("\nEl area de un triangulo equilatero con lados de " +base+ " unidades es :" +area+ " unidades cuadradas");

	}

}//TrianguloEquilatero

class Cuadrado extends FiguraGeometrica{
	int lados;

	public Cuadrado(int lados){
		this.lados = lados;
	}

	public void calcularArea(){
		int area = base*base;
		System.out.println("\nEl area de un cuadrado con lados de " +base+ " unidades es : " +area+ " unidades cuadradas");
	}

}//Cuadrado


public class TestFiguras {

	public static void main (String[] args){
		try{
			System.out.println("\n\tSe calculara el area y perimetro del Cuadrado :");
			Cuadrado square	 = new Cuadrado(4);
			square.calcularArea();
			int l = 4;
			square.perimetro(l);

			System.out.println("\n\tSe calculara el area y perimetro del TrianguloEquilatero :");
			TrianguloEquilatero triangle = new TrianguloEquilatero(3);
			triangle.calcularArea();
			triangle.perimetro(triangle.lados);


		}finally{
			System.out.println("\n\tQuieres hacer algo mas?");
		}




	}//main

}//Test



