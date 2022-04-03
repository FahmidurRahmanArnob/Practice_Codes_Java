import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.spec.RSAOtherPrimeInfo;
import java.util.*;

/*
4
4
1 6 31 14
2
4 2
5
2 9 6 7 10
3
6 6 6
*/

public class OddSwapSort {
    public static void main(String[] args)throws RuntimeException{
        Scanner fs = new Scanner(System.in);
        int t = fs.nextInt();
        while(t --> 0){
            int n = fs.nextInt();
            boolean ans = true;
            int x = -1, y = -2, z;
            while(n-->0) {
                z = fs.nextInt();
                if (z % 2 == 0) {
                    if (z < y) {
                        ans = false;
                    }
                    y = z;
                }
                else {
                    if (z < x) {
                        ans = false;
                    }
                    x = z;
                }
            }
            if(ans){
                System.out.printf("Yes\n");
            }
            else{
                System.out.printf("No\n");
            }
        }
    }
    static final Random random = new Random();
    //Taken From "Second Thread"
    static void ruffleSort(int[] a){
        int n = a.length;//shuffles, then sort;
        for(int i=0; i<n; i++){
            int oi = random.nextInt(n), temp = a[oi];
            a[oi] = a[i]; a[i] = temp;
        }
    }
    static class FastScaner{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");
        public String next(){
            while(!st.hasMoreTokens()){
                try{
                    st = new StringTokenizer(br.readLine());
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        public int[] readArray(int n){
            int[] a = new int[n];
            for(int i=0; i<n; i++)a[i] = nextInt();
            return a;
        }
        public int nextInt(){
            return Integer.parseInt(next());
        }
        public long nextLong(){
            return Long.parseLong(next());
        }
        public double nextDouble(){
            return Double.parseDouble(next());
        }
        public float nextFloat(){
            return Float.parseFloat(next());
        }
    }
}
