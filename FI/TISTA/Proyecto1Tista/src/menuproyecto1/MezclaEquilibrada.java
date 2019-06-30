
package menuproyecto1;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.ListIterator;
import static menuproyecto1.BubbleSort.hacerBubble;
import menuproyecto1.QuickSort;
import static menuproyecto1.QuickSort.printArray;
import static menuproyecto1.QuickSort_1.printArray;

public class MezclaEquilibrada {
    
    public static void hacerMezclaE(int orden){
       switch (orden){
            case 1:{
                System.out.println("hemos entrado a Mezcla Equilibrada Acendente");
                System.out.println("Ahora solo se manda a llamar");
                LinkedList <Integer> prueba = new LinkedList <> ();
                prueba.add(5);
                prueba.add(6);
                prueba.add(7);
                prueba.add(2);
                prueba.add(2);
                prueba.add(16);
                prueba.add(9);
                
               // int prueba [ ]= {5,6,7,2,2,16,9,20,10};
                //int prueba [ ]= {20,15,10,36,32,90,100,20,10};
               System.out.println("Archivo con datos:"); 
                for(Integer node : prueba){
                System.out.print(""+node+",");}
                System.out.println(" ");
                
                EquilibradaAscendente(prueba); 
                 
                break;
            }
            
            case 2:{
                System.out.println("hemos entrado a MezclaEquilibrada Descendente");
                System.out.println("Ahora solo se manda a llamar");
                //int prueba [ ]= {5,6,7,2,2,16,9,20,10};
               //int prueba [ ]= {20,15,10,36,32,90,100,20,10};
               LinkedList <Integer> prueba = new LinkedList <> ();
                prueba.add(20);
                prueba.add(15);
                prueba.add(10);
                prueba.add(36);
                prueba.add(32);
                prueba.add(90);
                prueba.add(100);
                System.out.println("Archivo con datos:"); 
               for(Integer node : prueba){
                System.out.print(""+node+",");}
                System.out.println(" ");
                
                EquilibradaDescendiente(prueba); 
                break;
            }
            
            default:{
                System.out.println("valor de ordenamiento Ascente/Descendente invalido");
                break;
            }
                   
        }
        
        
    }
           
    
    public static void EquilibradaAscendente(LinkedList<Integer> lista){
        LinkedList <Integer> aux1= new LinkedList<>();
        LinkedList <Integer> aux2= new LinkedList<>();
       
       
       
        aux1.add(lista.get(0));
       
       
       int n= 0;
       boolean auxiliar = true;
        int i = 1;
       
       while ( i<lista.size())
        {  if(auxiliar == true)
            {         if(lista.get(i)>= lista.get(i-1))
                        { aux1.add(lista.get(i));
                            auxiliar = true;
                            //i++;
                         }
                         
                         else
                        {   aux2.add(lista.get(i));
                            auxiliar = false;
                        }
            }
            else
              {
                    if(auxiliar == false)
                    {   
                        if(lista.get(i)>= lista.get(i-1))
                        { aux2.add(lista.get(i));
                            auxiliar = false;
                            //i++;
                         }
                         
                         else
                        {   aux1.add(lista.get(i));
                            auxiliar = true;
                        }
                        
                    }
              }
            
           
            i++;
            
        }
       
             
            
    
        
        System.out.println("\nLista aux1");
        aux1.forEach((node) -> {
            System.out.print(""+node + ",");
        });
        System.out.println(" ");
        
        System.out.println("\nLista aux2");
        aux2.forEach((node) -> {
            System.out.print(""+node+ ",");
        });
        System.out.println(" ");
        
        lista.clear();
        
        lista.addAll(aux1);
        lista.addAll(aux2);
        
        System.out.println("\nLista original = aux1 + aux2");
        lista.forEach((node) -> {
            System.out.print(""+node + ",");
        });
        System.out.println(" ");
        
         /*QuickSort ob = new QuickSort();
        QuickSort.sort(lista,0,lista.size()-1);
        printArray(lista);*/
        
        
    }
        
    
    
    
    public static void EquilibradaDescendiente(LinkedList<Integer> lista){
        LinkedList <Integer> aux3= new LinkedList<>();
        LinkedList <Integer> aux4= new LinkedList<>();
       
       
       
        aux3.add(lista.get(0));
       
       
       int n= 0;
       boolean Aux = true;
        int i = 1;
       
       while ( i<lista.size() )
        {  if(Aux == true)
            {         
                    if(lista.get(i)<= lista.get(i-1))
                        { aux3.add(lista.get(i));
                            
                            Aux = true;
                            //i++;
                         }
                         
                         else
                        {   aux4.add(lista.get(i));
                        //System.out.println("agregando " + lista[i]);
                            Aux = false;
                        }
            }
            else
              {
                    if(Aux == false)
                    {   
                        if(lista.get(i)<= lista.get(i-1))
                        { aux4.add(lista.get(i));
                        //System.out.println("agregando " + lista[i]);
                            Aux= false;
                            //i++;
                         }
                         
                         else
                        {   aux3.add(lista.get(i));
                        //System.out.println("agregando " + lista[i]);
                            Aux = true;
                        }
                        
                    }
              }
            
           
            i++;
            
        }
       
        
        System.out.println("\nLista aux1");
        aux3.forEach((Integer node) -> {
            System.out.print(""+node + ",");
        });
        System.out.println(" ");
        
        System.out.println("\nLista aux2");
        aux4.forEach((node) -> {
            System.out.print(""+node+ ",");
        });
        System.out.println(" ");
         lista.clear();
        
        lista.addAll(aux3);
        lista.addAll(aux4);
        
        System.out.println("\nLista original = aux1 + aux2");
        lista.forEach((node) -> {
            System.out.print(""+node + ",");
        });
        System.out.println(" ");
        
        hacerBubble(lista);
        System.out.println("\n\nBubble");
       lista.forEach((node) -> {
            System.out.print(""+node + ",");
        });
        System.out.println(" ");
        
        hacerBubble(lista);
        System.out.println("\n\nBubble");
       lista.forEach((node) -> {
            System.out.print(""+node + ",");
        });
        System.out.println(" ");
        
        /*
         QuickSort_1 ob = new QuickSort_1();
        QuickSort_1.sort(lista, 0,lista.size-1);
        System.out.println("sorted array");
        printArray(lista);
        
        EquilibradaDescendiente(lista);*/
        
    }
    
      
}
    
