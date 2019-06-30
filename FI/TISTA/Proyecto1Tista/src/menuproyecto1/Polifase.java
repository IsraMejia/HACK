
package menuproyecto1;


public class Polifase {
    
    public static void hacerPolifase(int orden){
       
        switch (orden){
            case 1:{
                System.out.println("hemos entrado a Polifase Acendente");
                System.out.println("Ahora solo se manda a llamar");
                break;
            }
            
            case 2:{
                System.out.println("hemos entrado a Polifase Descendente");
                System.out.println("Ahora solo se manda a llamar");
                break;
            }
            
            default:{
                System.out.println("valor de ordenamiento Ascente/Descendente invalido");
                break;
            }
                   
        }
        
        
    }
}
