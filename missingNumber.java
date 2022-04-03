import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

class missingNumber {
    @SuppressWarnings("FieldCanBeLocal")
    private static Reader in;
    private static PrintWriter out;

    public static void main(String[] args) throws IOException {
        //FastScaner fs = new FastScaner();//There is a class below .. uncomment that class to instantiate an object from that class;
        //int t = fs.nextInt();//uncomment this line when you're using the fastscaner class;
        in = new Reader();
        out = new PrintWriter(new OutputStreamWriter(System.out));
        int T = in.nextInt();
        while(T-->0){
            long arr[]=new long[4];
            //int i;
            for(int i=0;i<4;i++)arr[i]=in.nextLong();
            Arrays.sort(arr);
            double a1=(double)(arr[2]+arr[0])/2;
            double b1=arr[2]-a1;
            double a2=(double)(arr[2]+arr[1])/2;
            double b2=arr[2]-a2;
            double a3=(double)(arr[3]+arr[0])/2;
            double b3=arr[3]-a3;
            double a4=(double)(arr[3]+arr[1])/2;
            double b4=arr[3]-a4;
            int OneA = (int) (a1 % 1);
            int OneB = (int) (b1 % 1);
            boolean ok1 = a1 != 0, okPart1 = b1 != 0;
            if((OneA==0)&&ok1&&(OneB==0)&&okPart1)
            {
                int divide = (int) (a1/b1);
                int multi = (int) (a1 * b1);
                if(((int)divide==(double)arr[1])&&(multi==(double)arr[3])&&(a1>=1)&&(b1>=1)&&(a1<=10000)&&(b1<=10000))
                {
                    System.out.println((long)a1+" "+(long)b1);
                    continue;
                }
            }
            int TwoA = (int) (a2 % 1);
            int TwoB = (int) (b2 % 1);
            boolean ok2 = a2 != 0, okPart2 = b2 != 0;
            if((TwoA==0)&&ok2&&(TwoB==0)&&okPart2)
            {
                int divide = (int) (a2/b2);
                int multi = (int) (a2 * b2);
                if(((long)divide==(double)arr[0])&&(multi==(double)arr[3])&&(a2>=1)&&(b2>=1)&&(a2<=10000)&&(b2<=10000))
                {
                    System.out.println((long)a2+" "+(long)b2);
                    continue;
                }
            }
            int ThreeA = (int) (a3 % 1);
            int ThreeB = (int) (b3 % 1);
            boolean ok3 = a3 != 0, okPart3 = b3 != 0;
            if((ThreeA==0)&& ok3 &&(ThreeB==0)&&okPart3)
            {
                int divide = (int) (a3/b3);
                int multi = (int) ((int) a3 * b3);
                if(((long)divide==(double)arr[1])&&(multi==(double)arr[2])&&(a3>=1)&&(b3>=1)&&(a3<=10000)&&(b3<=10000))
                {
                    System.out.println((long)a3+" "+(long)b3);
                    continue;
                }
            }
            int fourA = (int) (a4 % 1);
            int fourB = (int) (b4 % 1);
            boolean ok4 = a4 != 0, okPart4 = b4 != 0;
            if((fourA==0)&&ok4&&(fourB==0)&&okPart4)
            {
                int divide = (int) (a4/b4);
                int multi = (int) (a4 * b4);
                if(((long)divide==(double)arr[0])&&(multi==(double)arr[2])&&(a4>=1)&&(b4>=1)&&(a4<=10000)&&(b4<=10000))
                {
                    System.out.println((long)a4+" "+(long)b4);
                    continue;
                }
            }
            System.out.println("-1 -1");
        }
        out.flush();
        in.close();
        out.close();
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
    private static void longRuffleSort(long[] a){
        long n = a.length;
        for(int i=0;i<n;i++){
            long oi = random.nextInt((int) n), temp = a[(int) oi];
            a[(int) oi] = a[i]; a[i] = temp;
        }
        longSort(a);
    }
    public static boolean primeFinder(int n){
        int m = 0;
        int flag = 0;
        m = n / 2;
        if(n == 0 ||n == 1){
            return false;
        }
        else{
            for(int i=2;i<=m;i++){
                if(n % i == 0){
                    return false;
                }
            }
            return true;
        }
    }
    private static boolean[] sieveOfEratosthenes(long n) {
        boolean prime[] = new boolean[(int)n + 1];
        for (int i = 0; i <= n; i++) {
            prime[i] = true;
        }
        for (long p = 2; p * p <= n; p++) {
            if (prime[(int)p] == true) {
                for (long i = p * p; i <= n; i += p)
                    prime[(int)i] = false;
            }
        }
        return prime;
    }
    private static int log2(int n){
        int result = (int) (Math.log(n) / Math.log(2));
        return result;
    }
    private static long add(long a, long b){
        return (a + b) %  mod;
    }
    private static int gcd(int a, int b) {
        if (a == 0 || b == 0)
            return 0;
        while (b != 0) {
            int tmp;
            tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }
    private static long lcm(long a, long b){
        return (a / gcd((int) a, (int) b) * b);
    }
    private static void sort(int[] a){
        ArrayList<Integer> l = new ArrayList<>();
        for(int i:a) l.add(i);
        Collections.sort(l);
        for(int i=0;i<a.length;i++)a[i] = l.get(i);
    }
    private static void longSort(long[] a){
        ArrayList<Long> l = new ArrayList<>();
        for(Long i : l) l.add((long) i);
        Collections.sort(l);
        for(int i=0;i<a.length;i++)a[i] = l.get(i);
    }
    public static int[][] prefixsum( int n , int m , int arr[][] ){
        int prefixsum[][] = new int[n+1][m+1];
        for( int i = 1 ;i <= n ;i++) {
            for( int j = 1 ; j<= m ; j++) {
                int toadd = 0;
                if( arr[i-1][j-1] == 1) {
                    toadd = 1;
                }
                prefixsum[i][j] = toadd + prefixsum[i][j-1] + prefixsum[i-1][j] - prefixsum[i-1][j-1];
            }
        }
        return prefixsum;
    }

    //call this method when you want to read an integer array;
    private static int[] readArray(int len) throws IOException{
        int[] a = new int[len];
        for(int i=0;i<len;i++)a[i] = in.nextInt();
        return a;
    }
    //call this method when you want to read an Long array;
    private static long[] readLongArray(int len) throws IOException{
        long[] a = new long[len];
        for(int i=0;i<len;i++) a[i] = in.nextLong();
        return a;
    }
    //call this method to print the integer array;
    private static void printArray(int[] array){
        for(int now : array) out.print(now);out.print(' ');out.close();
    }
    //call this method to print the long array;
    private static void printLongArray(long[] array){
        for(long now:array) out.print(now); out.print(' '); out.close();
    }


    /*Another way of Reading input...collected from a online blog
    from here => https://codeforces.com/contest/1625/submission/144334744;*/
    static class Reader {
        private static final int BUFFER_SIZE = 1 << 16;
        private final DataInputStream din;
        private final byte[] buffer;
        private int bufferPointer, bytesRead;

        Reader() {//Constructor;
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException {//To take user input for String values;
            final byte[] buf = new byte[1024]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n') {
                    break;
                }
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextSign() throws IOException {//For taking the signs like plus or minus ...
            byte c = read();
            while ('+' != c && '-' != c) {
                c = read();
            }
            return '+' == c ? 0 : 1;
        }

        private static boolean isSpaceChar(int c) {
            return !(c >= 33 && c <= 126);
        }

        public int skip() throws IOException {
            int b;
            // noinspection ALL
            while ((b = read()) != -1 && isSpaceChar(b)) {
                ;
            }
            return b;
        }

        public char nc() throws IOException {
            return (char) skip();
        }

        public String next() throws IOException {
            int b = skip();
            final StringBuilder sb = new StringBuilder();
            while (!isSpaceChar(b)) { // when nextLine, (isSpaceChar(b) && b != ' ')
                sb.appendCodePoint(b);
                b = read();
            }
            return sb.toString();
        }

        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ') {
                c = read();
            }
            final boolean neg = c == '-';
            if (neg) {
                c = read();
            }
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (neg) {
                return -ret;
            }
            return ret;
        }

        public long nextLong() throws IOException {
            long ret = 0;
            byte c = read();
            while (c <= ' ') {
                c = read();
            }
            final boolean neg = c == '-';
            if (neg) {
                c = read();
            }
            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');
            if (neg) {
                return -ret;
            }
            return ret;
        }

        public double nextDouble() throws IOException {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ') {
                c = read();
            }
            final boolean neg = c == '-';
            if (neg) {
                c = read();
            }

            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');

            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    ret += (c - '0') / (div *= 10);
                }
            }

            if (neg) {
                return -ret;
            }
            return ret;
        }

        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1) {
                buffer[0] = -1;
            }
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead) {
                fillBuffer();
            }
            return buffer[bufferPointer++];
        }

        public void close() throws IOException {
            din.close();
        }
    }
}