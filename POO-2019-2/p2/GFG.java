/*
*Se hace uso de la clase Calendar dentro de esta clase CalendarGFG
*de igual mandera se hace uso del constructor de Gregorian calendar para
*asignar valores a las variables date, time, tiem zone an locale las cuales 
*pertenecen a las clases a las que se heredan
*/
import java.util.Calendar; 

import java.util.GregorianCalendar; 

class CalendarGFG { 

    public static void main(String[] args) 
    { 
        Calendar cal = Calendar.getInstance(); 
        //se crea el objeto cal instanciando la clase Calendar

        GregorianCalendar gcal = new GregorianCalendar(); 
        //Se crea el objeto gcal instanciando a GregorianCalendar

        System.out.println("Calendar date: "

                           + cal.getTime()); 
        //Se imprime el tiempo registrado en el objeto cal

        System.out.print("Gregorian date: "

                         + gcal.getTime()); 
/*Se imprime el tiempo registrado con el objeto de gcal
esto ultimo lo hace con el formato occidental al ser instanciado de la clase hija GregorianCalendar*/
    } // cierre de la funcion main

} // cierra de la clase