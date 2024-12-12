package com.sulimann.sw_planet_api.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.DisplayName;
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
  @DisplayName("Deve criar um planeta chamando o repository.save e retornando o planeta criado")
  void createPlanet_WithValidData_ThenReturnsPlanet(){
    var planetToCreate = Planet.builder()
      .name("Terra")
      .climate("Topzera")
      .terrain("Mto boa")
      .build();

    var planetCreated = Planet.builder()
      .id(1L)
      .name("Terra")
      .climate("Topzera")
      .terrain("Mto boa")
      .build();

    when(this.planetRepository.save(planetToCreate)).thenReturn(planetCreated);

    Planet sut = this.planetService.create(planetToCreate);

    verify(this.planetRepository).save(planetToCreate);
    assertThat(sut).isEqualTo(planetCreated);
  }


}
