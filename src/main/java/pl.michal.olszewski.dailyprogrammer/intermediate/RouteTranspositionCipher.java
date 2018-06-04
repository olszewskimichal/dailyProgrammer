package pl.michal.olszewski.dailyprogrammer.intermediate;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * https://www.reddit.com/r/dailyprogrammer/comments/8n8tog/20180530_challenge_362_intermediate_route/
 */
class RouteTranspositionCipher {

  static String calculateClockwise(String line, int columns, int rows) {
    String splittedLine = splitStringForColumnsAndRows(line, columns);
    return iterateOverStringClockwiseRotation(splittedLine, rows, columns);
  }

  static String calculateCounterClockwise(String line, int columns, int rows) {
    String splittedLine = splitStringForColumnsAndRows(line, columns);
    return iterateOverStringCounterClockwiseRotation(splittedLine, rows, columns);
  }

  static String splitStringForColumnsAndRows(String row, int columns) {
    boolean isOver = true;
    StringBuilder result = new StringBuilder();
    row = row.replace(" ", "");
    row = row.replace("!", "");
    row = row.replace(".", "");
    row = row.replace("'", "");
    row = row.replace("-", "");
    row = row.replace("/", "");
    row = row.replace("?", "");
    do {
      if (row.length() <= columns) {
        String s = fillEmptySpacesWithX(row, columns);
        row = "";
        isOver = false;
        result.append(s);
      } else {
        String s = row.substring(0, columns);
        row = row.replaceFirst(s, "");
        result.append(s).append("\n");
      }

    } while (isOver);

    return result.toString().toUpperCase();

  }

  static String fillEmptySpacesWithX(String s, int column) {
    int diff = column - s.length();
    String collect = Stream.generate(() -> "X").limit(diff).collect(Collectors.joining(""));
    return s + collect;
  }

  static String iterateOverStringCounterClockwiseRotation(String s, int row, int column) {
    int maxRow = row;
    int maxColumn = column;
    StringBuilder result = new StringBuilder();
    do {
      if (maxRow >= 1 && maxColumn > 0) {
        result.append(getRowFromStringWithRotation(s, true, 1));
        s = clearRow(s, 1);
        maxRow--;
      }

      if (maxColumn >= 1 && maxRow > 0) {
        result.append(getColumnFromStringWithRotation(s, false, 1));
        s = clearColumn(s, 1);
        maxColumn--;
      }

      if (maxRow >= 1 && maxColumn > 0) {
        result.append(getRowFromStringWithRotation(s, false, maxRow));
        s = clearRow(s, maxRow);
        maxRow--;
      }

      if (maxColumn >= 1 && maxRow > 0) {
        result.append(getColumnFromStringWithRotation(s, true, maxColumn));
        s = clearColumn(s, maxColumn);
        maxColumn--;
      }

    } while (!s.isEmpty() && !s.replace("\n", "").isEmpty());
    return result.toString();
  }

  static String iterateOverStringClockwiseRotation(String s, int row, int column) {
    int maxRow = row;
    int maxColumn = column;
    StringBuilder result = new StringBuilder();
    do {

      if (maxColumn >= 1 && maxRow > 0) {
        result.append(getColumnFromStringWithRotation(s, false, maxColumn));
        s = clearColumn(s, maxColumn);
        maxColumn--;
      }

      if (maxRow >= 1 && maxColumn > 0) {
        result.append(getRowFromStringWithRotation(s, true, maxRow));
        s = clearRow(s, maxRow);
        maxRow--;
      }

      if (maxColumn >= 1 && maxRow > 0) {
        result.append(getColumnFromStringWithRotation(s, true, 1));
        s = clearColumn(s, 1);
        maxColumn--;
      }

      if (maxRow >= 1 && maxColumn > 0) {
        result.append(getRowFromStringWithRotation(s, false, 1));
        s = clearRow(s, 1);
        maxRow--;
      }

    } while (!s.isEmpty() && !s.replace("\n", "").isEmpty());
    return result.toString();
  }

  static String getRowFromStringWithRotation(String s, boolean reversed, int whichRow) {
    String result = s.split("\n")[whichRow - 1];
    if (reversed) {
      return new StringBuilder(result).reverse().toString();
    }

    return result;
  }

  static String getColumnFromStringWithRotation(String s, boolean reversed, int whichColumn) {
    String result = Stream.of(s.split("\n"))
        .map(v -> v.charAt(whichColumn - 1) + "")
        .collect(Collectors.joining(""));
    if (reversed) {
      return new StringBuilder(result).reverse().toString();
    }
    return result;
  }

  private static String clearRow(String s, int whichRow) {
    String result = s.split("\n")[whichRow - 1];
    if (s.split("\n").length == 1) {
      return s.replace(result, "");
    }
    if (whichRow - 1 == 0) {
      return s.replace(result + "\n", "");
    }
    return s.replace("\n" + result, "");
  }

  private static String clearColumn(String s, int whichColumn) {
    return Stream.of(s.split("\n"))
        .map(v -> v = replaceCharAt(v, whichColumn - 1))
        .collect(Collectors.joining("\n"));
  }

  private static String replaceCharAt(String s, int pos) {
    return s.substring(0, pos) + s.substring(pos + 1);
  }


}
