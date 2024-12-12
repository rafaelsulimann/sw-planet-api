package com.sulimann.sw_planet_api.domain;

import static com.sulimann.sw_planet_api.common.PlanetConstants.PLANET;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

@SpringBootTest(classes = PlanetService.class)
public class PlanetServiceTest {

  @Autowired
  private PlanetService planetService;

  @MockitoBean
  private PlanetRepository planetRepository;

  @Test
  public void createPlanet_WithValidData_ReturnsPlanet(){
    // AAA
    // Arrange
    when(planetRepository.save(PLANET)).thenReturn(PLANET);

    // Act
    // system under test
    Planet sut = this.planetService.create(PLANET);

    // Assert
    assertThat(sut).isEqualTo(PLANET);
  }

}
