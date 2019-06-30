
package menuproyecto1;

import java.io.IOException;
import java.util.Scanner;

import static menuproyecto1.MezclaEquilibrada.hacerMezclaE;
import static menuproyecto1.Polifase.hacerPolifase;
import static menuproyecto1.Radix.hacerRadix;



public class MenuProyecto1 {

    public static void main(String[] args)throws IOException {
        
                      
        System.out.println("\n\nEliga el algoritmo de ordenamiento que quiera ejecutar");
        System.out.println("para reacomodar su archivo");
        System.out.println("1) Polifase ");
        System.out.println("2) Mezcla Equilibrada");
        System.out.println("3) Radix ");
        
        Scanner lector=new Scanner(System.in);
        int op =lector.nextInt(); //Se crea el objeto escaner con el cual se va a leer el valor de x en consola
        int o=0;
        switch(op){
            case 1:{
            System.out.println("Elegiste Polifase");
            hacerPolifase(orden(o));
            break;    
            }
            
            case 2:{
            System.out.println("Elegiste Mezcla Equilibrada");
            hacerMezclaE(orden(o));
            break;    
            }
            
            case 3:{
            System.out.println("Elegiste Radix");
            hacerRadix(orden(o));
            break;    
            }   
            
            default:{
            System.out.println("Valor invalido");
            break;    
            }
        }

    }
    
    public static int orden(int o){
        System.out.println("¿Como quieres realizar el ordenamiento?");
        System.out.println("1) Ascendente ");
        System.out.println("2) Descendente");
        Scanner lector=new Scanner(System.in);
        int or =lector.nextInt(); //Se crea el objeto escaner con el cual se va a leer el valor de or en consola
        if (or != 1){
            if(or !=2){
                System.out.println("\t\tOpcion invalida");             
            }
        }
        o=or;
        
        return o;
    }
        
}
    
