package pl.michal.olszewski.dailyprogrammer.easy;

public class RegularPaperfoldSequence {

  public static void main(String[] args) {
    int i = 140;
    int trailing = Integer.numberOfTrailingZeros(i);    //10001100 has 2 trailing zeroes; on position 2, counting from 0 from the right, is also the least significant bit
    int leftOf = trailing + 1;    //
    int putBitOnPos1 = i >> leftOf;
    int complementOfNumber = ~putBitOnPos1;
    int checkOnlyFirstBit = complementOfNumber & 1;

    System.out.println(trailing + " " + leftOf + " " + putBitOnPos1 + " " + complementOfNumber + " " + checkOnlyFirstBit);

    System.out.print(checkOnlyFirstBit);
  }
}
