package practica4_mejiaisrael;
import java.util.*;

public class EquipoFutbol {
    String nombre;
    String estado;
    int campeonatosGanados;
    int anioCreacion;
    int partidosGanadosSep;
    
    public EquipoFutbol(){
        
    }
    public EquipoFutbol(String nombre,String estado,int campeonatosGanados,int anioCreacion,int partidosGanadosSep){
        this.nombre =nombre;
        this.estado = estado;
        this.campeonatosGanados =campeonatosGanados;
        this.anioCreacion= anioCreacion;
        this.partidosGanadosSep= partidosGanadosSep;
    }
    
    public String imprimirDatos(){
      return "El equipo es"+nombre+" es del estado"+estado+"en el año"+anioCreacion+"\ntiene "+campeonatosGanados+" campeonatos Ganados y "+partidosGanadosSep+" partidos ganados en Septiembre";
    }
    
}


     class Equipos{

ArrayList <EquipoFutbol> listaEquipos = new ArrayList <EquipoFutbol> ();
EquipoFutbol pumas = new EquipoFutbol("Pumas","Mexico", 1954,7,1);
EquipoFutbol chivas = new EquipoFutbol("Chivas","Guadalajara", 1970,11,0);
EquipoFutbol america = new EquipoFutbol("america","Mexico", 1916,15,1);
EquipoFutbol tigres = new EquipoFutbol("tigres","Mexico", 1960,6,1);
EquipoFutbol pachuca = new EquipoFutbol("pachuca","pachuca", 1988,3,1);

listaEquipos.add(pumas);

for (EquipoFutbol e: listaEquipos ){
         
     }

}





