
package practica5mejiaisrael;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Scanner;

public class TablasHash {
    
    public static void hacerTablas(){
        
        boolean opera=true;
        HashMap<Integer,String> mapa = new HashMap <Integer, String>();
        
        mapa.put(123, "Lucho");
        mapa.put(24, "Ana");
        mapa.put(22, "io xd");
        mapa.put(927, "Isaac");
        mapa.put(77, "Coco");
        
        Hashtable<Integer,String> hash = new Hashtable<>();
         hash.put(12,"Alo");
         hash.put(122,"Cliford");
         hash.put(112,"Golis");
         hash.put(2,"Dracko");
         
        System.out.println("Se ha creado dos tablas una HasTable y otra HashMap");
        System.out.println("A continuacion se muestra como hacer los siguientes metodos");
        
        while (opera){
        System.out.println("\n\nEliga la opcion qie quieras realizar");
        System.out.println("1) contains ");
        System.out.println("2) containsKey");
        System.out.println("3) containsValue ");
        System.out.println("4) equals ");
        System.out.println("5) get ");
        System.out.println("6) put ");
        System.out.println("7) remove ");
        System.out.println("8) size ");
        System.out.println("\t Use Cualquier otro numero para salir ");
        
        Scanner lector=new Scanner(System.in);
        int op =lector.nextInt(); //Se crea el objeto escaner con el cual se va a leer el valor de x en consola
      
        switch(op){
            case 1:{
            System.out.println("\n\n\n");
            System.out.println("Elegiste contains");
            hacercontains(hash);
            break;    
            }
            
            case 2:{
            System.out.println("\n\n\n");
            System.out.println("Elegiste containsKey");
            hacercontainsKey(mapa);
            break;    
            }
            
            case 3:{
            System.out.println("\n\n\n");
            System.out.println("Elegiste containsValue");
            hacercontainsValue(hash);
            break;    
            }
            
            case 4:{
            System.out.println("\n\n\n");
            System.out.println("Elegiste equals");
            hacerequals(hash);
            break;    
            }
            
            case 5:{
            System.out.println("\n\n\n");
            System.out.println("Elegiste get");
            hacerget(mapa);
            break;    
            }
            
            case 6:{
            System.out.println("\n\n\n");
            System.out.println("Elegiste put");
            hacerput(mapa);
            break;    
            }
            
            case 7:{
            System.out.println("\n\n\n");
            System.out.println("Elegiste remove");
            hacerremove(hash);
            break;    
            }
            
            case 8:{
            System.out.println("\n\n\n");
            System.out.println("Elegiste size");
            hacersize(mapa);
            break;    
            }
            
            default:{
            System.out.println("Valor invalido o decidio salir");
            opera=false;
            break;    
            }
        }
        
        }
        
        //System.out.println("Holis xd");
        
    }
    
    public static void hacercontains(Hashtable hash){
        System.out.println("\tSe realizara contains con la siguiente tabla de tipo HashTable");
        System.out.println(hash);
        System.out.println("\n el metodo contains sirve para preguntar si se encuentra algun valor en el HashTable");
        System.out.println("Se pone a prueba la funcion con el siguiente codigo");
        System.out.println("\t/*if(hash.contains('Alo')){\n" +
"             System.out.println(\"Si esta alo\");\n" +
"         }else{\n" +
"             System.out.println(\"No esta Alo\");\n" +
"         }*/");
         if(hash.contains("Alo")){
             System.out.println("Si esta Alo");
         }else{
             System.out.println("No esta Alo");
         }
        
        }
    
    
    public static void hacercontainsKey(HashMap mapa){
        System.out.println("\tSe realizara containsKey con la siguiente tabla de tipo HashMap");
        System.out.println(mapa);
        System.out.println("\n el metodo containsKey sirve para preguntar si se encuentra alguna clave en el HashTable/Map");
        System.out.println("lo pondremos a prueba en nuestro HashMap");
        System.out.println("si mapa contiene la llave 123, imprime su valor");
        if((mapa.containsKey(123))==true){
            System.out.println(mapa.get(123));
         }
        
    }
    
    
    public static void hacercontainsValue(Hashtable hash){
        System.out.println("\tSe realizara containsvalue con la siguiente tabla de tipo HashTable");
        System.out.println(hash);
        System.out.println("\n el metodo containsKey sirve para preguntar si se encuentra algun valor en el HashTable/Map");
        System.out.println("lo pondremos a prueba en nuestro HashTable");
        System.out.println("si mapa contiene a Lucho, imprime Aqui esta Lucho xd");
        if(hash.containsValue("Lucho")){
            System.out.println("Aqui esta Lucho xd");
        }else{
            System.out.println("Aqui esta NO esta Lucho");
        }
        
    }
    
    
    public static void hacerequals(Hashtable hash){
        System.out.println("\tSe realizara equals con la siguiente tabla de tipo HashTable");
        System.out.println(hash);
        System.out.println("oh si By");
        //ESTE FALTAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
    }
    
    
    public static void hacerget(HashMap mapa){
        System.out.println("\tSe realizara get con la siguiente tabla de tipo HashMap");
        System.out.println(mapa);
        System.out.println("\n el metodo get sirve para traer algun valor de nuestro HashTable/Map");
        System.out.println("lo pondremos a prueba en nuestro HashMap");
        System.out.println("Se imprimira usando get el valor dela llave 123");
        System.out.println(mapa.get(123));
        
    }
    
    
    public static void hacerput(HashMap mapa){
        System.out.println("\tSe realizara put con la siguiente tabla de tipo HashMap");
        System.out.println(mapa);
        System.out.println("\n el metodo put sirve para agregar algun valor de nuestro HashTable/Map");
        System.out.println("lo pondremos a prueba en nuestro HashMap");
        System.out.println("Se agregara a BlackPanther en la llave 7 a nuestro HashMap usando put");
        mapa.put(7, "BlackPanther");
        System.out.println(mapa);
        
        
    }
    
    public static void hacerremove(Hashtable hash){
        System.out.println("\tSe realizara remove con la siguiente tabla de tipo HashTable");
        System.out.println(hash);
        System.out.println("\n el metodo remove sirve para eleminar un elementode nuestro HashTable/Map");
        System.out.println("lo pondremos a prueba en nuestro HashTable");
        System.out.println("se eliminara del hashtable a Alo");
        //hash.put(12,"Alo");
        hash.remove(12);
        System.out.println(hash);
        
    }
    
    public static void hacersize(HashMap mapa){
        System.out.println("\tSe realizara size con la siguiente tabla de tipo HashMap");
        System.out.println(mapa);
        System.out.println("\n el metodo size sirve para saber el tamaño->numero de elementos HashTable/Map");
        System.out.println("lo pondremos a prueba en nuestro HashMap");
        System.out.println("Se preguntara cuantos elementos hay en nuestro HashMap usando size");
        System.out.println("En Mapa hay " +mapa.size()+" elementos");
        
    }
    
}
