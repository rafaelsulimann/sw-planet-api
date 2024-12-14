package com.sulimann.sw_planet_api.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class PlanetTest {

  @Test
  @DisplayName("Deve instanciar um planeta com sucesso")
  void shouldBeInstaciateAPlanetWithSucess() {
    String name = "Terra";
    String climate = "Topzera";
    String terrain = "Mto boa";

    Planet planet = new Planet(name, climate, terrain);

    assertThat(planet).isNotNull();
    assertThat(planet.getName()).isEqualTo(name);
    assertThat(planet.getClimate()).isEqualTo(climate);
    assertThat(planet.getTerrain()).isEqualTo(terrain);
  }

  @ParameterizedTest
  @DisplayName("deve lançar uma exceção ao instanciar um planeta dados inválidos")
  @MethodSource("invalidArgumentsProvider")
  void shouldBeThrowAIllegalArgumentExceptionWhenDataIsInvalid(String name, String climate, String terrain,
      String errorMessage) {
    assertThatThrownBy(() -> new Planet(name, climate, terrain))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining(errorMessage);
  }

  static Stream<Arguments> invalidArgumentsProvider() {
    return Stream.of(
        Arguments.of("", "Topzera", "Mto boa", "Name cannot be blank or null"),
        Arguments.of(null, "Topzera", "Mto boa", "Name cannot be blank or null"),
        Arguments.of("Terra", "", "Mto boa", "Climate cannot be blank or null"),
        Arguments.of("Terra", null, "Mto boa", "Climate cannot be blank or null"),
        Arguments.of("Terra", "Topzera", "", "Terrain cannot be blank or null"),
        Arguments.of("Terra", "Topzera", null, "Terrain cannot be blank or null"));
  }

}
