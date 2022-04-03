import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class MinorReduction {
    public static void main(String[] args) throws StringIndexOutOfBoundsException{
        FastScaner fs = new FastScaner();
        int T = fs.nextInt();
        long n, i, j, k1, k2, f, k;
        char[] s;
        for(int tt=0;tt<T;tt++){
            s = fs.next().toCharArray();
            n = s.length;
            k1=k2=-1;
            f=0;
            for(i=(int)n-2;i>=0;i--){
                k1 = s[(int) i] - 48;
                k2 = s[(int) (i+1)] - 48;
                if(k1 + k2 >= 10){
                    f++;
                    k = k1 + k2;
                    //s[(random.nextInt((int) (i + 1)))] = (char) ((k % 10) + 48);
                    s[(int) i + 1] = (char) ((k % 10) + 48);
                    k = k / 10;
                    s[(int) i] = (char) (k + 48);
                    break;
                }
            }
            if(f > 0){
                System.out.print(s);
                System.out.println();
                continue;
            }
            System.out.print((s[0] - 48 + s[1] - 48));
            for(i = 2; i<n; i++){
                System.out.print(s[(int) i]);
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
        sort(a);
    }
    static long add(long a, long b){
        return (a + b) %  mod;
    }
    static void sort(int[] a){
        ArrayList<Integer> l = new ArrayList<>();
        for(int i:a) l.add(i);
        Collections.sort(l);
        for(int i=0;i<a.length;i++)a[i] = l.get(i);
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
        public long[] readLongArray(long n){
            long[] a = new long[(int) n];
            for(int i=0;i<n;i++){
                a[i] = nextLong();
            }
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
