package aed;

import java.util.*;

// Todos los tipos de datos "Comparables" tienen el método compareTo()
// elem1.compareTo(elem2) devuelve un entero. Si es mayor a 0, entonces elem1 > elem2
public class ABB<T extends Comparable<T>> implements Conjunto<T> {
    // Agregar atributos privados del Conjunto
    private Nodo raiz;
    private int _cardinal;
    private Nodo Nodoactualper;
    Nodo Nodopadre;
    private class Nodo {
        // Agregar atributos privados del Nodo
        T valor;
        Nodo izq;
        Nodo der;
        Nodo padre;
        // Crear Constructor del nodo
        Nodo(T v){
            valor = v;
            izq = null;
            der = null;
            padre = null;
        }
    }

    public ABB() {
        raiz = null;
        _cardinal = 0;
    }

    public int cardinal() {
        return _cardinal;
    }

    public T minimo(){
        Nodo nodoActual = raiz;
        while (nodoActual.izq != null){
            nodoActual = nodoActual.izq;
        }
        return nodoActual.valor;
    }

    public T maximo(){
        Nodo nodoActual = raiz;
        while (nodoActual.der != null){
            nodoActual = nodoActual.der;
        }
        return nodoActual.valor;
    }
    public void insertar(T elem){
        if (raiz == null){
            raiz = new Nodo(elem);
            raiz.padre = null;
            _cardinal ++;
        } 
        else if (pertenece(elem) == false){
            Nodo npadre = raiz;
            // buscamos al padre del nuevo nodo
            while(elem.compareTo(npadre.valor) != 0){
                if (npadre.izq == null && npadre.der == null){
                    break;
                }
                else if (npadre.izq == null && elem.compareTo(npadre.valor) < 0){
                    break;
                } else if (npadre.der == null && elem.compareTo(npadre.valor) > 0){
                    break;}
                else {
                    if (elem.compareTo(npadre.valor) > 0){
                        npadre = npadre.der;
                    } else {
                        npadre = npadre.izq;
                            }
                    }
                }
            // una vez encontrado al padre, insertamos el nodo
            Nodo nuevoNodo = new Nodo(elem);
            nuevoNodo.padre = npadre;
            if (elem.compareTo(npadre.valor) < 0){
                npadre.izq = nuevoNodo;
            } else {
                npadre.der = nuevoNodo;
            }
        _cardinal ++;}
        }

    public boolean pertenece(T elem){
        Nodoactualper = raiz;
        boolean p = false;
        if (Nodoactualper == null){
            return false;}
        else if (elem.compareTo(raiz.valor) == 0){
            return true;
        }
        else {
        while (Nodoactualper != null){
            if (elem.compareTo(Nodoactualper.valor) == 0){
                p = true;
                break;
        } else {
            if (elem.compareTo(Nodoactualper.valor) > 0){
                Nodoactualper = Nodoactualper.der;
            } else {
                Nodoactualper = Nodoactualper.izq;
            }
        }}}
        return p;
    }

    public void eliminar(T elem){
        // primero nos fijamos si el elem pertenece
        if (pertenece(elem) == true){
            Nodo nact = raiz;
            // buscamos el nodo a borrar
            while (elem.compareTo(nact.valor) != 0){
                if (elem.compareTo(nact.valor) > 0){
                    nact = nact.der;
            } else {
                nact = nact.izq;
            }
        }

        // caso 1: el elemento no tiene hijos
        Nodo aborrar = nact;
            // si es la raiz
        if(nact == raiz && (nact.izq == null && nact.der == null)){
            raiz = null;
            nact.padre = null;

        }
            // si no es la raiz
        else if (nact.izq == null && nact.der == null){
            Nodo padre = nact.padre;
            if (padre.izq == aborrar){
                padre.izq = null;
                aborrar.padre = null;
            } 
            if(padre.der == aborrar) {
                padre.der = null;
                aborrar.padre = null;
            }
        }


        // caso 2: el elemento tiene solo un hijo
        // tiene hijo derecho
        else if (nact.izq == null && nact.der != null){
            Nodo hijo = nact.der;
            Nodo padre = nact.padre;
            // si este elem es la raiz
            if (nact.valor.compareTo(raiz.valor) == 0){
                raiz = nact.der;
                raiz.padre = null;
            }
            // si el elemento no es la raiz
            else if (padre.izq == aborrar){
                padre.izq = hijo;
                hijo.padre = padre;
                nact.padre = null;
                nact.der = null;
            }
            else if (padre.der == aborrar){
                padre.der = hijo;
                hijo.padre = padre;
                nact.padre = null;
                nact.der = null;
            }
        } 
        // tiene hijo izquierdo
        else if (nact.izq != null && nact.der == null){
            // si el nodo a eliminar es la raiz 
            Nodo hijo = nact.izq;
            Nodo padre = nact.padre;
            if (nact.valor.compareTo(raiz.valor) == 0){
                raiz = hijo;
                raiz.padre = null;
            }
            else if (nact.padre.izq == aborrar){
                padre.izq = hijo;
                hijo.padre = padre;
                nact.padre = null;
                nact.der = null;
            } else if (nact.padre.der == aborrar){
                padre.der = hijo;
                hijo.padre = padre;
                nact.padre = null;
                nact.der = null;
            }}
        // caso 3: el elemento tiene 2 hijos
        else if (nact.izq != null && nact.der != null){
            // buscamos su sucesor
            Nodo sucesor = nact.der;
            while (sucesor.izq != null){
                sucesor = sucesor.izq;
            }
            Nodo padreDelSucesor = sucesor.padre;
            // cambiamos el valor del nodo a eliminar por el del sucesor
            nact.valor = sucesor.valor;
            // el sucesor no tiene hijos 
            if (sucesor.der == null && sucesor.izq == null){
                sucesor.padre = null;
            }
            // si el sucesor tiene un hijo:
            // tiene hijo izquierdo
            else if (sucesor.izq != null && sucesor.der == null){
                Nodo hijo = sucesor.izq;
                if (padreDelSucesor.izq == sucesor){
                    padreDelSucesor.izq = hijo;
                    hijo.padre = padreDelSucesor;
                    sucesor.padre = null;
                    sucesor.der = null;
                } else  if ((padreDelSucesor.der == sucesor)){
                    padreDelSucesor.der = hijo;
                    hijo.padre = padreDelSucesor;
                    sucesor.padre = null;
                    sucesor.izq = null; 
                }
                // tiene hijo derecho
            } else if (sucesor.der != null && sucesor.izq == null){
                Nodo hijo = sucesor.der;
                if (padreDelSucesor.izq == sucesor){
                    padreDelSucesor.izq = hijo;
                    hijo.padre = padreDelSucesor;
                    sucesor.padre = null;
                    sucesor.der = null; 
                } else {
                    padreDelSucesor.der = hijo;
                    hijo.padre = padreDelSucesor;
                    sucesor.padre = null;
                    sucesor.izq = null;
                }
            }
            // terminamos de eliminar al sucesor 
            if (padreDelSucesor.der == sucesor){
                padreDelSucesor.der = null;
            } else if (padreDelSucesor.izq == sucesor){
                padreDelSucesor.izq = null;
            }
        }
        _cardinal --;
        }
    }

    public String toString(){
        String s = "{";
        Nodo nact = raiz;
        boolean pasamosMin = false;
        // primero buscamos el minimo
        while (nact.izq != null){
            nact = nact.izq;
        }
        while(nact.valor != maximo()){
            if(nact.valor == minimo() && pasamosMin == false){
            s = s.concat(minimo().toString() + ",");
            pasamosMin = true;
            }
            else if (nact.valor == minimo() && pasamosMin == true){
                if (nact.izq != null){
                    while(nact.der != null){
                        nact = nact.der;
                        s = s.concat(nact.valor.toString()+ ",");
                    }
                } else {
                    Nodo tmp = nact;
                    nact = nact.padre;
                    while(tmp.valor.compareTo(nact.valor) > 0){
                        nact = nact.padre;
                    }
                    s = s.concat(nact.valor.toString()+ ",");
                }

            }
            else if(nact == raiz){
                nact = nact.der;
                while (nact.izq != null){
                    nact = nact.izq;
                }
                if(nact.valor == maximo()){
                        s = s.concat(nact.valor.toString()+ "}");
                    } else {
                        s = s.concat(nact.valor.toString()+ ",");
                }
            }
            else {
                // si hay subArbol a la izquierda del actual
                if (nact.izq != null){
                    nact = nact.der;
                    while(nact.izq != null){
                        nact = nact.izq;
                    }
                    if(maximo().compareTo(nact.valor) == 0){
                        s = s.concat(nact.valor.toString()+ "}");
                    } else {
                        s = s.concat(nact.valor.toString()+ ",");
                }}
                else {
                    Nodo tmp = nact;
                    nact = nact.padre;
                    while(tmp.valor.compareTo(nact.valor) > 0){
                        nact = nact.padre;
                    }
                    s = s.concat(nact.valor.toString()+ ",");
                }
                }
        }
        return s;
    }

    private class ABB_Iterador implements Iterador<T> {
        private Nodo _actual;
        private boolean pasamosMin;
        ABB_Iterador(){
            _actual = raiz;
            pasamosMin = false;
            while(_actual.izq != null){
                _actual = _actual.izq;
            }
        }
        public boolean haySiguiente() {            
            if (_actual == maximo()){
                return true;
            } else {
                return false;
            }
        }
    
        public T siguiente() {
            // casos particulares
            if(_actual.valor == minimo() && pasamosMin == false){
                pasamosMin = true;
                return minimo();
            }
            else if (_actual.valor == minimo()){
                if (_actual.izq != null){
                    while(_actual.der != null){
                        _actual = _actual.der;
                    }
                } else {
                    Nodo tmp = _actual;
                    _actual = _actual.padre;
                    while(tmp.valor.compareTo(_actual.valor) > 0){
                        _actual = _actual.padre;
                    }
                }
                return _actual.valor;
            }
            // en general..
            else if(_actual == raiz){
                _actual = _actual.der;
                while (_actual.izq != null){
                    _actual = _actual.izq;
                }
                return _actual.valor;
            }
            else {
                // si hay subArbol a la izquierda del actual
                if (_actual.izq != null){
                    _actual = _actual.der;
                    while(_actual.izq != null){
                        _actual = _actual.izq;
                    }}
                else {
                    Nodo tmp = _actual;
                    _actual = _actual.padre;
                    while(tmp.valor.compareTo(_actual.valor) > 0){
                        _actual = _actual.padre;
                    }
                }
                return _actual.valor;
                }
            }
    }

    public Iterador<T> iterador() {
        return new ABB_Iterador();
    }

}
