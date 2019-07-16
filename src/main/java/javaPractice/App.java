package javaPractice;

/**
 * Hello world!
 *
 */
public class App 
{
    App(int a ){
        System.out.println(a);
    }

    static boolean bool;
    static byte by;
    static char ch;
    static double db;
    static float f;
    static int i;
    static long l;
    static short s;
    static String str;

    public static void main( String[] args )
    {

        System.out.println( "Hello World!" );
        Dog shan = new Dog("祁连山", 27, "yellow");
        shan.sayName();

        printStatic();
    }

    static void printStatic() {
        System.out.println("Bool: " + bool);
        System.out.println("Byte: " + by);
        System.out.println("Char: " + ch);
        System.out.println("Double: " + db);
        System.out.println("Float: " + f);
        System.out.println("Long: " + l);

        System.out.println("Short: " + s);
        System.out.println("String: " + str);
    }
}
