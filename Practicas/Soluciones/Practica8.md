## Ejercicio 1
| Algoritmo | Complejidad |
|----------|----------|
| Selection Sort | n^2 |
| Insertion Sort | n^2 |
| Merge Sort | n log n |
| Quick Sort | n log n |
| HeapSort | n log n |

en la practica damos RadixSort, CountingSort y BucketSort, pero para este ejecicio no se los tiene en cuenta.

## Ejercicio 2
En el caso en cual s'' sea mas chico que s' utilizaria InsertionSort, ya que cuando un arreglo tiene la mayoria de sus elementos ya ordenados, ordenarlo con insertionSort nos da una complejidad O(n).
En el caso contrario utilizaria merge sort (el cual nos da una complejidad O(n log n)).
## Ejercicio 3
```
proc kMasChicos(in a : array[int], in k : int) : array[int]{
    res = new array[k]
    i = 0
    while(i < k){ //O(k)
        j = 0; // O(1)
        min = A[i]
        while (j < n) { O(n)
            if( a[j] < min) do min = a[j] else skip endif
            j++
            }
        res[i] = min
        i++
}
```
la complejidad de mi codigo es de O(nk). Sería ventajoso ordenar el array primero en el caso que k = n, pues si esto pasa la complejidad seria O(n^2). Entonces si ordenamos el array primero, con merge sort por ejemplo, la complejidad nos quedaria O(n log n).
## Ejercicio 5
El ejercicio pide ordenar el arreglo por frecuencia, y en caso de empate por valor.
En primer lugar deberia guardar en alguna estructura el valor y las frecuencias de los elementos. Despues ordenar esta estructura en funcion del valor, asi en el caso de que haya empate de frecuencias, el arrego este ordenado por valor. Luego, ordeno el arreglo en funcion de las frecuencias y por ultimo reconstruyo el array A ordenado. 
[1, 3, 1, 7, 2, 7, 1, 7, 3] -> [<1,3>, <2,1>, <3,2>, <7,3>] -> [<1,3>, <7,3>, <3,2>, <2,1>] ->  [1, 1, 1, 7, 7, 7, 3, 3, 2]
```
proc ordenFrecuencia (inout A : array[int]){
    frec = DictLogVacio()
    i = 0
    repeticiones = 0
    while (i < A.lenght){ // O(n)
        if (frec.esta(A[i])) then //O(d log d) siendo d la cantidad de elementos del dict
            frec.definir(A[i], frec.obtener(A[i] ++)) 
            repeticiones ++
        else
            frec.definir(A[i], 1)
    }
    tuplas = new array[tupla<int, int>] // es un array de largo A.length - repeticiones
    it = iterador()
    i = 0
    while(it.haySiguiente){
        elem = siguiente
        reps = frec.obtener(Sigiente)
        tuplas[i] = <elem, reps>
        i++
    }
    //mergeSortElem ordena las tuplas utilizando mergeSort comparando con el valor del primer elemento de la tupla
    // mergeSortRep ordena las tuplas utilizando mergeSort comparando con el valor del segundo elemento de la tupla
    // asumo que estos algoritmos de merge sort estan implementados de manera estable.
    tuplas.mergeSortElem // O(d log d) 
    tuplas.mergeSortRep  // O(d log d)
    i = 0
    j = 0
    while (i < A.length){
        if tuplas[j][1] > 0 then
            A[i] = tuplas[j][0]
            i++
            tuplas[j][1] = tuplas[j][1] - 1
        else
            j++
    }
    return A

}
```
## Ejercicio 6
mi idea fue hacer una lista de tuplas<lista, int> la cual cuarde la escalera y su longitud. despues debo ordenar esta lista por los primeros elementos de las escalerass y despues por sus longitudes.
```
proc ordenarEscaleras(inout A: arreglo(int)){
    escaleras : ListaEnlazada(tupla<listaEnlazada, int>)
    escaleras = listaVacia // O(1)
    i = 0
    escActual = listaVacia
    longitud = 0
    while (i < A.length){ // O(n)
        if (A[i] = A[i + 1] + 1) then
            escActual.agregarAtras(A[i])
            longitud ++
        else
            // agrega el elem q falta
            escActual.agregarAtras(A[i])
            longitud ++
            escaleras.agregarAtras(<escActual, longitud>)
            longitud = 0
            escActual = ListaVacia
        i++}
    escaleras.MergeSortAux // O(n log n) // este merge sort ordena primero por longitud y en segundo lugar por primer elemento de la lista de la tupla.
    it = escaleras.iterador
    i = 0
    // ahora reescribimos A con los valores de la lista 
    while(it.haysiguiente){ // o(n)
        elem = siguiente()
        lista = elem[0]
        itL = lista.iterador
        while(itL.haysiguiente) {
            num = itL.siguiente
            A[i] = num
            i++
        }
    }
    return A   
}
```
La complejidad de mi algoritmo seria de O(n log n)
### Ejercicio 9
```
planilla es un arreglo(alumnos)
alumno es tupla⟨nombre: string, género: GEN, puntaje: Nota⟩ donde GEN es enum{masc, fem} y Nota es un nat no mayor que 10.
proc ordenaPlanilla(inout p: planilla){
    p.radixSortNotas // o(2(n + 10)) = o(2n+20) = o(n) ordena el arreglo en funcion de las notas
    p.radixSortGen // o(1(n + 2)) = o(n) ordena el arreglo en funcion al genero
    return A
}
```
### Ejercicio 11
para resolver este ejercicio podemos utilizar el arlgoritmo counting sort ya que los elementos del arreglo A estan acotados por un rango 
```
proc countingSort(in A:arreglo(int), in k : int){
    count : arreglo(int)
    count = new array(k) /O(k)
    for(int i = 1, i <= A.length, i++){ // o(k)
        count[i] = count[i] + 1
    }
    // reconstruimos el arreglo
    i = 1
    j = 1
    while (i <= count.length){ // O(k * count[i]) = O(k + n)
        m = 0
        while(m < count[i]){ // o(count[i]), como mucho count[i] puede ser n pero este se ejecutaria solamente 1 vez, haciendo que se sumen las complejidades. 
            a[j] = count[i]
            j++
            m++
        }
    }
}
```
en conclusion, la complejidad seria O(k + n) pero como k es una constante, la complejidad seria O(n)

### Ejercicio 13
1)Mi idea para resolver este ejercicio fue en primer lugar ordenar el arreglo por la primera componente utilizando un algoritmo de sorting estable como merge sort para asi conseguir una complejidad n log n  y por ultimo utilizar radix sort para ordenar el arrego por la segunda componente lo cual daria O( l * (n + 26)) = O(l*n)
```
proc ordenarletras(in A: arregloTupla){
    A.mergeSortInt // O(n log n), este algoritmo de merge sort ordena a las tuplas A por la primer componente
    A.radixSortString // O(ln) este algoritmo utiliza radix sort para ordenar las tuplas por la segunda componente
    return a 
}
```
la complejidad de mi algoritmo seria de O(nl + n log n)
2) en el caso en el cual losnaturales de la primer componente esten acotados en vez de usar merge sort podria utilizar counting Sort, lo cual la complejidad me quedaria en O(nl + (n+k)) pero como k seria una constante O(nl + n) = O(nl)



