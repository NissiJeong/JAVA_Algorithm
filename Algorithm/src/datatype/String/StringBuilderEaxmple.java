package datatype.String;

public class StringBuilderEaxmple {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("Hello");
        sb.append("!");
        sb.append("\n");
        sb.append("line breaker");

        System.out.println("sb.length() = " + sb.length());

        System.out.println("sb.substring(1) = " + sb.substring(1));
        System.out.println("sb.substring(1,5) = " + sb.substring(1, 5));

        System.out.println("sb.charAt(2) = " + sb.charAt(2));

        System.out.println("sb.reverse() = \n" + sb.reverse());
    }
}
