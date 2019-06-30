package p6grafos;
import java.util.Iterator;
import java.util.LinkedList;

public class Graph {
    private int V;//recibe el valor de 5 del constructor y este la clase principal
    private LinkedList<Integer> adjList[];
    
    Graph (int v){ //constructor
        V=v; //asigna a V la V de la clase principal
        adjList=new LinkedList[v];
        for(int i=0; i<v; ++i)
                adjList[i]=new LinkedList(); //crea 4 listas de arreglos
    }
    
    void addEdge (int v, int w){
    /*Asigna la direccion a las aristas del grafo*/
    adjList[v].add(w);
    adjList[w].add(v);  //<-AL comentar esta linea de codigo se le asigna una direccion
    //a nuestros grafos, esto se puede ver al graficar lo que nos muestra a pantalla
    }
    
    void printGraph (Graph graph){
        for(int v=0; v<graph.V; v++){ //un ciclo de 0 a 5
            System.out.println("Lista de Adyacencia del vertice"+v);
            System.out.println(v);
            for(Integer node : graph.adjList[v]){
                System.out.println("-> "+node);
    //Imprime a pantalla cada vertice indicando a que nodos apunta
            }
            System.out.println("\n");
        }
    }
          
     void BFS(int s){
        boolean visited[] = new boolean[V];
        
        LinkedList <Integer> queue= new LinkedList<Integer>();
        
        visited[s]=true; //<-el nodo que tomara en cuenta como el inicio del recorrido
        //lo inicializa como visitado
        queue.add(s);
        
        while (queue.size() != 0){
            s= queue.poll();
            System.out.println(s+"");
            
            Iterator<Integer> i = adjList[s].listIterator();
            while(i.hasNext()){
                int n=i.next();
                if(!visited[n]){
                    visited[n] = true; //<- marca como visitado a los nodos dependiendo la capa en la que este
                    queue.add(n);
                }
            }
        }
        
    }
     
     void DFSUtil (int v, boolean visited[]){
         visited[v]=true;
         System.out.println(v+"");
         
         Iterator<Integer> i= adjList[v].listIterator();
         while(i.hasNext()){
             int n=i.next();
             if(!visited[n])
                 DFSUtil(n, visited);
             
         }
     }
     void DFS(int v){
         boolean visited[]= new boolean [V];
         DFSUtil(v,visited);
     }
     
     
}

