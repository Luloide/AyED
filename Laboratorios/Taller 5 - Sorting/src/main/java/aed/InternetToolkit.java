package aed;

public class InternetToolkit {
    public InternetToolkit() {
    }

    public Fragment[] tcpReorder(Fragment[] fragments) {
        // como los elementos vienen la mayoria ordenados y los que no estan en posiciones cercanas 
        // voy a implementar insertionSort ya que en estos casos tiene una complejidad de 0(n)
        int n = fragments.length;
        for (int i = 1; i < n; ++i) {
            Fragment key = fragments[i];
            int j = i - 1;

            
            while (j >= 0 && fragments[j].compareTo(key) == 1) {
                fragments[j + 1] = fragments[j];
                j = j - 1;
            }
            fragments[j + 1] = key;
        }
        return fragments;
    }

    public Router[] kTopRouters(Router[] routers, int k, int umbral) {
        // En primer lugar recorro todo el arreglo de routers, buscando los routers que 
        // pasan el umbral y los agrego a mi arreglo res, despues lo ordeo usando merge sort.
        Router[] res = new Router[k];
    int umbralcounter = 0;
    for (int i = 0; i < routers.length; i++) { // O(n)
        if (routers[i].getTrafico() > umbral) {
            umbralcounter++;
        }
    }
    int j = 0;
    Router[] pasanUmbral = new Router[umbralcounter];
    for(int i = 0 ; i < routers.length && j !=umbralcounter; i++){ // O(n)
        if (routers[i].getTrafico() > umbral) {
            pasanUmbral[j] = routers[i];
            j++;
        }
    }
    MergeSort.mergeSort(pasanUmbral, 0, pasanUmbral.length - 1);// O(k log k)
    int i = 0;
    if (umbralcounter == 0){// O(1)
        return res;
    } else {
        while(i<k){ // O(k)
        res[i] = pasanUmbral[i];
        i++;
    }
    }
    return res; // O(1)

    // la complejidad me dio O(n) + O(k log k) + O(k) = O(n + k log k) lo cual cumple con
    // O(n + k log n)
    }

    public IPv4Address[] sortIPv4(String[] ipv4) {

        int n = ipv4.length;
        IPv4Address[] res = new IPv4Address[n];
        for (int i = 0; i<n;i++){
            res[i] = new IPv4Address(ipv4[i]);
        }

        // ordeno primero por el octeto menos significativo al mas significativo.
        InsertionSortIpv4.InsertionSortDecrecienteIPv4(res, 3);
        InsertionSortIpv4.InsertionSortDecrecienteIPv4(res, 2);
        InsertionSortIpv4.InsertionSortDecrecienteIPv4(res, 1);
        InsertionSortIpv4.InsertionSortDecrecienteIPv4(res, 0);
        return res;
    }

}
