import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.StringTokenizer;

public class FunWithEvenSubarrays {
    public static void main(String[] args){
        FastScaner fs = new FastScaner();
        int T = fs.nextInt();
        while(T-->0){
            int n = fs.nextInt();
            int[] arr = new int[n + 3];
            for(int i=0;i<n;i++)arr[i] = fs.nextInt();
            int count = 1;
            int i ;
            int z = arr[n - 1];
            for(i=n-2;i>=0;i--){
                if(arr[i] == arr[i + 1]){
                    count++;
                }
                else{
                    break;
                }
            }
            int ans = 0;
            while(i >=0){
                ans++;
                i -= count;
                count*=2;
                while(i >= 0 && arr[i] == z){
                    i--;count++;
                }
            }
            System.out.println(ans);
        }
    }
    static final Random random = new Random();
    static final int mod = 1_000_000_007;
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
