package pl.michal.olszewski.dailyprogrammer.intermediate;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class UnwrapSomeText {

  public static void main(String[] args) throws IOException {
    String result = Files.readAllLines(Paths.get("text.txt"))
        .stream()
        .map(line -> line + (line.charAt(line.length() - 1) == '.' ? "\n" : ""))
        .collect(Collectors.joining("\n")).trim();

    System.out.println(result);
  }
}
