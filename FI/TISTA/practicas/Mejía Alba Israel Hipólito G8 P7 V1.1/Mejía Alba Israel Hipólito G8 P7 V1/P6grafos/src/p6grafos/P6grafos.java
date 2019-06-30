
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
        graph.BFS(1);
        
        System.out.println("\n\n----------------------------\n\tverificandoDFS\n\n");
        Graph graph3 = new Graph(8);
        //se construyen las aristas
        graph3.addEdge(1,3);
        graph3.addEdge(1,5);
        graph3.addEdge(3,6);
        graph3.addEdge(4,6);
        graph3.addEdge(3,7);
        graph3.addEdge(5,7);
        graph3.addEdge(5,4);
        graph3.addEdge(7,2);
        graph3.addEdge(7,4);
        graph3.addEdge(2,6);
        graph3.addEdge(2,0);
        graph3.addEdge(0,4);
        graph3.addEdge(0,6);
        
        graph.printGraph(graph3);
        graph3.DFS(1);
        
        System.out.println("\n\n----------------------------\n\tGrafo Extra1\n\n");
        Graph graph4 = new Graph(8);
        //se construyen las aristas
        graph4.addEdge(1,2);
        graph4.addEdge(2,3);
        graph4.addEdge(3,4);
        graph4.addEdge(3,5);
        graph4.addEdge(4,6);
        graph4.addEdge(5,7);
        
        graph.printGraph(graph4);
        graph4.DFS(1);
        
        System.out.println("\n\n----------------------------\n\tGrafo Extra2\n\n");
        Graph graph5 = new Graph(8);
        //se construyen las aristas
        graph5.addEdge(1,2);
        graph5.addEdge(1,5);
        graph5.addEdge(2,3);
        graph5.addEdge(2,4);
        graph5.addEdge(3,7);
        graph5.addEdge(5,4);
        graph5.addEdge(5,6);
        
        graph.printGraph(graph5);
        graph5.DFS(1);
        
        System.out.println("\n\n----------------------------\n\tGrafo Extra3\n\n");
        Graph graph6 = new Graph(8);
        //se construyen las aristas
        graph6.addEdge(1,2);
        graph6.addEdge(1,4);
        graph6.addEdge(2,6);
        graph6.addEdge(6,5);
        graph6.addEdge(4,5);
        graph6.addEdge(4,3);
        graph6.addEdge(5,7);
        
        graph.printGraph(graph6);
        graph6.DFS(1);

        
        
    }
    
}
