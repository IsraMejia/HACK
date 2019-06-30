/*Actividades P3:
-Crear metodo para aumentar sueldo en empleado:
	-El sueldo que reciben los empleados no tiene que ser mayor al del lider
	-El sueldo no tiene que ser igual a 0 , lanzar excepcion
	-El sueldo del diseñador no puede ser menor al del desarrollador
creo que se tiene que usar instanceof
-implements para de algunamanera simular la erencia de excepciones de la clase exceptiocesSueldoque se va a crear
*/
import java.util.Scanner;
import java.util.Hashtable;

class Empleado{
	String clave;
	double salario;
	String nombre;
	String puesto;

	public void registrarEntrada(){
		System.out.println("Estoy llegando a mi trabajo...");
	}

	public void trabajar(){
		System.out.println("Estoy trabajando...");
	}

	public void registrarSalida(){
		System.out.println("Hasta pronto. Ya me voy a casa...");
	}

	public void aumentarSalario() throws ExceptionSalario{
		if(salario <= 0){
			throw new ExceptionSalario("No se puede tener sueldos igual o menores a 0 ");
		}else{
			System.out.println("Se analiza si te puedo subir el sueldo");
		}
	}
//Se crea la clase empleado con sus atributos de tipo cadena y double.
//De igual forma se crean sus metodos para interactuar con el equipo
}

//-------------------------------------------Lider de Proyecto
  class LiderDeProyecto extends Empleado{
	//se crea el Lider de proyecto que hereda metodos y atributos de empleado
	Hashtable<String, Empleado> equipoDeTrabajo; 
	//El lider de proyecto crea la estructura del hashtable del equipo de trabajo con los empleados

	public LiderDeProyecto(String clave, String nombre, double salario, Hashtable<String, Empleado> equipo){
		this.puesto = "Lider de Proyecto";
		this.clave = clave;
		this.salario = salario;
		this.equipoDeTrabajo = equipo;
//Metodo constructor del LiderDeProyecto el cual con "this" se le asignan valores sus atributos heredados de empleado
// asi como se le asigna su propio equipo de trabajo
	}

	public void asignarTarea(Empleado e){
		this.trabajar();
		System.out.println("Asignando actividad a "+e.nombre);
		if(e instanceof DesarrolladorJava){
			DesarrolladorJava dj = (DesarrolladorJava)e;
			dj.trabajoTerminado = false;	
		}
/*Se crea el metodo asignar tarea donde recibe un empleado, si este es desarrollador java se se le dice que aun no 
ha acabado su trabajo*/
	}

	public void convocarReunion(){
		System.out.println("Convocando reunion de trabajo...");		
	}
	//De igual forma el lider del proyecto puede convocar una reunion

	public void aumentarseSalario() throws ExceptionSalario{
		if(salario <= 0){
			throw new ExceptionSalario("No se puede tener sueldos igual o menores a 0 ");
		}else{
			System.out.println("Me deberia de aumentar el sueldo yo mismo? ");
			System.out.println("Obviamente si¡¡¡¡¡, solo 200 dolares mas porque no voy a abusar jaja");
			this.salario += 200;
		}
	}

	public void aumentarSalarioEmpleados(Empleado e)throws ExceptionSalario{

		if(e instanceof DesarrolladorJava){
			DesarrolladorJava dj= (DesarrolladorJava)e;
				if(dj.salario > 1500 || (dj.salario+100) > 1500){
					throw new ExceptionSalario("Lo siento, no me autorizaron el aumento");
				}else{
					System.out.println("Intentare subirte el sueldo");
					dj.salario += 100;
					System.out.println("Listo :D, tu sueldo ahora es de " + dj.salario);
				}
		}

		if( e instanceof Diseniador){
			Diseniador d= (Diseniador)e;					
			if(d.salario > 1500 || (d.salario+100) > 1500){
				throw new ExceptionSalario("Lo siento, no me autorizaron el aumento");
			}else{
				System.out.println("Intentare subirte el sueldo");
				d.salario += 100;
				System.out.println("Listo :D, tu sueldo ahora es de " + d.salario);
			}
		}

		if( e instanceof Tester){
			Tester t= (Tester)e;
				if(t.salario > 1500 || (t.salario+100) > 1500){
					throw new ExceptionSalario("Lo siento, no me autorizaron el aumento");
				}else{
					System.out.println("Intentare subirte el sueldo");
					t.salario += 100;
					System.out.println("Listo :D, tu sueldo ahora es de " + t.salario);
				}
/*Metodo en el que al invocarlo mediante el lider de proyecto recibe a un empleado y dependiendo a este y sus caracteristicas
se le sube su sueldo o no 
*/

	}

}//fin class LiderDeProyecto




//-------------------------------------------DesarrolladorJava
public static class DesarrolladorJava extends Empleado{
	int horasSinDormir;
	boolean trabajoTerminado;
	

	public DesarrolladorJava(String nombre, String clave){
		this.nombre = nombre;
		this.clave = clave;
		this.horasSinDormir = 0;
		this.salario = 1000;
	}

	public void trabajar(){
		System.out.println("Transformando café en energía...");
		super.trabajar();
		this.horasSinDormir ++;

	}

	public void dormir(){
		if(this.trabajoTerminado) System.out.println("Al fin voy a dormir!!!");
		else this.trabajar();
	}

	public void SubirSueldo(Empleado e){

	}
/*Se crea la clase DesarrolladorJava el cual hereda de empleado y tiene 2 atributos adicionales como 
horaSinDormir y trabajoTermindado. De igual forma tiene su metodo constructor donde se le asignan valores a sus
atributos nombre, clave y horas sin dormir.
De igual forma tiene sus metodos trabajar donde manda a llamar su metodo de empleado trabajar y se incrementan sus 
horas sin dormir. Por ultimo contiene su metodo dormir donde si acabo su trabajo se ire a dormis si no seguira trabajando*/
}


//-------------------------------------------Diseñador
public static class Diseniador extends Empleado{
	public Diseniador(String clave , int salario)throws ExceptionSalario{
		this.clave = clave;
			if(salario < 1000){
				throw new ExceptionSalario("Soy diseñador, no puedo ganar menos que un DesarrolladorJava");
			}else{
			this.salario=salario;
			}
	}

	public void trabajar(){
		System.out.println("Diseñando una interfaz gráfica");
	}
/*Se crea la clase diseñador que hereda de empleado y tiene su metodo constructor donde se le asigna con una cadena
su clave y otro metodo donde dice que trabaja en la interfaz grafica*/
}
//-------------------------------------------Tester
public static class Tester extends Empleado{
	int salario = 900;
	public Tester(String clave){
		this.clave = clave;
	}
	public void trabajar(boolean faseTerminada){
		if(faseTerminada){
			System.out.println("Haciendo pruebas...");
		}else
			System.out.println("Planificando las pruebas...");
	}
/* Se crea la clase Tester que hereda de empleado donde se le asigna su clave con su metodo constructor. 
Por ultimo contiene su metodo trabajar donde se crea su boolean fase terminada la cual si es verdadera hace las prubas
y si no esta planificando las mismas*/
}

//-------------------------------------------Exception
public static class ExceptionSalario extends Exception{
	public ExceptionSalario (String mensaje){
		super(mensaje);
	}//Se crea la clase ExceptionSalario que hereda de Exption con el cual con el metodo del mismo nombre se imprime
	// a pantalla el mensaje que se decida poner respecto a la excepcion en el codigo
}






//-------------------------------------------Proyecto
public class Proyecto{
/* Se crea la clase Proyecto, el cual contien el hash table equipo, 3 desarolladores java, 2 diseñadores y 3 tester.
Se agregan a todos los integrantes al hashtable equipo con el metodo ".put", me parece que lso diseñadores comparten la 
misma clave en el Hashtable
*/
	public static void main(String[] args) {
		Hashtable equipo = new Hashtable();
		
		DesarrolladorJava hugo = new DesarrolladorJava("Hugo", "devj01");
		DesarrolladorJava paco = new DesarrolladorJava("Paco", "devj02");
		DesarrolladorJava luis = new DesarrolladorJava("Luis", "devj03");

		Diseniador daisy = new Diseniador("des01",1100);
		Diseniador minnie = new Diseniador("des02",1100);

		daisy.nombre = "daisy";

		Tester donald = new Tester("test01");
		Tester mickey = new Tester("test02");
		Tester goofy = new Tester("test03");

		equipo.put(hugo.clave, hugo);
		equipo.put(paco.clave, paco);
		equipo.put(luis.clave, luis);
		equipo.put(daisy.clave, daisy);
		equipo.put(minnie.clave, daisy);
		equipo.put(donald.clave, donald);
		equipo.put(mickey.clave, mickey);
		equipo.put(goofy.clave, goofy);

		Diseniador d = (Diseniador)equipo.get(daisy.clave);

		System.out.println("Hola, soy "+d.nombre);//imprime en pantalla con el  nombre de daisy

		LiderDeProyecto pedro = new LiderDeProyecto("p123", "Pedro", 15000.00, equipo);
		//Se crea el lider del proyecto con sus propios atibutos haciendo yso de su metodo constructor

		pedro.asignarTarea((Empleado)equipo.get(luis.clave));	
//El lider de proyecto le asina la tarea al	desarollador java Luis, para esto tiene que hacer el casting a Empleado
//ya que asi se asigno la funcion para que el lider de proyecto pueda asignarle tarea a Todos los empleados

		luis.trabajar();//Luis trabaja
		luis.dormir();// Luis no duerme al no poder cambiar a true su boolean trabajoTerminado
 	int op =0;	
 	do{
 		Scanner o = new Scanner(System.in); //int op = o.nextInt();
 		System.out.println("Ahora se intentara subir el sueldo a distintos integrantes del equipo");
 		System.out.println("Escoge a quien quieras que pida subir su sueldo:");
		System.out.println("1) DesarrolladorJava");
		System.out.println("2) Diseniador");
		System.out.println("3) Tester");
		System.out.println("4) LiderDeProyecto");
		System.out.println("\n\t 5)Salir  ");
		op = o.nextInt();

		switch(op){
			case 1 : 
				System.out.println("Intentaremos subirle el sueldo al DesarrolladorJava");
				pedro.aumentarSalarioEmpleados(hugo);	

			break;

			case 2 : 
				System.out.println("Intentaremos subirle el sueldo al Diseniador");
				pedro.aumentarSalarioEmpleados(daisy);	
			break;

			case 3 : 
				System.out.println("Intentaremos subirle el sueldo al Tester");
				pedro.aumentarSalarioEmpleados(donald);	
			break;

			case 4 : 
				System.out.println("Intentaremos subirle el sueldo al LiderDeProyecto");
				pedro.aumentarSalarioEmpleados(pedro);	
			break;

			case 5 : 
				System.out.println("has escogido salir del programa");
			break;

			default:
				System.out.println("Opcion invalida");
			break;
		}
		/*Menu donde se escoge a que tipo de empleado subirle el sueldo y se lo hace o no mediante 
		el metodo aumentarSalarioEmpleados del lider de proyecto de pedro*/
 	}while(op != 5);

	}
}
}


