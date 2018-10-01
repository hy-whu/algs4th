package bitonicSearch_in_2lgn;

//still syspicious about this algs

public class bitonic {



    private static int seachLeft(int key,int[] a, int lo, int hi){
        int mid = 0;
        while(lo <= hi){//遍历左侧增长序列
            mid = lo + (hi-lo)/2;
            if(key > a[mid]) lo = mid +1;
            else if(key < a[mid]) hi = mid -1;
            else return mid;
        }
        return -1;
    }
    private static int searchRight(int key, int[] a, int lo, int hi){
        int mid = 0;
        while(lo <= hi){
            mid = lo + (hi-lo)/2;
            if(key > a[mid]) hi = mid -1;
            else if(key < a[mid]) lo = mid +1;
            else return mid;
        }
        return -1;
    }

    public static int bitonic(int key, int[] a) {
        int lo = 0;
        int hi = a.length - 1;
        int mid = 0;
        int findValue = -1;
        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            if (a[mid] == key) return mid;
            else if (a[mid] > key) {
                if (a[mid] > a[mid + 1] && a[mid] > a[mid - 1]) {
                    findValue = seachLeft(key, a, 0, mid - 1);
                    if (findValue != -1) return findValue;
                    else return searchRight(key, a, mid + 1, a.length - 1);
                } else if (a[mid] > a[mid + 1] && a[mid] < a[mid - 1]) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            } else {//说明key值可能在a[mid]的两边
                findValue = seachLeft(key, a, 0, mid - 1);
                if (findValue != -1) return findValue;
                else return searchRight(key, a, mid + 1, a.length - 1);
            }
        }
        return -1;
    }
}
