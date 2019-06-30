
package menuproyecto1;

import java.util.LinkedList;

public class BubbleSort {
    
    public static void hacerBubble(LinkedList<Integer> lista){
        int i,j,b;
        int indice,temporal=0;
        i=lista.size()-1;
        while(i>0){
            indice=0;
            for(j=0;j<i;j++){
                if(lista.get(j++)<lista.get(j)){
                    b=lista.get(j++);
                    temporal=lista.get(j);
                    lista.get(j,b);
                    lista.get(j++,temporal);
                    indice=j;
                }
            }
            i= indice;
        }
    }
    
}
