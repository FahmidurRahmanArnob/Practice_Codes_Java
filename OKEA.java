import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.Vector;

public class OKEA {
    public static void main(String[] args){
        FastScaner fs = new FastScaner();
        int T = fs.nextInt();
        while(T --> 0){
            int n = fs.nextInt(), k = fs.nextInt();
            int x = n * k;
            if(k == 1){
                System.out.println("YES");
                for(int i=1;i<=n;i++) {
                    System.out.println(i);
                }
            }
            else{
                if(n % 2 == 1) System.out.println("NO");
                else{
                    System.out.println("YES");
                    int e = 2, o = 1;
                    for(int i=1;i<=n;i++){
                        if(i % 2 == 1){
                            for(int j=1;j<=k;j++){
                                System.out.print(o+" ");
                                o+=2;
                            }
                        }
                        else{
                            for(int j=1;j<=k;j++){
                                System.out.print(e + " ");
                                e+=2;
                            }
                        }
                        System.out.println();
                    }
                }
            }
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
