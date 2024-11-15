package datatype.String;

public class MathExample {

    public static void main(String[] args) {
        int a = -10;
        int x = 5;
        int y = 10;
        double z = 16;
        double b = 8;

        int absVal = Math.abs(a);
        System.out.println("absVal = " + absVal);

        int maxVal = Math.max(x, y);
        System.out.println("maxVal = " + maxVal);

        int minVal = Math.min(x, y);
        System.out.println("minVal = " + minVal);

        double powVal = Math.pow(y, 10);
        System.out.println("powVal = " + powVal);

        int iPowVal = (int) powVal;
        System.out.println("iPowVal = " + iPowVal);

        double sqrtVal1 = Math.sqrt(z);
        double sqrtVal2 = Math.sqrt(b);

        System.out.println("sqrtVal1 = " + sqrtVal1);
        System.out.println("sqrtVal2 = " + sqrtVal2);
    }
}
