//not all import are used to solve every problem .. but these are the most important one

import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class MakeAP {
    @SuppressWarnings("FieldCanBeLocal")
    private static Reader in;
    private static PrintWriter out;

    private static void solve() throws IOException{
        //Your Code Goes Here;
        int a = in.nextInt(), b = in.nextInt(), c = in.nextInt();
        int m = -1;
        if((2*b-c)%a == 0 && (2*b-c)>0)m = (2*b-c)/a;
        else if((a+c)%(2*b) == 0) m = (a+c)/(2*b);
        else if((2*b-a)%c == 0 && (2*b-a)>0) m = (2*b-a)/c;

        if(m == -1) System.out.println("NO");
        else System.out.println("YES");
    }
    public static void main(String[] args) throws IOException {
        //FastScaner fs = new FastScaner();//There is a class below .. uncomment that class to instantiate an object from that class;
        //int t = fs.nextInt();//uncomment this line when you're using the fastscaner class;
        in = new Reader();
        out = new PrintWriter(new OutputStreamWriter(System.out));
        int T = in.nextInt();
        for(int tt=0;tt<T;tt++){
            solve();
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
    private static void sort(int[] a){
        ArrayList<Integer> l = new ArrayList<>();
        for(int i:a) l.add(i);
        Collections.sort(l);
        for(int i=0;i<a.length;i++)a[i] = l.get(i);
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



    /*--------------------------------------------------------------------------------------------*/
    /*private static class FastScaner{
        //This class can alse be used for Fast I/O;
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
        public String readLine() throws IOException {
            final byte[] buf = new byte[1024]; // line length
            int cnt = 0, c;
            while ((c = Integer.parseInt(next())) != -1) {
                if (c == '\n') {
                    break;
                }
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }
        private static boolean isSpaceChar(int c) {
            return !(c >= 33 && c <= 126);
        }
        public int skip() throws IOException {
            int b;
            // noinspection ALL
            while ((b = Integer.parseInt(next())) != -1 && isSpaceChar(b)) {
                ;
            }
            return b;
        }
        public char nc() throws IOException {
            return (char) skip();
        }
    }*/
}
