package practica4_mejiaisrael;

import java.util.List;
import java.util.Collections; //para ordenar con .sort
import java.util.Scanner; //ingresar datos por el teclado
import static practica4_mejiaisrael.BusquedaLineal.buscarBL;

public class BusquedaBinaria {
    
    public static void hacerBB(List a){
        System.out.println("Hacer busqueda binariaxd");
        System.out.println("imprimire la lista1");
        imprimirLista(a);
        System.out.println("Ahora los imprimire ordenados");
        Collections.sort(a);  
        imprimirLista(a);
         System.out.println("que elemento buscas?");
        Scanner lector=new Scanner(System.in);
        int x =lector.nextInt();
        
        buscarBB(a,x);
    }
    /*
 a) Un método que devuelva verdadero si la clave se encuentra en la lista y falso en caso contrario.
b) Un método que devuelva el número de veces que la clave se encuentra en la lista*/
     public static void buscarBB (List a, int x){
       int medio=0,izq=0,der=a.size();
        while(izq<=der){
          medio=(der+izq)/2;
          System.out.println(medio);
            if((a.get(medio)).equals(x))
                System.out.println(medio);
            
            //if(lista1.get(1)< x)
            if(a.get(medio) > (a.get(1))) {
                der=medio-1;
            } else {
            }
            if(a.get(medio) < x) 
                izq=medio+1;  
        }  
     }
        
     public static void imprimirLista(List<Integer> listaPrint){
        for(Integer var : listaPrint){
            System.out.println(var);
        }
    }
}
