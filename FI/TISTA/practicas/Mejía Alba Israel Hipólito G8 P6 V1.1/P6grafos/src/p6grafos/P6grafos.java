
package p6grafos;

public class P6grafos {

    
    public static void main(String[] args) {

        int V=5;
        Graph graph = new Graph(V);
        //se construyen las aristas
        graph.addEdge(0,1);
        graph.addEdge(0,4);
        graph.addEdge(1,2);
        graph.addEdge(1,3);
        graph.addEdge(1,4);
        graph.addEdge(2,3);
        graph.addEdge(3,4);
        graph.printGraph(graph);
        
        System.out.println("----------------------------\nAhora con Grap2\n");
        Graph2 graph2 = new Graph2(V);
        graph2.addEdge2(0,1);
        graph2.addEdge2(0,4);
        graph2.addEdge2(1,2);
        graph2.addEdge2(1,3);
        graph2.addEdge2(1,4);
        graph2.addEdge2(2,3);
        graph2.addEdge2(3,4);
        graph2.printGraph2(graph2); 
        
        System.out.println("----------------------------\nverificandoBFS\n");
        graph.BFS(4);
    }
    
}
