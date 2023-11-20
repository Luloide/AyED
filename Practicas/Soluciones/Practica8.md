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
## Ejercicio 4
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
