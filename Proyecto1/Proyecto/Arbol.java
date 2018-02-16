/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arbol;

/**
 *
 * @author Mi pc
 */
public class Arbol {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
Nodo raiz = new Nodo("+");
       Nodo nodo2 = new Nodo("+");
       Nodo nodo3 = new Nodo("/");
       Nodo nodo4 = new Nodo("*");
       
       raiz.setNodoIzquierdo(new Nodo("3"));
       raiz.setNodoDerecho(nodo2);
       nodo2.setNodoDerecho(new Nodo("e"));
       nodo2.setNodoIzquierdo(nodo3);
       nodo3.setNodoDerecho(new Nodo("2"));
       nodo3.setNodoIzquierdo(nodo4);
       nodo4.setNodoIzquierdo(new Nodo("8"));
       nodo4.setNodoDerecho(new Nodo("5"));
       
        System.out.println("Preorden");
        preOrden(raiz);
        System.out.println("");
        System.out.println("PostOrden");
        postOrden(raiz);
        System.out.println("");
        System.out.println("inOrden");
        inOrden(raiz);
        System.out.println("");
    }
    
    private static void preOrden(Nodo raiz){
        if(raiz != null){
            System.out.print(raiz.getDato());
            preOrden(raiz.getNodoIzquierdo());
            preOrden(raiz.getNodoDerecho());
        }
    }
    
    private static void postOrden(Nodo raiz){
        if(raiz != null){
            postOrden(raiz.getNodoIzquierdo());
            postOrden(raiz.getNodoDerecho());
            System.out.print(raiz.getDato());
        }
    }
    
       private static void inOrden(Nodo raiz){
        if(raiz != null){
            inOrden(raiz.getNodoIzquierdo());
            System.out.print(raiz.getDato());
            inOrden(raiz.getNodoDerecho());
        }
    }
    }
    

