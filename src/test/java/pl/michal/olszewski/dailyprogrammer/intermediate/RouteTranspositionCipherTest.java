package pl.michal.olszewski.dailyprogrammer.intermediate;

import static org.assertj.core.api.Assertions.assertThat;
import static pl.michal.olszewski.dailyprogrammer.intermediate.RouteTranspositionCipher.splitStringForColumnsAndRows;

import org.junit.jupiter.api.Test;

class RouteTranspositionCipherTest {

  @Test
  void shouldSplitTextFor3ColumnAnd1Row() {
    String result = splitStringForColumnsAndRows("ABC", 3);
    assertThat(result).isEqualTo("ABC");
    assertThat(result.split("\n")).hasSize(1);
    assertThat(result.split("\n")[0]).hasSize(3);
  }

  @Test
  void shouldSplitShorterTextFor3ColumnAnd1Row() {
    String result = splitStringForColumnsAndRows("AB", 3);
    assertThat(result).isEqualTo("ABX");
    assertThat(result.split("\n")).hasSize(1);
    assertThat(result.split("\n")[0]).hasSize(3);
  }

  @Test
  void shouldSplitTextFor1ColumnAnd3Row() {
    String result = splitStringForColumnsAndRows("ABC", 1);
    assertThat(result).isEqualTo("A\nB\nC");
    assertThat(result.split("\n")).hasSize(3);
    assertThat(result.split("\n")[0]).hasSize(1);
  }

  @Test
  void shouldSplitTextAndUpperCase() {
    String result = splitStringForColumnsAndRows("example", 4);
    assertThat(result).isEqualTo("EXAM\nPLEX");
    assertThat(result.split("\n")).hasSize(2);
    assertThat(result.split("\n")[0]).hasSize(4);
  }

  @Test
  void shouldRemoveSpacesFromTextAndSplitText() {
    String result = splitStringForColumnsAndRows("This is an example", 6);
    assertThat(result).isEqualTo("THISIS\nANEXAM\nPLEXXX");
  }

  @Test
  void shouldFillEmptySpacesWithX() {
    String result = RouteTranspositionCipher.fillEmptySpacesWithX("AB", 4);
    assertThat(result).isEqualTo("ABXX");
  }

  @Test
  void shouldGetLastRowNotReversed() {
    String s = "ABC\nDEF\nGHI";
    String result = RouteTranspositionCipher.getRowFromStringWithRotation(s, false, 3);
    assertThat(result).isEqualTo("GHI");
  }

  @Test
  void shouldGetFirstRowAndReversed() {
    String s = "ABC\nDEF\nGHI";
    String result = RouteTranspositionCipher.getRowFromStringWithRotation(s, true, 1);
    assertThat(result).isEqualTo("CBA");
  }

  @Test
  void shouldGetLastColumnNotReversed() {
    String s = "ABC\nDEF\nGHI";
    String result = RouteTranspositionCipher.getColumnFromStringWithRotation(s, false, 3);
    assertThat(result).isEqualTo("CFI");
  }

  @Test
  void shouldGetFirstColumnAndReversed() {
    String s = "ABC\nDEF\nGHI";
    String result = RouteTranspositionCipher.getColumnFromStringWithRotation(s, true, 1);
    assertThat(result).isEqualTo("GDA");
  }

  @Test
  void shouldIterateOverStringWithClockwiseDirection() {
    String s = "ABCDE\nFGHIJ\nKLMNO";
    String s1 = RouteTranspositionCipher.iterateOverStringClockwiseRotation(s, 3, 5);
    assertThat(s1).isEqualTo("EJONMLKFABCDIHG");
  }

  @Test
  void shouldIterateOverStringWithCounterClockwiseDirection() {
    String s = "ABCDE\nFGHIJ\nKLMNO";
    String s1 = RouteTranspositionCipher.iterateOverStringCounterClockwiseRotation(s, 3, 5);
    assertThat(s1).isEqualTo("EDCBAFKLMNOJIHG");
  }

  @Test
  void shouldCalculateClockwise() {
    assertThat(RouteTranspositionCipher.calculateClockwise("WE ARE DISCOVERED. FLEE AT ONCE", 9, 3)).isEqualTo("CEXXECNOTAEOWEAREDISLFDEREV");
    assertThat(RouteTranspositionCipher.calculateClockwise("For lunch let's have peanut-butter and bologna sandwiches", 4, 12)).isEqualTo("LHSENURBGAISEHCNNOATUPHLUFORCTVABEDOSWDALNTTEAEN");
    assertThat(RouteTranspositionCipher.calculateClockwise("I've even witnessed a grown man satisfy a camel", 9, 5)).isEqualTo("IGAMXXXXXXXLETRTIVEEVENWASACAYFSIONESSEDNAMNW");
  }

  @Test
  void shouldCalculateCounter_Clockwise() {
    assertThat(RouteTranspositionCipher.calculateCounterClockwise("why is this professor so boring omg", 6, 5)).isEqualTo("TSIYHWHFSNGOMGXIRORPSIEOBOROSS");
    assertThat(RouteTranspositionCipher.calculateCounterClockwise("Solving challenges on r/dailyprogrammer is so much fun!!", 8, 6)).isEqualTo("CGNIVLOSHSYMUCHFUNXXMMLEGNELLAOPERISSOAIADRNROGR");
    assertThat(RouteTranspositionCipher.calculateCounterClockwise("Why does it say paper jam when there is no paper jam?", 3, 14)).isEqualTo("YHWDSSPEAHTRSPEAMXJPOIENWJPYTEOIAARMEHENAR");
  }
}