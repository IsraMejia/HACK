import java.util.Random;

public class Matrices{

    private static int [][] m1= new int [3][3];
    private static int [][] m2= new int [3][3];
    private static int [][] m3= new int [3][3];

    public static void main (String[] args)  {
        Random num = new Random(System.nanoTime());//objeto num para numeros aleatorios
        
        System.out.println("Se van a crear dos matrices distintas...");
        for (int i = 0; i<3;i++){
            for(int j =0; j<3; j++){
                m1[i][j]= num.nextInt(9);
                m2[i][j]= num.nextInt(9);
       //Se le asigna a todos los espacios de las matrices 1 y2 valores del 0 al 9
            }
        } 
        
        System.out.println("Se creo la matriz 1 :");
        for (int i = 0; i<3;i++){
            System.out.println("");
            for(int j =0; j<3; j++){
                System.out.print(m1[i][j]+"  ");
            }
        }//Se manda a imprimir la matriz 1
        System.out.println("\n");
        
         System.out.println("Se creo la matriz 2 :");
        for (int i = 0; i<3;i++){
            System.out.println("");
            for(int j =0; j<3; j++){
                System.out.print(m2[i][j]+"  ");
            }
        }//Se manda a imprimir m2
        
        System.out.println("\n");
       System.out.println("\n\tAhora se va a relizar la multiplicacion de la matriz 1 por la matriz 2");
        System.out.println("calculando...");
        
        hilo h1 = new hilo(0);
        hilo h2 = new hilo(1);
        hilo h3 = new hilo(2);
        //Se crean los hilos con sus filas de operacion dentro del arreglo asignadas
        
        h1.start();
        h2.start();
        h3.start();
        //Se mandan a ejecutar las instrcciones de cada hilo para poder realizar la multiplicacion
        
        try{
            h1.join();
            h2.join();
            h3.join();
         //Se intenta esperar a que todos los hilos terminen
        }catch(Exception e){}//caso contrario se manda la excepcion
        
        System.out.println("Listo :D\n A continuacion se imprimira la matriz del resultados");
        
       System.out.println("\tEl resultado de la operacion es matriz 3 \nque es:");
        for (int i = 0; i<3;i++){
            System.out.println("");
            for(int j =0; j<3; j++){
                System.out.print(m3[i][j]+"  ");
            }
        }//Se imprime la matriz 3
        System.out.println("\n");
        
        
    }
 
static class hilo extends Thread{
    private int fila;
    
    public  hilo(int fila){
        this.fila=fila;
    //Se le asigna la fila de la matriz en la que va a operar
    }
 //Se crea el objeto hilo que hereda de la clase thread    
   public void run(){
       int i=fila; //Se hace la operacion dentro de la fila asignada del hilo
       for(int j =0; j<3;j++){
           int temporal = 0;
           for(int k=0;k<3;k++){
               temporal += m1[i][k]*m2[k][j];
               m3[i][j]=temporal;
        //se le asigna el valor de la multiplicacion al elemento de la matriz 3
           }
       }
   }   
}//cierra la clase hilo

}//matrices