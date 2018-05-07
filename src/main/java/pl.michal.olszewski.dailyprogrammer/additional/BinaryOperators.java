package pl.michal.olszewski.dailyprogrammer.additional;

public class BinaryOperators {

  public static void main(String[] args) {
    int a = 15; //0000 1111
    int b = 20; //0001 0100

    System.out.println("a & b = " + (a & b));   //0000 1000
    System.out.println("a | b = " + (a | b));   //0001 1111

    // XOR
    // 0 ^ 0 = 0
    // 0 ^ 1 = 1
    // 1 ^ 0 = 1
    // 1 ^ 1 = 0
    System.out.println("a ^ b = " + (a ^ b));   //0001 1011
    System.out.println("~a = " + ~a); // 11111111111111111111111111110000
    System.out.println("a << 2 = " + (a << 2)); //0011 1100
    System.out.println("b >> 2 = " + (b >> 2));   //0000 0101


  }

}
