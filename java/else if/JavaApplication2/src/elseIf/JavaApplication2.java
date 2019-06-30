package elseIf;

import java.util.Scanner;

public class JavaApplication2 {

    public static void main(String[] args) {
        String estacion;
        System.out.println("Te dire en que mes estas, ingresa el mes por numero: ");
          Scanner sc = new Scanner(System.in);
          int mes = sc.nextInt();
          
        
          if(mes==1 || mes ==2 || mes==12){
              estacion= "Invierno";
              System.out.println("Estas en la estacion de "+estacion);
          }
          else if (mes==3 || mes ==4 || mes==5){
              estacion= "Primavera  ";
              System.out.println("Estas en la estacion de "+estacion);
          }
          else if (mes==6 || mes ==7 || mes==8){
              estacion= "Verano";
              System.out.println("Estas en la estacion de "+estacion);
          }
          else if (mes==9 || mes ==10 || mes==11){
              estacion= "Otoño";
              System.out.println("Estas en la estacion de "+estacion);
          }
          else{
              System.out.println("No existe ese mes shavo xD");
          }
    }
    
    
}
