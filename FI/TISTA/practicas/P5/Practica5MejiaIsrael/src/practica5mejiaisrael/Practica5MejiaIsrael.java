
package practica5mejiaisrael;

import java.util.Scanner;
import static practica5mejiaisrael.TablasHash.hacerTablas;
import static practica5mejiaisrael.HashModulo.menuModulo;
//import static menuproyecto1.Radix.hacerRadix;

public class Practica5MejiaIsrael {

    public static void main(String[] args) {
      
        System.out.println("\n\nEliga la opcion qie quieras realizar");
        System.out.println("1) Funcion por Modulo ");
        System.out.println("2) Encadenamiento");
        System.out.println("3) Tablas Hash ");
        
        Scanner lector=new Scanner(System.in);
        int op =lector.nextInt(); //Se crea el objeto escaner con el cual se va a leer el valor de x en consola
        int o=0;
        switch(op){
            case 1:{
            System.out.println("Elegiste Funcion Modulo");
            menuModulo();
            break;    
            }
            
            case 2:{
            System.out.println("Elegiste Encadenamiento");
            //hacerMezclaE();
            break;    
            }
            
            case 3:{
            System.out.println("Elegiste Tablas Hash");
            hacerTablas();
            break;    
            }   
            
            default:{
            System.out.println("Valor invalido");
            break;    
            }
        }
        
        
    }
    
}
