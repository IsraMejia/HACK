
package practica5mejiaisrael;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;



public class HashModulo {
    
  public static void menuModulo(){
      
    boolean opera=true;
    List <Integer> lista=new LinkedList<>();
    
    //lista.ensureCapacity(20); //para definir la lista en 20 elementos
    //en teoria deberia funcionar la linea anterior, pero nada
   
    lista.add(17);//agreda el elemento en (indice, elemento) ->posicion 1 xD
    
    
    while (opera){
        System.out.println("\n\nEliga la opcion qie quieras realizar");
        System.out.println("1) AgregarElementos ");
        System.out.println("2) ImprimirLista");
        System.out.println("3) BuscarElementos ");
        System.out.println("\t Use Cualquier otro numero para salir ");
        
        Scanner lector=new Scanner(System.in);
        int op =lector.nextInt(); //Se crea el objeto escaner con el cual se va a leer el valor de x en consola
      
        switch(op){
            case 1:{
            System.out.println("\n\n\n");
            System.out.println("Elegiste AgregarElementos ");
            //AgregarElementos(Lista);
            //la funcion se basaria en el metodo lista.add(n);
            /*sin embargo al indice que se le pasa como parametro se otendria sacando el modulo 17
            n=numeroInicial%17
            */
            break;    
            }
            
            case 2:{
            System.out.println("\n\n\n");
            System.out.println("Elegiste ImprimirLista");
            imprimirLista(lista);
            break;    
            }
            
            case 3:{
            System.out.println("\n\n\n");
            System.out.println("Elegiste BuscarElementos");
            //BuscarElementos(lista);
            //realizaria la operacion inversa de modulo y obtendria el valor buscado con
            //lista.get(numeroInicial);
            break;    
            }
            
           
            default:{
            System.out.println("Valor invalido o decidio salir");
            opera=false;
            break;    
            }
        }
        
    }
    
  }
   public static void imprimirLista(List<Integer> listaPrint){
        for(Integer var : listaPrint){
            System.out.println(var);
        }
    }    
    
}
