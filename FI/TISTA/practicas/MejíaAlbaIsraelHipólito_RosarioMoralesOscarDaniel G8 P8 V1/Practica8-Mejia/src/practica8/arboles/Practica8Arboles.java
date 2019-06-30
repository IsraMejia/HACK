
package practica8.arboles;

import java.util.LinkedList;
import java.util.Scanner;
import practica8.arboles.ArbolBin;

public class Practica8Arboles {

    public static void main(String[] args) {

        System.out.println("\tBienvenido a la practica 8 de Arboles, elaborada por:");
        System.out.println("");
        System.out.println("Mejia Alba Israel Hipolito");
        System.out.println("\n\nEliga el tipo de Arbol sobre el que quiera trabajar");
        System.out.println("\t1) Arbol Binario ");
        System.out.println("\t2) Arbol Binario de Busqueda");
        
        System.out.println("Las opcion disponible  por el momento solo es arbol binario");
        Scanner lector=new Scanner(System.in);
        int op =lector.nextInt(); 
        switch(op){
            case 1:{
                ArbolBin arbol = new ArbolBin();
                menuArbolesBinarios(arbol);
                
                break;
            }
            case 2:{
                System.out.println("No diponible por el momento");
                menuArbolesBinariosBusqueda();
                
                break;
            }
            default:{
                System.out.println("Opcion Invalida xd");
                break;
            }
        }//switch
        
    }//main
    public static void menuArbolesBinarios(ArbolBin arbol){
        System.out.println("\n\n\t bienvenido al menu de Arboles Binarios");
        System.out.println("Seleccione la operacion que quiera realizar");
        System.out.println("1) Agregar ");
        System.out.println("2) Eliminar");
        System.out.println("3) BFS ");
        System.out.println("4) Notacion Prefija");
        System.out.println("5) Notacion Infija");
        System.out.println("6) Notacion Posfija");
        System.out.println("7) Busqueda");
        System.out.println("Las opcion Disponible  por el momento es agegar, BFS y Buscar");
        System.out.println("para estos dos ultimos es Indispensable realizar la operacion agregar antes");
        Scanner lector=new Scanner(System.in);
        int op =lector.nextInt();
        switch(op){
            case 1:{
                System.out.println("Agrega los nodos de tu arbol");
                Agregar_Bin(arbol);
                break;
            }
            case 2:{
                System.out.println("No diponible por el momento");
                break;
            }
            case 3:{
                System.out.println("Mandar a llamar a BFS xD");
                arbol.breadthFirst();
                break;
            }
            case 4:{
                System.out.println("No diponible por el momento");
                break;
            }
            case 5:{
                System.out.println("No diponible por el momento");
                break;
            }
            case 6:{
                System.out.println("No diponible por el momento");
                break;
            }
            case 7:{
                System.out.println("No diponible por el momento");/*
                System.out.println("Elegiste la opcion de buscar");
                System.out.println("para ello necesito que agregues los nodos antes");
                Agregar_Bin(arbol);
                System.out.println("\nAhora si podemos realizar la busqueda :D");
                System.out.println("Que elemento quieres buscar?");
                Scanner lector2=new Scanner(System.in);
                int val =lector2.nextInt();
                arbol.busqueda(val);*/
                
                break;
            }
            
            default:{
                System.out.println("Opcion Invalida xd");
                break;
            }
        }//switch
    }//menuArbolBinadio xd
    
    
    
    public static void menuArbolesBinariosBusqueda(){
        System.out.println("\n\n\t bienvenido al menu de Arboles Binarios de Busqueda");
        System.out.println("Seleccione la operacion que quiera realizar");
        System.out.println("1) Agregar ");
        System.out.println("2) Eliminar");
        System.out.println("3) Buscar ");
        System.out.println("4) Imprimir Arbol");
        
        Scanner lector=new Scanner(System.in);
        int op =lector.nextInt();
        switch(op){
            case 1:{
                System.out.println("Mandar a llamar a AGREGAR xD");
                break;
            }
            case 2:{
                System.out.println("Mandar a llamar a ELIMINAR xD");
                break;
            }
            case 3:{
                System.out.println("Mandar a llamar a BUSCAR xD");
                break;
            }
            case 4:{
                System.out.println("Mandar a llamar a IMPRIMIR ARBOL xD");
                break;
            }
            
            default:{
                System.out.println("Opcion Invalida xd");
                break;
            }
        }//switch
    }
    
    
     public static void Agregar_Bin(ArbolBin three ){
         LinkedList<Nodo> arbol_ = new LinkedList<>();
         boolean agregar = true;
         int z =1 ;
         while (z == 1){
         System.out.println("1) agregar nodo raiz ");
         System.out.println("2) agregar nodo  ");
         Scanner lect =new Scanner(System.in);
        int x = lect.nextInt();
        
        
        switch(x){
            case 1: {
                             System.out.println("valor del nodo raiz");
                            Scanner lec =new Scanner(System.in);
                            int val = lec.nextInt();
                            arbol_.add(new Nodo(val));
                            
                            three.root = new Nodo(val);
                            
                                z=1;
                    }break;
            
            case 2: {   while(agregar == true )
        
                         {  
                         System.out.println("valor del nodo");
                            Scanner lec =new Scanner(System.in);
                            int val = lec.nextInt();
        
                                        
                                     
                                     Nodo nodo = new Nodo(val);
                                     
                                     
                                     
                                 arbol_.add(nodo);
                                 three.add_(nodo);
                         
                            
                                 
        
        
                            System.out.println("desea seguir agregando nodos 0) si   1) no");
                            Scanner lector=new Scanner(System.in);
                            int op =lector.nextInt();
            
                            if (op == 1)
                                {
                                    agregar = false;
                                }
            
            
                          }
         
                       for( Nodo y : arbol_)
                        {
                            System.out.print(y.valor + " ");
                        }
                        z =8;
                        
                        menuArbolesBinarios(three);
                    }break;
            
        }
         
     }  
         
        
         
        
       
        
     }
    
    
}//clasePract8
