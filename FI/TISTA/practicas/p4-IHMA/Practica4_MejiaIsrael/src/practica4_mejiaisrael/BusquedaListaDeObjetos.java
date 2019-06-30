
package practica4_mejiaisrael;

import java.util.Scanner;


/*
a) Agrega una nueva clase al proyecto donde definas los atributos y métodos de un Objeto llamado
“EquipoFutbol” (el diseño es libre pero al menos debe tener 4 atributos)
b) Agrega nuevos métodos en tus clases de búsqueda (binaria y lineal), basados en los métodos anteriores,
con la diferencia de que ahora en lugar de recibir como parámetro “Integer”, reciban los siguientes
parámetros:
1) Nombre del equipo (búsqueda por nombre) binaria true/false
2) Nombre Estado (búsqueda por estado) //lineal
c) Crea en la clase principal, una lista de equipos de Futbol y comprueba el funcionamiento de los
métodos realizados para las búsquedas.
Comprueba el funcionamiento de los métodos nuevos en la clase principal
*/
public class BusquedaListaDeObjetos {
    
    public static void menuEquipos(){
        System.out.println("Este programa puede mostrarte la informacion de distintos equipos de la liga MX");
        System.out.println("Como quieres ver la informacion?");
        System.out.println("1) por Equipo  -> escoge 1");
        System.out.println("2) por estado y sus equipos -> escoge 2");
        
        Scanner lector=new Scanner(System.in);
        int x =lector.nextInt(); //Se crea el objeto escaner con el cual se va a leer el valor de x en consola
        
        switch(x){
            case 1:{
            System.out.println("Elegiste recibir la informacion por Equipos");
            infoEquipos();
            break;    
            }
            
            case 2:{
            System.out.println("Elegiste recibir la informacion por estado y sus equipos");
            infoEstados();
            break;    
            }
            
            default:{
            System.out.println("Valor invalido");
            break;    
            }
        
        
    }
    
}
    
   public static void infoEquipos(){
       
   } 
   
   public static void infoEstados(){
       
   } 
    
}

