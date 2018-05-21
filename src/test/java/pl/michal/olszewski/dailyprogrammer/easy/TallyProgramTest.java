package pl.michal.olszewski.dailyprogrammer.easy;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;
import org.junit.jupiter.api.Test;

class TallyProgramTest {

  @Test
  void shouldCalculate() {
    Map<String, Integer> abcde = TallyProgram.calculate("abcde");

    assertThat(abcde).hasSize(5);
    assertThat(abcde.get("a")).isEqualTo(1);
    assertThat(abcde.get("b")).isEqualTo(1);
    assertThat(abcde.get("c")).isEqualTo(1);
    assertThat(abcde.get("d")).isEqualTo(1);
    assertThat(abcde.get("e")).isEqualTo(1);
  }

  @Test
  void shouldCalculateForMoreDifficultExample() {
    Map<String, Integer> abcde = TallyProgram.calculate("dbbaCEDbdAacCEAadcB");

    assertThat(abcde).hasSize(5);
    assertThat(abcde.get("a")).isEqualTo(1);
    assertThat(abcde.get("b")).isEqualTo(2);
    assertThat(abcde.get("c")).isEqualTo(0);
    assertThat(abcde.get("d")).isEqualTo(2);
    assertThat(abcde.get("e")).isEqualTo(-2);
  }
}