package practica4_mejiaisrael;

import java.util.List;
import java.util.Collections; //para ordenar con .sort
import java.util.Scanner;//para el ingreso de datos por teclado

public class BusquedaLineal {
    
    public static void hacerBL(List a){
        
        System.out.println("Se Muestra a pantalla la Lista 1 ordenada");
        Collections.sort(a);  
        imprimirLista(a);
        System.out.println("que elemento buscas?");
        Scanner lector=new Scanner(System.in);
        int x =lector.nextInt();
        
        buscarBL(a,x);
        
    }
    
    public static void imprimirLista(List<Integer> listaPrint){
        listaPrint.forEach((var) -> {
            System.out.println(var);
        });
    }
    
    public static void buscarBL(List a, int x){
        int c=0,nel=0,j=0,n= a.size();
        boolean existe=false;
        for (int i=0; i<n;i++){
            j=i;
            if((a.get(j)).equals(x)){
                verdaderoFalso (existe);
                indice (c);
                System.out.println(i);
                c++;
                if(c==1)
                    System.out.println("y aparece solo "+c+" vez en la lista");
                if (c>1)
                    System.out.println("y aparece "+c+" veces en la lista");
            }else{
                 nel++;
            }
        }
        
        if(nel==n){
            System.out.println("El numero no existe en la lista :S");
        }
 
    } 
    
    public static boolean verdaderoFalso (boolean existe){
         System.out.println("Se ecuentra el numero en la lista");
         return existe=true;
     }
    
    public static int indice (int c){
         System.out.println("en la posicion ");
         c++;
         return c;
     }
    /*
    public static int vecesQueAparece (int c, int nel){
            if(c==1)
                System.out.println("y aparece solo "+c+" vez en la lista");
            if (c>1)
                System.out.println("y aparece "+c+"veces en la lista");
            else
                 nel++;
        return c;
        return nel;
    }*/
    
}
    
    
    

