 import java.util.Vector;

class VectorTest{
	public static void main(String[] args) {
		String uno = "uno";
		String dos = "dos";
		String tres = "tres";
		String hola = "hola";
		String aux = "";
/*
Se cran las cadenas y se les asignan sus caracteres
*/
		Vector cadenas = new Vector();

		cadenas.addElement(uno);
		cadenas.addElement(tres);

		cadenas.insertElementAt(dos, 1);
		cadenas.insertElementAt(hola, 0);

		//Impresión mediante for utilizando la palabra reseervada instanceof

		for(Object o:cadenas){
			if(o instanceof String){
				aux = (String)o;
				System.out.println(aux);
			}
		}

		System.out.println("\n\n");

		//Métodos para la obtención de elementos

		try{
			System.out.println("Primer elemento:");
			aux = (String)cadenas.firstElement();
			System.out.println(aux);

			System.out.println("Ultimo elemento:");
			aux = (String)cadenas.lastElement();
			System.out.println(aux);

			System.out.println("Elemento en la posicion 2:");
			aux = (String)cadenas.elementAt(2);
			System.out.println(aux);
		}
		catch(ClassCastException ce){
			ce.printStackTrace();
		}
		finally{
			int posicion = cadenas.indexOf(tres);
			System.out.println("El indice del objedo tres es: "+ String.valueOf(posicion));
			cadenas.removeElement(hola);
			if(cadenas.contains(hola)) System.out.println("El elemento esta en el vector");
			else System.out.println("El elemento no se encuentra en el vector");
		}
	}
}