
package menuproyecto1;
import java.io.*;
import java.util.LinkedList;

public class Lector {
    
    /**
     * 
     * @param archivo Nombre del archivo que se va a leer, debe de llevar .txt
     * @param Lista Lista donde se guardará el contenido del archivo
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public static void Leer(String archivo,LinkedList<Integer> Lista) throws FileNotFoundException, IOException{
    
        int i;
        String cadena;
        String[] partes;
        
        FileReader E = new FileReader(archivo);//objeto que lee el archivo
        BufferedReader R = new BufferedReader(E);//s
        cadena=R.readLine();// leer la linea del archivo en la cadena auxiliar 
        
        R.close();//cerrar el archivo para que otro metodo pueda usarlo
        
        partes=cadena.split(",");/*separar la cadena en un arreglo de cadenas, cada elemento es 
                                es el número que hay entre comas*/
        for(i=0;i<partes.length;i++)//ciclo que va recorriendo el arreglo de cadenas y los mete en la lista destino
            Lista.add(Integer.parseInt(partes[i]));//usamos la funcion add para ir metiendo los elementos en la lista,parseint para "casting"
        
    
    }
    
    /**
     * 
     * @param archivo es el archivo al cual se va a sustituir, debe de llevar .txt
     * @param Lista es la lista que se ingresará al archivo
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public static void Escribir(String archivo, LinkedList<Integer> Lista) throws FileNotFoundException, IOException{
        int i;//contador del método
        String cadena="";//es la cadena donde guardaremos los elementos de la lista de entrada
        for(i=0;i<Lista.size();i++){//ciclo para convertir de lista a cadena
            if(i!=(Lista.size()-1))
                cadena=cadena+Integer.toString(Lista.get(i))+",";
            else
                cadena=cadena+Integer.toString(Lista.get(i));
        }
        File arch = new File(archivo);//Para manejar archivo
        arch.delete();//borramos el archivo para que muestre solamente el archivo ordenado y no las iteraciones
        arch.createNewFile();//rehacemos el archivo
        FileWriter OpenFile = new FileWriter (archivo,true);//para escribir
        PrintWriter PW = new PrintWriter (OpenFile);//para escribir
        
        PW.write(cadena);//le mandamos que escriba la lista convertida en cadena
        OpenFile.close();//cerramos el archivo
    }
    /**
     * 
     * @param Lista es la lista 
     * @param nomLista es el nombre del archivo resultante, no debe de llevar txt
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public static void EscribirHistorial(LinkedList<Integer> Lista,String nomLista) throws FileNotFoundException, IOException{
        int i;//el contador 
        String cadena="";//es la cadena donde guardaremos los elementos de la lista de entrada
        for(i=0;i<Lista.size();i++){
            if(i!=(Lista.size()-1))
                cadena=cadena+Integer.toString(Lista.get(i))+",";
            else
                cadena=cadena+Integer.toString(Lista.get(i));
        }
        File arch = new File(nomLista+".txt");
        if(arch.exists()==false){
            arch.createNewFile();
        }
        FileWriter OpenFile = new FileWriter (nomLista+".txt",true);
        PrintWriter PW = new PrintWriter (OpenFile);
        PW.println(cadena);
        
        
        OpenFile.close();
    }
    
    public static void main(String[] args) throws IOException {
        
        boolean asc=true;
        Radix radax = new Radix("ArchivoRadix.txt",asc);
        Radix radex = new Radix("ArchivoB.txt", false);
        
        
    }
}