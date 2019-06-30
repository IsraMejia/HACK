
package practica4_mejiaisrael;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;//para el ingreso de datos por teclado
import static practica4_mejiaisrael.BusquedaLineal.hacerBL;
import static practica4_mejiaisrael.BusquedaBinaria.hacerBB;
import static practica4_mejiaisrael.BusquedaListaDeObjetos.menuEquipos;



public class Practica4_MejiaIsrael {
    
    
    public static void main(String[] args) {
        List <Integer> lista1=new LinkedList<>();
        
        lista1.add(1);//(15);
        lista1.add(2);//(7);
        lista1.add(3);//(225);
        lista1.add(4);//(1997);
        lista1.add(5);//(10);
        lista1.add(6);//(20);
        lista1.add(7);//(80);
        
        System.out.println("Estado punto 1");
        imprimirLista(lista1);
        System.out.println("***");
        
        lista1.add(1,8);//(1,300);
        lista1.add(1,9);//(3,500);
        lista1.add(1,10);//(5,700);
        
        System.out.println("Estado punto 3");
        imprimirLista(lista1);
        System.out.println(" *** ");
        
        List<Integer> lista2;
        lista2 = lista1.subList(3,6);
        imprimirLista(lista2);
        System.out.println(" *** ");
        System.out.println("Lista1.equals(lista2)");
        
        System.out.println("---------------------------------");
        System.out.println("\nPor ultimo la lista 1 quedo de la siguiente manera");
        imprimirLista(lista1);
        
        System.out.println("Se agregaran las operaciones necesarias para hacer");
        System.out.println("las actividades del ejercicio 1");
        System.out.println("Se eliminara el elemento de la lista en la posicion 1 ");
        lista1.remove(1);         // <- eliminar especificando la posicion
        imprimirLista(lista1);
        System.out.println("\n\nSe agregara de nuevo:");
        lista1.add(1,2);
        imprimirLista(lista1);
        System.out.println("\n\npara ver si esta vacia");
           if ( lista1.size() == 0 )
               System.out.println("la lista esta vacia");
           else
               System.out.println("La lista si contiene elementos");
           
        System.out.println("\n\npara saber si el elemento esta en la lista");
        System.out.println("en este caso se buscara al elemento 91");
        if (lista1.contains(9))
            System.out.println("El elemento 9 esta en la lista");
        
        
        
        desplegarMenu(lista1);
        
    }
    
    public static void imprimirLista(List<Integer> listaPrint){
        for(Integer var : listaPrint){
            System.out.println(var);
        }
    }

    private static void desplegarMenu(List a) {        
        System.out.println("\n\n\tA continuacion Se desplegaran las opciones");
        System.out.println("1) para realizar la busqueda Lineal escoge 1");
        System.out.println("2) para realizar la busqueda binaria escoge 2");
        
        Scanner lector=new Scanner(System.in);
        int x =lector.nextInt();
        //Se crea el objeto escaner con el cual se va a leer el valor de x en consola
        switch(x){
            case 1:{
            System.out.println("Elegiste Busqueda Lineal");
            hacerBL(a);
            break;    
            }
            
            case 2:{
            System.out.println("Elegiste Busqueda Binaria");
            hacerBB(a);
            break;    
            }
            
            default:{
            System.out.println("Valor invalido");
            break;    
            }
        }
        
        
        System.out.println("\n\n\tA continuacion se hara el ejercicio 4 ");
        menuEquipos();
        
    }
    
    
}
