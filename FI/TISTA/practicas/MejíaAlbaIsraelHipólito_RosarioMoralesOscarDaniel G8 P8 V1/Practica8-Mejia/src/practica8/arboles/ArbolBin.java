
package practica8.arboles;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author israe
 */
public class ArbolBin {//se crea la clase ArbolBin con su atributo root de tipo Nodo
    Nodo root;
    
    public ArbolBin(){//inicializa la raiz en nulo
        root=null;
    }
    
    public ArbolBin(int val){
        root=new Nodo(val);
    //Le asigna valor al nodo e inicializa sus hijos en nulo
    }
    
    public ArbolBin(Nodo root){
        this.root=root;
    }//Se reasigna la Raiz del arbol binario -----------------------Checar
    
    public void add(Nodo padre, Nodo hijo, int lado){
        if(lado==0)
            padre.setIzq(hijo);
        else
            padre.setDer(hijo);
    /*Añade al nodo hijo al padre del lado izquierdo si se manda un 0 en la funcion add
      si no es asi lo agega del lado izquierdo*/
    }
    
    
    public void add_(Nodo node)
    {   
        Nodo subnivel = new Nodo();
        subnivel = this.root;
        //Se crea el subnivel y se toma como referencia de raiz
        
        if ( subnivel.izq == null)
        {
           subnivel.izq = node;
        //Se le asigna nodo al hijo izquierdo de subnivel si esta vacio
        }
        else 
            if(subnivel.der == null)
            {
                subnivel.der = node;
            //Se le asigna nodo al hijo derecho de subnivel si esta vacio
            }
            else 
                if(subnivel.izq != null )
                {  subnivel = subnivel.izq;
                    subnivel.izq = node;
//Si el hijo izquierdo ya tiene valor, se baja un nivel mas y se le asigna el nodo al 
//hijo izquierdo siguiente
                }
                else 
                    if(subnivel.der != null )
                    {
                        subnivel=subnivel.der;
                        subnivel.der= node;
//Si no se cumple lo anterior y el hijo izquierdo de subnivel esta ocupado, 
//se baja un nivel mas y se le asigna el nodo al hijo derecho siguiente                     
                    }
                   
       
    }
    
    protected void visit (Nodo n){        
        System.out.println("NODO " + n.valor + " ");
   //imprime el valor del nodo para corroborar que fue visitado   
       }
    
    
    public void breadthFirst(){
        Nodo r=root; 
        Queue<Nodo> queue= new LinkedList();
        if(r!=null){
            queue.add(r);
        //Si la raiz no es nula, se agrega a la cola
            
            while(!queue.isEmpty()){
                r=(Nodo)queue.poll();
                visit(r);
            /*Mientras la lista no este vacia, se ira sacando cada raiz de la cola y se 
            imprimira a pantalla para corroborarlo*/
                
                if(r.izq !=null)
                    { queue.add(r.izq);
                    System.out.print(r.izq.valor  + " < --- Hijo izquierdo     " );}
                //Si el hijo izquierdo de la raiz existe, se añade a la cola y se manda a imprimir
                if(r.izq == null)
                    System.out.print( r.izq  + " < --- Hijo izquierdo     " );
                //Si no hay hijo izquierdo de la raiz, unicamente se manda a imprimir para que se vea que es nulo
                
                if(r.der != null)
                    {queue.add(r.der);
                    System.out.println("Hijo derecho  --->" + r.der.valor + "\n");}
                //Si el hijo derecho de la raiz existe, se añade a la cola y se manda a imprimir
                if(r.der == null)
                {
                    System.out.println("Hijo derecho  --->" + r.der + "\n");
                //Si no hay hijo izquierdo de la raiz, unicamente se manda a imprimir para que se vea que es nulo
                }
                    
                
              }
             
    
        } 
        
    }
    
    public void  busqueda( int val){
        boolean status = false;//para saber si existe o no
        Nodo r=root;
        Queue<Nodo> queue= new LinkedList();
        if(r!=null){//si existe la raiz esta se agrega a la lista
            queue.add(r);
            
            while(!queue.isEmpty()){//mientras la cola no este vacia
                r=(Nodo)queue.poll();
                //sacamos a la raiz de la cola y se la asignamos al nodo r
                visit(r);//se imprime dejando en claro que se visito
                if( val == r.valor)
                    status  = true;
                //Si se encuentra al valor se le asigna verdadero a status
                if(r.izq !=null)
                    { queue.add(r.izq);
                    System.out.print(r.izq.valor  + " < --- Hijo izquierdo     " );}
                //si el hijo isquierdo esta se agrega a la lista y se imprime a pantalla
                if(r.izq == null)
                    System.out.print( r.izq  + " < --- Hijo izquierdo     " );
                //si no se encuentra. solo se improime a la pantalla de que es nulo
                
                if(r.der != null)
                    {queue.add(r.der);
                    System.out.println("Hijo derecho  --->" + r.der.valor + "\n");}
                //Si el hijo derecho no es nulo se imprimer¿ a oantalla
                if(r.der == null)
                {
                    System.out.println("Hijo derecho  --->" + r.der + "\n");
                //si no se encuentra. solo se improime a la pantalla de que es nulo
                }
                    
                //System.out.println(status);
              } 
         if(status == true)
         {
             System.out.println("el valor si se encuentra en el arbol");
//Si despues de recorrer toda la cola, status termina siendo verdadero y se le avisa al usuario de que se encuentra        
         }
         else 
                System.out.println("el valor no se encuentra");
    // en caco conntrario se le avisa al usarui de que ni se encuentra
            } 
        
        
    
        }
}