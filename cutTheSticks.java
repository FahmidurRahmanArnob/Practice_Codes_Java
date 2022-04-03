import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.Scanner;
import java.util.StringTokenizer;

public class cutTheSticks {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int count = input.nextInt();
        int[] sticks = new int[count];
        int in = 0;
        while(in < count) {
            sticks[in] = input.nextInt();
            in++;
        }
        while(true) {
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < count; i++) {
                if (sticks[i] < min && sticks[i] != 0) {
                    min = sticks[i];
                }
            }
            // System.out.println("Min is " + min);
            int slices = 0;
            for (int i = 0; i < count; i++)  {
                if (sticks[i] > 0) {
                    int temp = sticks[i];
                    sticks[i] = temp - min;
                    // System.out.println("loc " + i + ": " + temp + " to " + sticks[i]);
                    slices++;
                }

            }
            if (slices > 0)
                System.out.printf("%d%n", slices);
            else
                break;
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
