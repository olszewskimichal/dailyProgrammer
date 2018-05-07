package pl.michal.olszewski.dailyprogrammer.additional;


import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Set;
import java.util.TreeSet;

public class BigDecimalSets {

  private static BigDecimal first = BigDecimal.ONE;
  private static BigDecimal second = new BigDecimal("1.0");
  private static BigDecimal third = new BigDecimal("1.00");
  private static BigDecimal fourth = BigDecimal.TEN.divide(BigDecimal.TEN);
  private static BigDecimal fifth = BigDecimal.TEN.divide(new BigDecimal("10.000000"));

  public static void main(String[] args) {
    Set<BigDecimal> treeSet = new TreeSet<>();
    treeSet.add(first);
    treeSet.add(second);
    treeSet.add(third);
    treeSet.add(fourth);
    treeSet.add(fifth);

    System.out.println(treeSet);

    Set<BigDecimal> hashSet = new HashSet<>();
    hashSet.add(first);
    hashSet.add(second);
    hashSet.add(third);
    hashSet.add(fourth);
    hashSet.add(fifth);

    System.out.println(hashSet);

    Set<BigDecimal> identityHashSet = Collections.newSetFromMap(new IdentityHashMap<>());
    identityHashSet.add(first);
    identityHashSet.add(second);
    identityHashSet.add(third);
    identityHashSet.add(fourth);
    identityHashSet.add(fifth);

    System.out.println(identityHashSet);

    System.out.println(treeSet.size() + hashSet.size() + ":" + identityHashSet.size());
  }

}
