public class Median {
    static int med3(int a, int b, int c){
        if(a >= b)
            if(b >= c)
                return b;
            else if(a <= c)
                return a;
            else 
                return c;
        else if(a > c)
            return a;
        else if(b > c)
            return c;
        else 
            return b;
    }
}
