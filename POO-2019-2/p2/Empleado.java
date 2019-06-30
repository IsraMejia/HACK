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
//Se crea la clase empleado con sus atributos de tipo cadena y double.
//De igual forma se crean sus metodos para interactuar con el equipo
}

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
}

class DesarrolladorJava extends Empleado{
	int horasSinDormir;
	boolean trabajoTerminado;

	public DesarrolladorJava(String nombre, String clave){
		this.nombre = nombre;
		this.clave = clave;
		this.horasSinDormir = 0;
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
/*Se crea la clase DesarrolladorJava el cual hereda de empleado y tiene 2 atributos adicionales como 
horaSinDormir y trabajoTermindado. De igual forma tiene su metodo constructor donde se le asignan valores a sus
atributos nombre, clave y horas sin dormir.
De igual forma tiene sus metodos trabajar donde manda a llamar su metodo de empleado trabajar y se incrementan sus 
horas sin dormir. Por ultimo contiene su metodo dormir donde si acabo su trabajo se ire a dormis si no seguira trabajando*/
}

class Diseniador extends Empleado{
	public Diseniador(String clave){
		this.clave = clave;
	}

	public void trabajar(){
		System.out.println("Diseñando una interfaz gráfica");
	}
/*Se crea la clase diseñador que hereda de empleado y tiene su metodo constructor donde se le asigna con una cadena
su clave y otro metodo donde dice que trabaja en la interfaz grafica*/
}

class Tester extends Empleado{
	public Tester(String clave){
		this.clave = clave;
	}
	public void trabajar(boolean faseTerminada){
		if(faseTerminada){
			System.out.println("Haciendo pruebas...");
		}else System.out.println("Planificando las pruebas...");
	}
/* Se crea la clase Tester que hereda de empleado donde se le asigna su clave con su metodo constructor. 
Por ultimo contiene su metodo trabajar donde se crea su boolean fase terminada la cual si es verdadera hace las prubas
y si no esta planificando las mismas*/
}

class Proyecto{
/* Se crea la clase Proyecto, el cual contien el hash table equipo, 3 desarolladores java, 2 diseñadores y 3 tester.
Se agregan a todos los integrantes al hashtable equipo con el metodo ".put", me parece que lso diseñadores comparten la 
misma clave en el Hashtable
*/
	public static void main(String[] args) {
		Hashtable equipo = new Hashtable();
		
		DesarrolladorJava hugo = new DesarrolladorJava("Hugo", "devj01");
		DesarrolladorJava paco = new DesarrolladorJava("Paco", "devj02");
		DesarrolladorJava luis = new DesarrolladorJava("Luis", "devj03");

		Diseniador daisy = new Diseniador("des01");
		Diseniador minnie = new Diseniador("des02");

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
	}
}

