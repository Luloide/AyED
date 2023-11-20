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
