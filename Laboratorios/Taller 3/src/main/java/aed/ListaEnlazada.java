package aed;

import java.util.*;

public class ListaEnlazada<T> implements Secuencia<T> {
    private Nodo primero;
    private Nodo ultimo;

    private class Nodo {
        T valor;
        Nodo prev;
        Nodo sig;
        Nodo(T v){valor = v;}
    }

    public ListaEnlazada() {
        primero = null;
        ultimo = null;
    }

    public int longitud() {
        int len = 0;
        Nodo actual = primero;
        while(actual != null){
            len++;
            actual = actual.sig;
        }
        return len;
    }

    public void agregarAdelante(T elem) {
        Nodo nuevo = new Nodo(elem);
        //caso en el cual la lista este vacia
        if(primero == null && ultimo == null){
            primero = nuevo;
            ultimo = nuevo;
        } else{ // caso en el cual hay mas de un elemento
            primero.prev = nuevo;
            nuevo.sig = primero;
            primero = nuevo;
        }
    }

    public void agregarAtras(T elem) {
        Nodo nuevo = new Nodo(elem);
        if(primero == null && ultimo == null){
            primero = nuevo;
            ultimo = nuevo;
        } else{
            ultimo.sig = nuevo;
            nuevo.prev = ultimo;
            ultimo = nuevo;
        } 
    }

    public T obtener(int i) {
        int j = 0;
        Nodo act = primero;
        while (j != i){
            act = act.sig;
            j++;
        }
        return act.valor;

    }
    public void eliminar(int i) {
         // buscamos el nodo a eliminar
        int j = 0;
        Nodo act = primero;
        Nodo elAnterior;
        Nodo elSiguiente;
        while (j != i){
            act = act.sig;
            j++;
        }
        // si hay solo un elemento en la lista
        if(act.prev == null && act.sig == null){
            primero = null;
            ultimo = null;
        }
        //si elimino el primero
        else if(act.prev == null && act.sig != null){
            elSiguiente = act.sig;
            elSiguiente.prev = null;
            primero = elSiguiente;
            act.sig = null;
        }
        // si elimino el ultimo
        else if(act.sig == null){
            elAnterior = act.prev;
            elAnterior.sig = null;
            act.prev = null;
            ultimo = elAnterior;
        }
        // si elimino alguno entre medio 
        else{
            elAnterior = act.prev;
            elSiguiente = act.sig;
            elAnterior.sig = act.sig;
            elSiguiente.prev = act.prev;
            act.sig = null;
            act.prev = null;
        }
    }

    public void modificarPosicion(int indice, T elem) {
        // buscamos el elemeneto 
        int j = 0;
        Nodo act = primero;
        while (j<indice){
            act = act.sig;
            j++;
        }
        act.valor = elem;
    }

    public ListaEnlazada<T> copiar() {
        ListaEnlazada copia = new ListaEnlazada();
        Nodo act = primero;
        // si la lista ya esta vacia
        if (primero == null && ultimo == null){
            return copia;
        }
        // si hay un solo elemento
        if(primero == ultimo){
            copia.agregarAtras(act.valor);
        }
        else{
        while(act.sig != null){
            copia.agregarAtras(act.valor);
            act = act.sig;
            }
            copia.agregarAtras(ultimo.valor);
        }
        return copia;
    }

    public ListaEnlazada(ListaEnlazada<T> lista) {
        Nodo act = lista.primero;
        primero = null;
        ultimo = null;
        while(act.sig != null){
            this.agregarAtras(act.valor);
            act = act.sig;
            }
            this.agregarAtras(act.valor);
        }

    
    @Override
    public String toString() {
        String impimir = "[";
        Nodo act = primero;
        while(act.sig != null){
            impimir = impimir.concat(act.valor.toString());
            impimir = impimir.concat(", ");
            act = act.sig;
            }
            impimir = impimir.concat(act.valor.toString()) + "]";

        return impimir;
    }

    private class ListaIterador implements Iterador<T> {
    	// Completar atributos privados
        Nodo nodoActual;
        Nodo nodoAnterior;
        ListaIterador(){
            nodoAnterior = primero;
            nodoActual = primero;
        }

        public boolean haySiguiente() {
            //si la lista es vacia
            if(primero == null && ultimo == null){
                return false;
            }
            // si no
            else if(nodoActual == null && nodoAnterior.sig == null){
                return false;
            }else {
                return true;
            }
        }
        
        public boolean hayAnterior() {
            //si la lista es vacia
            if(primero == null && ultimo == null){
                return false;
            }
            else if (nodoActual == null){
                return true;
            } else if(nodoActual == primero){
                return false;
            } else{
                return true;
            }
        } 

        public T siguiente() {
            T valor = nodoActual.valor;
            nodoAnterior = nodoActual;
            nodoActual = nodoActual.sig;
            return valor;
        }
        

        public T anterior() {
            T valor;
            if(nodoActual == null) {
                valor = nodoAnterior.valor;
                nodoActual = nodoAnterior;
                nodoAnterior = nodoAnterior.prev;
            } else {
	            valor = nodoAnterior.valor;
                nodoActual = nodoAnterior;
                if(nodoAnterior == primero){
                nodoAnterior = primero;
                } else{
                    nodoAnterior = nodoAnterior.prev;
                }
            }
            return valor;
        }
    }

    public Iterador<T> iterador() {
	    return new ListaIterador();
    }


}
