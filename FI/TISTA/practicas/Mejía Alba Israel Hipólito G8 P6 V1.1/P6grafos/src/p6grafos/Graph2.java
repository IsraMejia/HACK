package p6grafos;
import java.util.Iterator;
import java.util.LinkedList;

public class Graph2 {
    private int V;//recibe el valor de 5 del constructor y este la clase principal
    private LinkedList<Integer> adjList[];
    
    Graph2 (int v){ //constructor
        V=v; //asigna a V la V de la clase principal
        adjList=new LinkedList[v];
        for(int i=0; i<v; ++i)
                adjList[i]=new LinkedList(); //crea 4 listas de arreglos
    }
    
    void addEdge2 (int v, int w){
    /*Asigna la direccion a las aristas del grafo*/
    adjList[v].add(w);
    //adjList[w].add(v);  <-AL comentar esta linea de codigo se le asigna una direccion
    //a nuestros grafos, esto se puede ver al graficar lo que nos muestra a pantalla
    }
    
    void printGraph2 (Graph2 graph){
        for(int v=0; v<graph.V; v++){ //un ciclo de 0 a 5
            System.out.println("Lista de Adyacencia del vertice"+v);
            System.out.println(v);
            for(Integer node : graph.adjList[v]){
                System.out.println("----"+(v+Math.floor(Math.random()*5) )+"-> "+node);
                /*Agregue un numero aleatorio para que al imprimir a pantalla las aristas 
                tengan un valor numerico y ahora sea Ponderado Dirigido*/
    //Imprime a pantalla cada vertice indicando a que nodos apunta
            }
            System.out.println("\n");
        }
    }
    
   
                
}

