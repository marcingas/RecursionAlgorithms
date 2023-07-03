package simplearrayalgorithms;

public class MissingNumberInArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 5};
        int n = 5;
        findMissingNumberBrute(arr,n);//TC=O(NxN),SC=o(1);
        findMissingNumberBetterSol(arr,n);//TC=O(N+N),SC=O(1);
        findMissingNumberOptimal(arr,n);//TC=O(N),SC=O(1);

    }
public static void findMissingNumberBrute(int[]arr, int n){
        for(int i =1; i <=n; i++){
            int flag=0;
            for(int j=0;j<n-1;j++){
                if(arr[j]==i){
                    flag=1;
                    break;
                }
        }
            if(flag==0) System.out.println(i);
        }
}
public static void findMissingNumberBetterSol(int[]arr,int n){
        int[] hash = new int[n+1];
        for(int i=0; i<=n-1;i++){
            hash[arr[i]]++;
        }
        for(int i=1; i <=n; i++){
            if(hash[i]==0) System.out.println(i);
        }
}
    public static void findMissingNumberOptimal(int[] arr, int n) {
        int xor1 = 0;
        int xor2 = 0;
        for (int i = 0; i < n - 1; i++) {
            xor2 = xor2 ^ arr[i];
            xor1 = xor1 ^ (i + 1);
        }
        xor1 = xor1 ^ n;
        System.out.println(xor1 ^ xor2);

    }
}
