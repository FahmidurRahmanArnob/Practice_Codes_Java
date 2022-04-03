import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.Vector;

public class RoofConstruction {
    public static void main(String[] args){
        FastScaner fs = new FastScaner();
        int T = fs.nextInt();
        for(int tt=0;tt<T;tt++){
            int n = fs.nextInt();
            Vector<Integer> p = new Vector<>();
            boolean isAdded = false;//here isAdded represents whether 0 is added to the permutation or not!
            for(int i=n-1;i>=1;i--){
                p.add(i);
                if (Integer.bitCount(i) == 1 && !isAdded){
                    //Integer.bitCount(i) == 1 ==> This line check whether i is a power of two or not!
                    p.add(0);
                    isAdded = true;
                }
            }
            for(var it : p){//'var' is the equivalent of the c++ 'auto' keyword;
                System.out.print(it + " ");
            }
            System.out.println();
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
