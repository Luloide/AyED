package aed;

public class InsertionSortIpv4 {
    public static void InsertionSortDecrecienteIPv4(IPv4Address[] arr, int o){
    int n = arr.length;

        for (int i = 1; i < n; ++i) {
            IPv4Address key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j].getOctet(o) > key.getOctet(o)) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }
}
