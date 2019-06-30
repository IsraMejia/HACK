/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica8.arboles;

/**
 *
 * @author israe
 */
public class Nodo {
    int valor;
    Nodo izq = null;
    Nodo der=null;
 /*Se crea la clase nodo que contiene como atributos a valor de tipo entero y a 
    izquierdo y derecho de tipo Nodo inicializados en nulo*/   
    
    public Nodo(){
 //metodo constructor de Nodo vacio
    }
    
    public Nodo(int data){
        this (data, null,null);
//Le asigna valor al nodo e inicializa sus hijos en nulo
    }
    
    public Nodo(int data, Nodo lt, Nodo rt){
        valor=data;
        izq=lt;
        der=rt;
    }
    
    public void setIzq(Nodo izq){
         this.izq=izq;
     }
     
     public void setDer(Nodo der){
         this.der=der;
     }
}
