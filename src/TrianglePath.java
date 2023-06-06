public class TrianglePath {
    public static void main(String[] args) {
        int [][]arr = {{1},{2,3},{3,6,7}, {8,9,6,10}};
        int n = arr.length;
        int m = arr[0].length;
        System.out.println(findTrianglePath(0,0,arr));

    }
    public static int findTrianglePath(int i, int j, int [][]arr){
        if(i == arr.length-1) return arr[arr.length-1][j];
        int down = arr[i][j] + findTrianglePath(i+1,j,arr);
        int diagonal = arr[i][j] + findTrianglePath(i+1, j+1,arr);

        return Math.min(down,diagonal);
    }
}
