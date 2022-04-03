import java.util.*;
import java.lang.*;
import java.io.*;

public class Checking_Problem {
    public static void main(String[] args){
        int a = 16;
        int b = 3;
//        b += (++a);
        b += ++a;
        System.out.println(b);
    }
}
