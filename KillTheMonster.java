import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.StringTokenizer;

public class KillTheMonster {
    public static void main(String[] args){
        FastScaner fs = new FastScaner();
        int t = fs.nextInt();
        for(long tt=0;tt<t;tt++){
            long healthOne = fs.nextLong(), attackOne = fs.nextLong();
            long healthTwo = fs.nextLong(), attackTwo = fs.nextLong();
            long k = fs.nextLong(), w = fs.nextLong(), a = fs.nextLong();
            int ans = 0;
            for(long i=0;i<=k;i++){
                long healthThree = healthOne + (i * a);
                long attackThree = attackOne + (w * (  k- i));
                long x = 0, y = 0;
                x = (healthTwo / attackThree);
                if(healthTwo % attackThree != 0)x++;
                y = healthThree / attackTwo;
                if(healthThree % attackTwo != 0)y++;
                if(x <= y){
                    ans = 1;break;
                }
            }
            if(ans == 1){
                System.out.println("YES");
            }
            else{
                System.out.println("NO");
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
