/**
<h1>¡La Receta!</h1>
<p>
La Receta es una aplicación destinada a cocineros de cualquier nivel que día tras
día se enfrentan a la engorrosa tarea de buscar una deliciosa receta para preparar.
<p>
La Receta permite a los cocineros buscar recetas de la manera tradicional, a la vez
que incorpora un método de búsqueda innovador: Buscar recetas que se ajusten a un
listado de ingredientes ingresados por el cocinero.
<p>
¡A COCINAR!

@author	Gutiérrez Espinosa José David
@author	Macías Eljure Rodrigo
@author	Mejía Alba Israel Hipólito
@author	autor4
*/

import java.io.*;
import java.util.*;
import java.lang.*;
import java.awt.*;
import java.net.*;

/**
<p>
Clase empleada para modelar los objetos de tipo Receta. Implementa dos métodos constructores.
*/
class Receta {
	String nombre;
	String[] ingredientes;
	float[] cantidades;
	String[] unidades;
	float porciones;
	String descripcion;
	String videoURL;
	
	/**
	<p>
	Método constructor 1: Instancia una receta creada en tiempo de ejecución por el usuario.
	*/
	public Receta(String nombre, String[] ingredientes, float[] cantidades, String[] unidades, float porciones, String descripcion, String videoURL) {
		this.nombre = nombre;
		this.ingredientes = ingredientes;
		this.cantidades = cantidades;
		this.unidades = unidades;
		this.porciones = porciones;
		this.descripcion = descripcion;
		this.videoURL = videoURL;
	}
	
	/**
	<p>
	Método constructor 2: Instancia una receta que está almacenada en la base de datos de recetas.
	*/
	public Receta(String linea) {
		String[] separa = linea.split(",");
		
		int numIngredientes = (separa.length - 4)/3;
		ingredientes = new String[numIngredientes];
		cantidades = new float[numIngredientes];
		unidades = new String[numIngredientes];
		
		nombre = separa[0];
		
		int j = 0;
		for (int i = 1; i < (1+numIngredientes); i++) {
			ingredientes[j] = separa[i];
			j++;
		}
		
		j = 0;
		for (int i = (1+numIngredientes); i < (1+2*numIngredientes); i++) {
			cantidades[j] = Float.parseFloat(separa[i]);
			j++;
		}
		
		j = 0;
		for (int i = (1+2*numIngredientes); i < (1+3*numIngredientes); i++) {
			unidades[j] = separa[i];
			j++;
		}
		
		porciones = Float.parseFloat(separa[separa.length - 3]);
		descripcion = separa[separa.length - 2];
		videoURL = separa[separa.length - 1];
	}
}

/**
<p>
Clase para modelar los usuarios de tipo Administrador. Los usuarios de tipo Administrador
pueden crear, editar y borrar recetas.
*/
class Administrador {
	public static Scanner entrada = new Scanner(System.in);
	
	String nombreAdmin;
	
	public Administrador(String nombreAdmin) {
		this.nombreAdmin = nombreAdmin;
	}
	
	/**
	<p>
	El método "crearReceta" le permite a los administradores crear, paso a paso, una receta
	en tiempo de ejecución.
	*/
	public static void crearReceta() {
		try {
			System.out.println("\nIngrese el nombre de la receta:");
			String nombre = entrada.nextLine();
			
			System.out.println("\nIngrese el número de ingredientes de la receta:");
			int numIngredientes = Integer.parseInt(entrada.nextLine());
			
			String[] ingredientes = new String[numIngredientes];
			float[] cantidades = new float[numIngredientes];
			String[] unidades = new String[numIngredientes];
			
			System.out.println("\nRecuerde que los primeros 4 ingredientes serán tomados como los ingredientes principales de la receta.");
			
			for(int i = 0; i < numIngredientes; i++) {
				System.out.println("\nIngrese el nombre del ingrediente " + Integer.toString(i+1));
				ingredientes[i] = entrada.nextLine();
				System.out.println("Ingrese la cantidad del ingrediente " + Integer.toString(i+1));
				cantidades[i] = Float.parseFloat(entrada.nextLine());
				System.out.println("Ingrese la unidad del ingrediente " + Integer.toString(i+1));
				unidades[i] = entrada.nextLine();
			}
			
			System.out.println("\nIngrese las porciones de la receta:");
			float porciones = Float.parseFloat(entrada.nextLine());
			
			System.out.println("\nIngrese la descripción de la receta:");
			String descripcion = entrada.nextLine();
			
			System.out.println("\nIngrese la URL del video de la receta:");
			String videoURL = entrada.nextLine();
			
			Receta receta = new Receta(nombre, ingredientes, cantidades, unidades, porciones, descripcion, videoURL);
			LaReceta.recetario.add(receta);
			
			System.out.println("\nLa receta '" + nombre + "' se ha creado exitosamente.");
		}
		
		catch(NumberFormatException excepcion) {
			System.out.println("\nValor inválido. Por favor vuelva a intentarlo.");
		}
	}
	
	/**
	<p>
	El método "editarReceta" permite editar cualquiera de los atributos de una receta
	en particular: Nombre, Ingredientes, Cantidades, Unidades, Porciones, Descripción
	y URL del Video.
	*/
	public static void editarReceta() {
		try {
			System.out.println("\nRecetas disponibles para editar:");
			
			int numRecetas = LaReceta.recetario.size();
			for (int i = 0; i < numRecetas; i++) {
				System.out.println(LaReceta.recetario.get(i).nombre);
			}
			
			System.out.println("\nIngrese el nombre de la receta que desea editar:");
			String recetaEditar = entrada.nextLine();
			
			boolean encuentraReceta = false;
			for (int i = 0; i < numRecetas; i++) {
				if (recetaEditar.equalsIgnoreCase(LaReceta.recetario.get(i).nombre)) {
					Receta receta = LaReceta.recetario.get(i);
					int indice = i;
					encuentraReceta = true;
					modificadorReceta(receta, indice);
					break;
				}
			}
			
			if (encuentraReceta == false) {
				System.out.println("\nEl texto ingresado no coincide con el nombre de ninguna receta. Por favor vuelva a intentarlo.");
			} 
		}
		
		catch(NumberFormatException excepcion) {
			System.out.println("\nValor inválido. Por favor vuelva a intentarlo.");
		}
	}
	
	/**
	<p>
	El método "modificadorReceta" es un método auxiliar para editar una receta.
	*/
	public static void modificadorReceta(Receta receta, int indice) {
		int numIngredientes;
		String ingredienteEditar;
		boolean encuentraIngrediente = false;
		
		try {
			System.out.println("\n¿Qué sección de la receta desea editar?");
			System.out.println("N = Nombre");
			System.out.println("I = Ingredientes");
			System.out.println("P = Porciones");
			System.out.println("D = Descripción");
			System.out.println("V = URL del Video");
			
			String opcionEdicion = entrada.nextLine().toUpperCase();
			switch (opcionEdicion) {
				case "N":
					System.out.println("\nEl nombre actual de la receta es: " + receta.nombre);
					System.out.println("Ingrese el nuevo nombre de la receta:");
					receta.nombre = entrada.nextLine();
					LaReceta.recetario.removeElementAt(indice);
					LaReceta.recetario.add(indice, receta);
					System.out.println("\nModificación exitosa.");

				case "I":
					System.out.println("\nIngredientes de la receta:");
					
					numIngredientes = receta.ingredientes.length;
					for (int i = 0; i < numIngredientes; i++) {
						System.out.println(receta.ingredientes[i] + ": " + String.format("%.0f", receta.cantidades[i]) + " " + receta.unidades[i]);
					}
					
					System.out.println("\nIngrese el nombre del ingrediente que desea editar:");
					ingredienteEditar = entrada.nextLine();
					
					for (int i = 0; i < numIngredientes; i++) {
						if (ingredienteEditar.equalsIgnoreCase(receta.ingredientes[i])) {
							int indiceIngrediente = i;
							encuentraIngrediente = true;
							
							System.out.println("\nIngrese el nuevo nombre del ingrediente:");
							receta.ingredientes[indiceIngrediente] = entrada.nextLine();
							
							System.out.println("\nIngrese la nueva cantidad del ingrediente:");
							receta.cantidades[indiceIngrediente] = Float.parseFloat(entrada.nextLine());
							
							System.out.println("\nIngrese la nueva unidad del ingrediente:");
							receta.unidades[indiceIngrediente] = entrada.nextLine();

							LaReceta.recetario.removeElementAt(indice);
							LaReceta.recetario.add(indice, receta);
							
							System.out.println("\nModificación exitosa.");
							break;
						}
					}
					
					if (encuentraIngrediente == false) {
						System.out.println("\nEl texto ingresado no coincide con el nombre de ningún ingrediente. Por favor vuelva a intentarlo.");
					}

				case "P":
					System.out.println("\nLas porciones actuales de la receta son: " + String.format("%.0f", receta.porciones));
					System.out.println("Ingrese las nuevas porciones de la receta:");
					receta.porciones = Float.parseFloat(entrada.nextLine());
					LaReceta.recetario.removeElementAt(indice);
					LaReceta.recetario.add(indice, receta);
					System.out.println("\nModificación exitosa.");

				case "D":
					System.out.println("\nLa descripción actual de la receta es: " + receta.descripcion);
					System.out.println("Ingrese la nueva descripcion de la receta:");
					receta.descripcion = entrada.nextLine();
					LaReceta.recetario.removeElementAt(indice);
					LaReceta.recetario.add(indice, receta);
					System.out.println("\nModificación exitosa.");

				case "V":
					System.out.println("\nLa URL actual del Video de la receta es: " + receta.videoURL);
					System.out.println("Ingrese la nueva URL del Video de la receta:");
					receta.videoURL = entrada.nextLine();
					LaReceta.recetario.removeElementAt(indice);
					LaReceta.recetario.add(indice, receta);
					System.out.println("\nModificación exitosa.");

				default:
					System.out.println("\nOpción inválida. Por favor vuelva a intentarlo.");
			}
		}
		
		catch(NumberFormatException excepcion) {
			System.out.println("\nValor inválido. Por favor vuelva a intentarlo.");
		}
	}
	
	/**
	<p>
	El método "borrarReceta" es utilizado para eliminar una receta existente en la base
	de datos de recetas.
	*/
	public static void borrarReceta() {
		try {
			System.out.println("\nRecetas disponibles para borrar:");
			
			int numRecetas = LaReceta.recetario.size();
			for (int i = 0; i < numRecetas; i++) {
				System.out.println(LaReceta.recetario.get(i).nombre);
			}
			
			System.out.println("\nIngrese el nombre de la receta que desea borrar:");
			String recetaBorrar = entrada.nextLine();
			
			boolean encuentraReceta = false;
			for (int i = 0; i < numRecetas; i++) {
				if (recetaBorrar.equalsIgnoreCase(LaReceta.recetario.get(i).nombre)) {
					Receta receta = LaReceta.recetario.get(i);
					encuentraReceta = true;
					LaReceta.recetario.remove(receta);
					System.out.println("\nLa receta '" + receta.nombre + "' se ha eliminado exitosamente.");
					break;
				}
			}
			
			if (encuentraReceta == false) {
				System.out.println("\nEl texto ingresado no coincide con el nombre de ninguna receta. Por favor vuelva a intentarlo.");
			}
		}
		
		catch(NumberFormatException excepcion) {
			System.out.println("\nValor inválido. Por favor vuelva a intentarlo.");
		}
	}
}

/**
<p>
Clase para modelar los usuarios de tipo Cocinero. Los usuarios de tipo Cocinero pueden
buscar recetas por cualquiera de los dos métodos: Búsqueda tradicional y Búsqueda por Ingredientes.
*/
class Cocinero {	
	public static Scanner entrada = new Scanner(System.in);
	
	String nombreCocinero;
	
	public Cocinero(String nombreCocinero) {
		this.nombreCocinero = nombreCocinero;
	}
	
	/**
	<p>
	Para emplear el método "buscarPorIngredientes", el Cocinero debe ingresar un listado
	de ingredientes que se compara con los ingredientes principales de cada receta (los
	cuatro primeros ingredientes de cada receta son considerados sus principales).
	*/
	public static void buscarPorIngredientes() {
		Vector <String> ingredientesCocinero = new Vector<String>();
		boolean terminado = false;
		int contador;
		Vector <Receta> recetarioCocinero = new Vector<Receta>();
		
		try {
			System.out.println("\nIngrese el nombre de sus ingredientes uno por uno.");
			System.out.println("Cuando haya terminado, ingrese la palabra 'Terminar'.");
			do {
				String ingrediente = entrada.nextLine();
				if (ingrediente.equalsIgnoreCase("Terminar")) {
					terminado = true;
				}
				else {
					ingredientesCocinero.add(ingrediente);
				}
			}while(terminado == false);
			
			int numRecetas = LaReceta.recetario.size();
			for (int i = 0; i < numRecetas; i++) {
				contador = 0;
				for (int j = 0; j < 4; j++) {
					String ingredienteReceta = LaReceta.recetario.get(i).ingredientes[j];
					int indice = ingredientesCocinero.indexOf(ingredienteReceta);
					if (indice != -1) {
						contador += 1;
					}
				}
				if (contador == 4) {
					recetarioCocinero.add(LaReceta.recetario.get(i));
				}
			}
			
			if (recetarioCocinero.size() == 0) {
				System.out.println("\nLo sentimos, ninguna de nuestras recetas se ajusta a sus ingredientes.");
			}
			else {
				buscarRecetas(recetarioCocinero);
			}
		}
		
		catch(NumberFormatException excepcion) {
			System.out.println("\nValor inválido. Por favor vuelva a intentarlo.");
		}
	}
	
	/**
	<p>
	El método "buscarRecetas" despliega un listado de todas las recetas existentes en
	la base de datos de recetas.
	*/
	public static void buscarRecetas(Vector<Receta> recetario) {
		try {
			System.out.println("\nRecetas disponibles para cocinar:");
			
			int numRecetas = recetario.size();
			for (int i = 0; i < numRecetas; i++) {
				System.out.println(recetario.get(i).nombre);
			}
			
			System.out.println("\nIngrese el nombre de la receta que desea cocinar:");
			String recetLaReceta = entrada.nextLine();
			
			boolean encuentraReceta = false;
			for (int i = 0; i < numRecetas; i++) {
				if (recetLaReceta.equalsIgnoreCase(recetario.get(i).nombre)) {
					Receta receta = recetario.get(i);
					encuentraReceta = true;
					System.out.println("\nIngrese el número de porciones que desea cocinar:");
					float nuevasPorciones = Float.parseFloat(entrada.nextLine());
					muestraReceta(receta, nuevasPorciones);
					break;
				}
			}
			
			if (encuentraReceta == false) {
				System.out.println("\nEl texto ingresado no coincide con el nombre de ninguna receta. Por favor vuelva a intentarlo.");
			}	
		}
		
		catch(NumberFormatException excepcion) {
			System.out.println("\nValor inválido. Por favor vuelva a intentarlo.");
		}
	}
	
	/**
	<p>
	El método "muestraReceta" muestra toda la información de la receta seleccionada por
	el Cocinero mediante cualquiera de los dos métodos de búsqueda.
	*/
	public static void muestraReceta(Receta receta, float nuevasPorciones) {
		System.out.println(".\n.\n.\nNombre: " + receta.nombre);
		
		float relacionPorciones = (nuevasPorciones/receta.porciones);
		int numIngredientes = receta.ingredientes.length;
		System.out.println("\nLista de ingredientes:");
		for (int i = 0; i < numIngredientes; i++) {
			System.out.println(receta.ingredientes[i] + ": " + String.format("%.0f", (relacionPorciones*receta.cantidades[i])) + " " + receta.unidades[i]);
		}
		
		System.out.println("\nPorciones: " + String.format("%.0f", nuevasPorciones));
		
		System.out.println("\nDescripción: " + receta.descripcion);
		
		System.out.println("\n¿Desea ver el Video de la receta?");
		System.out.println("S = Sí");
		System.out.println("Cualquier otra letra = No");
		
		String opcionVideo = entrada.nextLine();
		if (opcionVideo.equalsIgnoreCase("S")) {
			try {
				System.out.println("\n¡A COCINAR!\n.\n.\n.");
				
				Desktop escritorio = Desktop.getDesktop();
				escritorio.browse(new URI(receta.videoURL));
			}
			
			catch(Exception excepcion) {
				System.out.println("Lo sentimos, ha ocurrido un error y el Video no se puede mostrar.");
				
				System.out.println("\n¡A COCINAR!\n.\n.\n.");
			}
		}
		else {
			System.out.println("\n¡A COCINAR!\n.\n.\n.");
		}
	}
}

/**
<p>
La clase ExcepcionUsuario sirve para crear una excepción cuando no se selecciona
un tipo de usuario válido.
*/
class ExcepcionUsuario extends Exception {
	public ExcepcionUsuario(String mensaje) {
		super(mensaje);
	}
}

/**
<p>
La clase LaReceta es la clase principal del programa, en esta se encuentra el método "main".
<p>
En esta clase también se crean los arreglos para manejar toda la información de las bases de
datos empleadas en el programa: Recetario, Administradores, Cocineros.
<p>
Esta clase cuenta con varios métodos que permiten simular una aplicación móvil a través
de diferentes menús de interacción.
*/
public class LaReceta {
	public static Scanner entrada = new Scanner(System.in);
	
	public static Vector <Receta> recetario = new Vector<Receta>();
	
	public static Vector <String> administradores = new Vector<String>();
	public static Vector <String> contrasenasAdmins = new Vector<String>();
	public static Vector <String> nombresAdmins = new Vector<String>();
	
	public static Vector <String> cocineros = new Vector<String>();
	public static Vector <String> contrasenasCocineros = new Vector<String>();
	public static Vector <String> nombresCocineros = new Vector<String>();
	
	public static void main(String[] args) {
		try {
			Vector <String> recetas = new Vector<String>();
			Scanner archivoRecetario = new Scanner(new File("Recetario.txt"));
			while(archivoRecetario.hasNextLine()) {
				recetas.add(archivoRecetario.nextLine());
			}
			for (int i = 0; i < recetas.size(); i++) {
				LaReceta.recetario.add(new Receta(recetas.get(i)));
			}
			
			Vector <String> lineas = new Vector<String>();
			Scanner archivoAdministradores = new Scanner(new File("Administradores.txt"));
			while(archivoAdministradores.hasNextLine()) {
				lineas.add(archivoAdministradores.nextLine());
			}
			for (int i = 0; i < lineas.size(); i++) {
				String[] separa = lineas.get(i).split(",");
				LaReceta.administradores.add(separa[0]);
				LaReceta.contrasenasAdmins.add(separa[1]);
				LaReceta.nombresAdmins.add(separa[2]);
			}
			
			Vector <String> lineas2 = new Vector<String>();
			Scanner archivoCocineros = new Scanner(new File("Cocineros.txt"));
			while(archivoCocineros.hasNextLine()) {
				lineas2.add(archivoCocineros.nextLine());
			}
			for (int i = 0; i < lineas2.size(); i++) {
				String[] separa = lineas2.get(i).split(",");
				LaReceta.cocineros.add(separa[0]);
				LaReceta.contrasenasCocineros.add(separa[1]);
				LaReceta.nombresCocineros.add(separa[2]);
			}
			
			inicio();
		}
		
		catch(FileNotFoundException excepcion) {
			System.out.println("\nNo se encuentra(n) alguno(s) de los archivos necesarios. Por favor verifique.");
			System.exit(0);
		}
	}
	
	/**
	<p>
	El método "inicio" es donde comienza la interacción con el usuario, y permite seleccionar
	si la aplicación va a ser utilizada por un usuario de tipo Administrador o Cocinero.
	<p>
	Este método lanza una excepción de tipo ExcepcionUsuario si no se selecciona un usuario válido.
	*/
	public static void inicio() {
		System.out.println("\n¿Qué tipo de usuario desea utilizar?");
		System.out.println("A = Administrador");
		System.out.println("C = Cocinero");
		
		try {
			String tipoUsuario = entrada.nextLine().toUpperCase();
			
			if (tipoUsuario.equals("A")) {
				inicioAdministrador();
			}
			else if (tipoUsuario.equals("C")) {
				inicioCocinero();
			}
			else {
				throw new ExcepcionUsuario("\nNo ha ingresado un usuario válido.");
			}
		}
		
		catch (ExcepcionUsuario excepcion) {
			System.out.println(excepcion.getMessage());
			System.out.println("\n¿Qué desea hacer?");
			System.out.println("V = Volver a intentarlo");
			System.out.println("Cualquier otra letra = Salir de la aplicación");
			
			String opcionUsuario = entrada.nextLine().toUpperCase();
			switch (opcionUsuario) {
				case "V":
					inicio();
				default:
					guardarCambios(LaReceta.recetario, LaReceta.administradores, LaReceta.contrasenasAdmins, LaReceta.nombresAdmins, LaReceta.cocineros, LaReceta.contrasenasCocineros, LaReceta.nombresCocineros);
					System.exit(0);
			}
		}
	}
	
	/**
	<p>
	Si el tipo de usuario seleccionado es Administrador, el método "inicioAdministrador" se ejecuta
	y se puede escoger entre usar un usuario existente o crear uno nuevo.
	<p>
	Para crear un nuevo usuario de tipo Administrador debe conocerse la clave del proyecto, de lo
	contrario cualquiera podría crear un usuario de tipo Administrador y tener el poder de modificar
	la información sensible almacenada en las bases de datos de la aplicación.
	<p>
	Una vez se valida la información del usuario de tipo Administrador, se crea el Objeto "admin",
	es decir, se instancia la clase Administrador.
	*/
	public static void inicioAdministrador() {
		String claveProyecto = "poo.2019-2";
		
		System.out.println("\n¿Qué desea hacer?");
		System.out.println("I = Iniciar sesión con una cuenta de Administrador registrada");
		System.out.println("C = Crear una nueva cuenta de Administrador");
		System.out.println("Cualquier otra letra = Salir");
		
		String opcionInicioAdmin = entrada.nextLine().toUpperCase();
		switch (opcionInicioAdmin) {
			case "I":
				System.out.println("\nIngrese su usuario:");
				String usuarioAdmin = entrada.nextLine();
				int indiceUsuario = LaReceta.administradores.indexOf(usuarioAdmin);
				if (indiceUsuario != -1) {
					System.out.println("\nIngrese su contraseña:");
					String contrasenaAdmin = entrada.nextLine();
					if (contrasenaAdmin.equals(LaReceta.contrasenasAdmins.get(indiceUsuario))) {
						String nombreAdmin = LaReceta.nombresAdmins.get(indiceUsuario);
						Administrador admin = new Administrador(nombreAdmin);
						administradorOK(admin);
					}
					else {
						System.out.println("\nContraseña incorrecta. Por favor verifique.");
						inicioAdministrador();
					}
				}
				else {
					System.out.println("\nEl usuario ingresado no existe. Por favor verifique.");
					inicioAdministrador();
				}

			case "C":
				System.out.println("\nIngrese la clave del proyecto:");
				String claveIngresada = entrada.nextLine();
				if (claveIngresada.equals(claveProyecto)) {
					System.out.println("\nIngrese su usuario:");
					String nuevoUsuarioAdmin = entrada.nextLine();
					int indiceNuevoAdmin = LaReceta.administradores.indexOf(nuevoUsuarioAdmin);
					if (indiceNuevoAdmin == -1) {
						System.out.println("\nIngrese su contraseña:");
						String contrasena1 = entrada.nextLine();
						System.out.println("\nVerifique su contraseña:");
						String contrasena2 = entrada.nextLine();
						if (contrasena1.equals(contrasena2)) {
							System.out.println("\nIngrese su nombre:");
							String nombreNuevoAdmin = entrada.nextLine();
							
							LaReceta.administradores.add(nuevoUsuarioAdmin);
							LaReceta.contrasenasAdmins.add(contrasena1);
							LaReceta.nombresAdmins.add(nombreNuevoAdmin);
							
							Administrador admin = new Administrador(nombreNuevoAdmin);
							administradorOK(admin);
						}
						else {
							System.out.println("\nLas contraseñas ingresadas no coinciden. Por favor verifique.");
							inicioAdministrador();
						}
					}
					else {
						System.out.println("\nEl usuario ingresado ya existe. Por favor vuelva a intentarlo.");
						inicioAdministrador();
					}
				}
				else {
					System.out.println("\nLa clave del proyecto ingresada es incorrecta. Por favor vuelva a intentarlo.");
					inicioAdministrador();
				}

			default:
				inicio();
		}
	}
	
	/**
	<p>
	El método "administradorOK" permite seleccionar los métodos que pueden ejecutar
	los administradores: Crear, Editar y Borrar recetas.
	*/
	public static void administradorOK(Administrador admin) {
		System.out.println("\nBienvenido " + admin.nombreAdmin + ". ¿Qué desea hacer?");
		System.out.println("C = Crear una nueva receta");
		System.out.println("E = Editar una receta existente");
		System.out.println("B = Borrar una receta existente");
		System.out.println("Cualquier otra letra = Salir");
		
		String opcionReceta = entrada.nextLine().toUpperCase();
		switch (opcionReceta) {
			case "C":
				admin.crearReceta();
				administradorOK(admin);
			case "E":
				admin.editarReceta();
				administradorOK(admin);
			case "B":
				admin.borrarReceta();
				administradorOK(admin);
			default:
				inicioAdministrador();
		}
	}
	
	/**
	<p>
	Si el tipo de usuario seleccionado es Cocinero, el método "inicioCocinero" se ejecuta
	y se puede escoger entre usar un usuario existente o crear uno nuevo.
	<p>
	En este caso, no es necesario conocer una clave del proyecto, pues los usuarios de tipo
	Cocinero no tienen habilitados los métodos para modificar la información sensible de la aplicación.
	<p>
	Una vez se valida la información del usuario de tipo Cocinero, se crea el Objeto "cocinero",
	es decir, se instancia la clase Cocinero.
	*/
	public static void inicioCocinero() {
		System.out.println("\n¿Qué desea hacer?");
		System.out.println("I = Iniciar sesión con una cuenta de Cocinero registrada");
		System.out.println("C = Crear una nueva cuenta de Cocinero");
		System.out.println("Cualquier otra letra = Salir");
		
		String opcionInicioCocinero = entrada.nextLine().toUpperCase();
		switch (opcionInicioCocinero) {
			case "I":
				System.out.println("\nIngrese su usuario:");
				String usuarioCocinero = entrada.nextLine();
				int indiceUsuario = LaReceta.cocineros.indexOf(usuarioCocinero);
				if (indiceUsuario != -1) {
					System.out.println("\nIngrese su contraseña:");
					String contrasenaCocinero = entrada.nextLine();
					if (contrasenaCocinero.equals(LaReceta.contrasenasCocineros.get(indiceUsuario))) {
						String nombreCocinero = LaReceta.nombresCocineros.get(indiceUsuario);
						Cocinero cocinero = new Cocinero(nombreCocinero);
						cocineroOK(cocinero);
					}
					else {
						System.out.println("\nContraseña incorrecta. Por favor verifique.");
						inicioCocinero();
					}
				}
				else {
					System.out.println("\nEl usuario ingresado no existe. Por favor verifique.");
					inicioCocinero();
				}

			case "C":
				System.out.println("\nIngrese su usuario:");
				String nuevoUsuarioCocinero = entrada.nextLine();
				int indiceNuevoCocinero = LaReceta.cocineros.indexOf(nuevoUsuarioCocinero);
				if (indiceNuevoCocinero == -1) {
					System.out.println("\nIngrese su contraseña:");
					String contrasena1 = entrada.nextLine();
					System.out.println("\nVerifique su contraseña:");
					String contrasena2 = entrada.nextLine();
					if (contrasena1.equals(contrasena2)) {
						System.out.println("\nIngrese su nombre:");
						String nombreNuevoCocinero = entrada.nextLine();
						
						LaReceta.cocineros.add(nuevoUsuarioCocinero);
						LaReceta.contrasenasCocineros.add(contrasena1);
						LaReceta.nombresCocineros.add(nombreNuevoCocinero);
						
						Cocinero cocinero = new Cocinero(nombreNuevoCocinero);
						cocineroOK(cocinero);
					}
					else {
						System.out.println("\nLas contraseñas ingresadas no coinciden. Por favor verifique.");
						inicioCocinero();
					}
				}
				else {
					System.out.println("\nEl usuario ingresado ya existe. Por favor vuelva a intentarlo.");
					inicioCocinero();
				}

			default:
				inicio();
		}
	}
	
	/**
	<p>
	El método "cocineroOK" permite seleccionar los métodos que pueden ejecutar los
	cocineros: Búsqueda por Ingredientes y Búsqueda tradicional.
	*/
	public static void cocineroOK(Cocinero cocinero) {
		System.out.println("\nBienvenido " + cocinero.nombreCocinero + ". ¿Qué desea hacer?");
		System.out.println("I = Buscar por Ingredientes");
		System.out.println("R = Buscar Recetas");
		System.out.println("Cualquier otra letra = Salir");
		
		String opcionCocinero = entrada.nextLine().toUpperCase();
		switch (opcionCocinero) {
			case "I":
				cocinero.buscarPorIngredientes();
				cocineroOK(cocinero);
			case "R":
				cocinero.buscarRecetas(LaReceta.recetario);
				cocineroOK(cocinero);
			default:
				inicioCocinero();
		}
	}

	/**
	<p>
	Como la aplicación guarda todos los cambios de información en la memoria durante el tiempo de ejecución,
	es necesario que antes de cerrar la aplicación, todos los cambios en la información sean escritos en sus
	respectivas bases de datos. Lo anterior se logra al ejecutarse el método "guardarCambios".
	*/
	public static void guardarCambios(Vector<Receta> recetario, Vector<String> administradores, Vector<String> contrasenasAdmins, Vector<String> nombresAdmins, Vector<String> cocineros, Vector<String> contrasenasCocineros, Vector<String> nombresCocineros) {
		try {
			BufferedWriter escritor = new BufferedWriter(new FileWriter("Recetario.txt"));
			
			int numRecetas = recetario.size();
			
			for (int i = 0; i < numRecetas; i++) {
				String palabra = "";
				
				Receta receta = recetario.get(i);
				
				palabra = palabra + receta.nombre + ",";
				
				int numIngredientes = receta.ingredientes.length;
				
				for (int j = 0; j < numIngredientes; j++) {
					palabra = palabra + receta.ingredientes[j] + ",";
				}
				
				for (int j = 0; j < numIngredientes; j++) {
					palabra = palabra + String.format("%.0f", receta.cantidades[j]) + ",";
				}
				
				for (int j = 0; j < numIngredientes; j++) {
					palabra = palabra + receta.unidades[j] + ",";
				}
				
				palabra = palabra + String.format("%.0f", receta.porciones) + ",";
				
				palabra = palabra + receta.descripcion + ",";
				
				palabra = palabra + receta.videoURL + "\n";
				
				escritor.write(palabra);
			}
			escritor.close();
			
			
			
			BufferedWriter escritor2 = new BufferedWriter(new FileWriter("Administradores.txt"));
			
			int numAdmins = administradores.size();
			for (int i = 0; i < numAdmins; i++) {
				String palabra = administradores.get(i) + "," + contrasenasAdmins.get(i) + "," + nombresAdmins.get(i) + "\n";
				escritor2.write(palabra);
			}
			escritor2.close();
			
			
			
			BufferedWriter escritor3 = new BufferedWriter(new FileWriter("Cocineros.txt"));
			
			int numCocineros = cocineros.size();
			for (int i = 0; i < numCocineros; i++) {
				String palabra = cocineros.get(i) + "," + contrasenasCocineros.get(i) + "," + nombresCocineros.get(i) + "\n";
				escritor3.write(palabra);
			}
			escritor3.close();
			
			
			
			System.out.println("\nLos cambios en el recetario se han guardado exitosamente. Hasta la próxima.");
		}
		
		catch(IOException excepcion) {
			System.out.println("\nError al guardar los cambios en el recetario. Hasta la próxima.");
		}
	}
}