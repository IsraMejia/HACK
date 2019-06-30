
package menuproyecto1;
import java.io.IOException;
import java.util.LinkedList;
import menuproyecto1.Lector;
//import public static menuproyecto1.Lector.Leer;  no logre mandar a llamar los metodos uno por uno


public class Radix {
     int digito,i,maximo;//digito sirve para guardar el valor de los digitos de cada clave
    //i serÃ¡ el contador de utilizarÃ¡ la clase
    //maximo sirve para recibir el nÃºmero de iteraciones necesarias del mÃ©todo digitsNumMax
    
    private LinkedList<Integer> ListaArr[]= new LinkedList[11];//haciendo un arreglo de listas tam. 11
    //la lista ListaArr[10] serÃ¡ donde se guardan los datos leÃ­dos, y la lista donde irÃ¡n los elementos ordenados.
    
    /**
     * 
     * @param archivo es el nombre del archivo que se ordenarÃ¡ por radix
     * @param asc booleano si es true el ordenamiento serÃ¡ ascendente, falso serÃ¡ descendiente
     * @throws IOException 
     */
    
    public static void hacerRadix(int orden) throws IOException{
        Radix rdx;
        switch (orden){
            case 1:{
                System.out.println("Se iniciara a realizar Radix Acendente");
                boolean asc=true;
                rdx = new Radix("archivo.txt",asc);
                break;
            }
            
            case 2:{
                System.out.println("Se iniciara a realizarRadix Descendente");
                boolean asc=false;
                rdx = new Radix("archivo.txt" ,asc);
                break;
            }
            
            default:{
                System.out.println("valor de ordenamiento Ascente/Descendente invalido");
                break;
            }
                   
        }
        
        
    }
    
    public Radix(String archivo,boolean asc) throws IOException{        
        
        for(i=0;i<11;i++){//inicializando el arreglo de listas
            ListaArr[i]= new LinkedList<Integer>();
        }             
        Lector.Leer(archivo,ListaArr[10]);//mandando a leer en el archivo y guardar en ListaArr[10]
        maximo = this.digitsNumMax(ListaArr[10]);//calculamos el nÃºmero de iteraciones
        
        for(i=0;i<maximo;i++){
            while(ListaArr[10].isEmpty()==false){//repetir hasta que se vacÃ­e la lista
                
                digito=(ListaArr[10].getFirst()%(int)Math.pow(10,i+1))/(int)Math.pow(10,i);
                //calculamos el dÃ­gito de cada llave 
                switch (digito){//switch sirve para meter en la lista que le corresponde a cada clave
                    case 0:
                        ListaArr[0].add(ListaArr[10].poll());
                        break;
                    case 1:
                    ListaArr[1].add(ListaArr[10].poll());
                        break;
                    case 2: 
                        ListaArr[2].add(ListaArr[10].poll());
                        break;
                    case 3: 
                        ListaArr[3].add(ListaArr[10].poll());
                        break;
                    case 4: 
                        ListaArr[4].add(ListaArr[10].poll());
                        break;
                    case 5: 
                        ListaArr[5].add(ListaArr[10].poll());
                        break;
                    case 6: 
                        ListaArr[6].add(ListaArr[10].poll());
                        break;
                    case 7: 
                        ListaArr[7].add(ListaArr[10].poll());
                        break;
                    case 8: 
                        ListaArr[8].add(ListaArr[10].poll());
                        break;
                    case 9: 
                        ListaArr[9].add(ListaArr[10].poll());
                        break;
                    
                }
            }
            for(int iH=0;iH<10;iH++)
                Lector.EscribirHistorial( ListaArr[iH],"Digito"+iH);/*
            escribimos el historial de iteraciones con el mÃ©todo EscribirHistorial() para c/digito.*/
            
            //
            if(asc)//este if else sirve para determinar si se ordenarÃ¡ ascendente o descendente
                for(int j=0;j<10;j++){//sacando los valores de las listas y metiÃ©ndolos en la ListaArr[10]
                                    //ListaArr[10] serÃ¡ la lista que se meterÃ¡ en el archivo.
                while(ListaArr[j].isEmpty()!=true){
                    ListaArr[10].add(ListaArr[j].poll());
                }
            }
            else
                for(int j=9;j>-1;j--){//sacando los valores de las listas y metiÃ©ndolos en la ListaArr[10]
                                    //ListaArr[10] serÃ¡ la lista que se meterÃ¡ en el archivo.
                while(ListaArr[j].isEmpty()!=true){
                    ListaArr[10].add(ListaArr[j].poll());
                }
            }
                
            
            
            System.out.println("\nIteraciÃ³n: "+(i+1)+" Lista:\n");//imprimimos la lista e indicamos el # de iteracion
            ListaArr[10].forEach((var) -> {//usamos esta forma de iterar porque lo sugiriÃ³ NetBeans >:D
                System.out.println(var);
            });
            Lector.EscribirHistorial( ListaArr[10],"Historial");//escribimos el historial de iteraciones.
        }
        
        
        Lector.Escribir(archivo,ListaArr[10]);//al finalizar el ordenamiento volvemos a escribir en el documento original.
        
    }
    
    public int digitsNumMax(LinkedList<Integer> Lista){/*Recibe a la lista donde estan los datos a ordenar.
        Sirve para encontrar las veces que se tiene que iterar
        con la potencia de 10 que hace a la divisiÃ³n del nÃºmero mayor del archivo entre dicha potencia de 10
        Primero encuentra el mÃ¡ximo con el ciclo for
        */
        int z;//iterador
        int maxi=Lista.getFirst();//maxi es el "indice" al cual se le compararÃ¡ con cada miembro de la lista, empezando por el primero
        for(z=1;z<Lista.size();z++){//el ciclo empieza en 1 porque no tendrÃ­a sentido comparar el mismo numero
            if(Lista.get(z)>maxi)
                maxi=Lista.get(z);                  
        }
        z=0;
        while(maxi/(int)Math.pow(10, z)!=0)//Reseteamos el contador para no declarar otro.
            z++;    //Hacemos la potencia de 10 a la z empezando con z=0 (o maxi / 1 )
            //elevamos la potencia hasta que la divisiÃ³n de maxi entre 10^z sea 0 
            
        return z;//regresa el valor de la potencia de 10 que necesitamos, lo que indica el # de iteraciones necesarias.
    }
    
}


