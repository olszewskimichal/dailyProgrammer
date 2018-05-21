package pl.michal.olszewski.dailyprogrammer.easy;

import java.util.Map;
import java.util.stream.Collectors;

public class TallyProgram {

  public static void main(String[] args) {
    calculate("EbAAdbBEaBaaBBdAccbeebaec")
        .entrySet().stream().sorted((v1, v2) -> Integer.compare(v2.getValue(), v2.getValue()))
        .forEach(System.out::println);
  }

  static Map<String, Integer> calculate(String input) {
    return input.chars().mapToObj(x -> (char) x)
        .collect(Collectors.groupingBy(x -> x.toString().toLowerCase(),
            Collectors.summingInt(x -> Character.isUpperCase(x) ? -1 : 1)));
  }

}
