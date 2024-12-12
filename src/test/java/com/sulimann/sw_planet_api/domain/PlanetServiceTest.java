package com.sulimann.sw_planet_api.domain;

import static com.sulimann.sw_planet_api.common.PlanetConstants.PLANET;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class PlanetServiceTest {

  @InjectMocks
  private PlanetService planetService;

  @Mock
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
