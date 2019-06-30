package practica10;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Practica10 {

    
    public static void main(String[] args) {
        String direccion="";
        System.out.println("\tBienvenido a la practica 10\nElaborada por:");
        System.out.println("Rosario Morales Oscar Daniel ");//pon aqui tu nombre compa --------------------------xD
        System.out.println("Mejía Alba Israel Hipólito");
        int op=0;
        do{
        System.out.println("\n\nEliga la operacion que quiera realizar, cabe destacar que se tiene que crear el archivo antes de cualquier otra opcion:");
        System.out.println("1) Crear de un archivo");
        System.out.println("2) Sobreescribir sobre un archivo");
        System.out.println("3) Editar un archivo");        
        System.out.println("4) Eliminar un archivo");
        System.out.println("5) Salir");
        Scanner lector=new Scanner(System.in);
        op =lector.nextInt(); 
        switch(op){
            case 1:{
                System.out.println("\tElegiste Crear de un archivo");    
                direccion=crear();
            break;  }            
            
            case 2:{
                 System.out.println("\n\tElegiste Sobreescribir sobre un archivo"); 
                 sobreEscribe(direccion);
            break; }            
            
            case 3:{
                System.out.println("\tElegiste Editar un archivo");     
                Edita(direccion);
            break;}  
            case 4:{
                System.out.println("\tElegiste Eliminar un archivo");   
                borra(direccion);
            break;  }
             case 5:{                
                System.out.println("\tElegiste salir");             
            break;  }
            
            default:{
            System.out.println("Valor invalido");           
            break;    
            }
        }            
        }while (op!=5);   
    }
    
    public static String crear(){               
       System.out.println("Ingrese el nombre de su archivo como se puede ver en el siguiente ejemplo:\tarchivo.txt");
       Scanner cadena = new Scanner(System.in);
       String nomArchivo=cadena.nextLine();          
       String dirArch="Archivos/"+nomArchivo;
       Path path = Paths.get(dirArch);
       try{
	Files.createDirectories(path.getParent());
	Files.createFile(path);			
               System.out.println("El fichero fue creado.");
        }catch(IOException e){
	System.out.println("Error, el archivo ya habia sido creado. "+e.getMessage());
        }    
       return dirArch;  
       
       /*Esta clase te crea el directorio archivos que contiene al txt que el usuario nombra, esta direccion relativa se guarda en el
       path, para depues ser usada en los metodos .createDirectories() , path.getParent(), .createFile. esto haciendo uso de
       las excepsiones, si no se logra hacer, es porque el fichero ya habia sido creado*/
       
    } //crear()  
    
    public static void sobreEscribe(String dir){
        System.out.println("Esta opcion te remplaza el contenido de tu documento .txt, recuerda que tienes que haberlo creado y editado anteriormente.");
        boolean existe=SEborra(dir);
        if(existe){
        SEcrear(dir);
        System.out.println("A continuacion ingrese lo que quiera que ahora tenga su documento");
        Scanner cadena = new Scanner(System.in);
        String sobrEs=cadena.nextLine(); 
        System.out.println(sobrEs);
        SEsobreEscribe(dir,sobrEs);
        
       /*Este metodo aparenta como se pidio en la practica remplaza al documento, esto al borrarlo y crear uno nuevo con 
            el mismo directorio y la nueva informacion que quiere el usuario que tenga.
            Para esto se hizo uso de todos los metodos modificados (tienen el mismo nombre con un SE al ininicio)
            que contiene este proyecto relativo a manejo de archivos*/ 
            
        }
        
    }//sobreEscribe(dir)
 
    public static void Edita(String dir){
       System.out.println("Dentro de esta opcion podra agegar texto al archivo txt creado, ingrese lo que desee:");
       Scanner cadena = new Scanner(System.in);
       String mastexto=cadena.nextLine(); 
        try{
	PrintWriter writer = new PrintWriter(new FileWriter(dir,true));
	writer.append(mastexto);
	writer.close();			
	System.out.println("Se escribió correctamente en el archivo.");
               }catch(Exception e){
                    System.out.println("Error añadiendo datos al fichero");
	}       
        /*Esta clase crea un objeto de escritura el cual recibe la direccion del archivo, si se encontro, este mismo objeto
        se encarga de agregar la cadena que recibe en su metodo append y luego cierra el flujo. En caso de que no se pueda hacer
        o que no se encontro el fichero, se le notifica al usuario que no se logro hacer la escritura*/
    }//Edita(dir)
    
    public static void borra(String dir){
        File file = new File(dir);
        if(file.exists()){
           if(file.delete())
                System.out.println("Se logro eliminar el archivo solicitado");			
        }else
            System.out.println("\tNo existe ningun archivo que eliminar, crea uno antes de realizar esta accion ;D");		
   /*Este metodo crea un objeto de tipo file con la direccion de nuestro archivo txt creado anteriormente, en caso de que el txt original 
        no se haya creado el directorio sera nulo y entra dentro del if para ser eliminado*/
    }//borra(dir)
    
    public static boolean SEborra(String dir){
        boolean existe=true;
        File file = new File(dir);
        if(file.exists()){
           if(file.delete())
                System.out.println("\n");			
        }else{
            System.out.println("\tNo existe ningun archivo que eliminar, crea uno antes de realizar esta accion ;D");
            existe=false;
        }
        return existe;   
/*Este metodo elimina el archivo si es que existe y devuelve true si el archivo existia, en caso contrario un false 
        y se evitan los demas metodos en  sobreEscribe(String dir) */        
    }//borra(dir)
     
    public static void SEcrear(String dir){   
       Path path = Paths.get(dir);
       try{
	Files.createDirectories(path.getParent());
	Files.createFile(path);			
               System.out.println("\n");
        }catch(IOException e){
	System.out.println("Error, el fichero existe. "+e.getMessage());
        }     
       /*Este metodo crea el txt para usando el directorio que le pertenecia al archivo original que ya fue eliminado
       esto lo hace usando los metodos pertenecientes a la clase File explicados anteriormente*/
    } //crear() 
    
    public static void SEsobreEscribe(String dir,String sobrEs){       
       String nuevoTex=sobrEs; 
        try{
	PrintWriter writer = new PrintWriter(new FileWriter(dir,true));
	writer.append(nuevoTex);
	writer.close();			
	System.out.println("Se Sobreescribio correctamente en el archivo.");
               }catch(Exception e){
                    System.out.println("Error sobreescribiendo datos al fichero");
	}       
        /*Este documento escribe usando un objeto writer para escribir en el nuevo txt creado, al tener el mismo
        nombre y directorio da la ilusion de haber sobreescrito el txt*/
    }//SEsobreEscribe(String dir,String sobrEs)
    
     public static void imprime(String dir){        
       try{
           FileReader lee = new FileReader(dir);
           BufferedReader buffer = new BufferedReader(lee);
           String leido;
           while((leido=buffer.readLine())!=null){
               System.out.println(""+leido);
           }
           buffer.reset();
           
       }catch(Exception e){
           System.out.println("No se pudo leer el .txt para mostrarlo a pantalla :c, puede que este vacio");
       }     
       /*Este metodo imprime el archivo usando un objeto de tipo FileRider que recibe el directorio del archivo y otro objeto
       de tipo BufferedReader para ir recibiendo la informacion de poco a poco, donde si recibe un dato nulo se sale del
       ciclo while y por lo que acabo de imprimir todo el tx
       Solia el buffer afectar en los archivos en el metodo de sobre escritura y en otros en ocaciones 
       por lo que mejor ya no se agrego al programa, intente arreglarlo de distintas 
       maneras pero ya no se pudo hacer bien*/
     }//imprime(dir);
       
    
}
